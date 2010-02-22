package scrum.server.files;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;
import ilarkesto.base.PermissionDeniedException;
import ilarkesto.core.logging.Log;
import ilarkesto.io.IO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import scrum.server.GwtConversation;
import scrum.server.ScrumWebApplication;
import scrum.server.WebSession;
import scrum.server.project.Project;

public class FileUploadServlet extends UploadAction {

	private static final Log LOG = Log.get(FileUploadServlet.class);

	@Override
	public String executeAction(HttpServletRequest request, List<FileItem> sessionFiles) throws UploadActionException {
		ScrumWebApplication webApp = ScrumWebApplication.get();
		WebSession session = (WebSession) webApp.getWebSession(request);
		Project project = session.getGwtConversation().getProject();
		if (project == null) throw new PermissionDeniedException();

		for (FileItem item : sessionFiles) {
			if (item.isFormField()) continue;
			try {
				String filename = getFilename(item.getName());
				java.io.File f = new java.io.File(project.getFileRepositoryPath() + "/" + filename);
				int count = 0;
				while (f.exists()) {
					count++;
					f = new java.io.File(project.getFileRepositoryPath() + "/" + insertSuffix(filename, count));
				}
				IO.copyDataToFile(item.getInputStream(), f);

				File file = webApp.getFileDao().postFile(f, project);
				webApp.getTransactionService().commit();
				for (GwtConversation conversation : webApp.getConversationsByProject(project, null)) {
					conversation.sendToClient(file);
				}
				return file.getReference();
			} catch (Exception e) {
				LOG.error(e);
				throw new UploadActionException(e.getMessage());
			}
		}
		return null;
	}

	private String insertSuffix(String name, int count) {
		int idx = name.lastIndexOf('.');
		if (idx > 0) return name.substring(0, idx) + "#" + count + name.substring(idx);
		return name + "#" + count;
	}

	private String getFilename(String name) {
		if (name == null) return "unnamed.bin";
		name = name.replace('\\', '/');
		int idx = name.lastIndexOf('/');
		if (idx >= 0) return name.substring(idx + 1);
		return name;
	}

}
