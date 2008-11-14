package scrum.client.sprint;

import scrum.client.ScrumGwtApplication;
import scrum.client.common.ABlockWidget;
import scrum.client.common.ItemFieldsWidget;
import scrum.client.common.StyleSheet;
import scrum.client.dnd.BlockListDropController;
import scrum.client.img.Img;
import scrum.client.project.BacklogItem;
import scrum.client.workspace.WorkspaceWidget;

import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SprintBacklogItemWidget extends ABlockWidget {

	private BacklogItem item;

	public SprintBacklogItemWidget(BacklogItem item) {
		this.item = item;
	}

	@Override
	protected Widget buildContent() {
		if (!isExtended()) { return new Label(item.getSummary()); }

		ItemFieldsWidget fieldsWidget = new ItemFieldsWidget();
		fieldsWidget.addField("Description", new Label(item.getDescription()));
		fieldsWidget.addField("Test", new Label(item.getTestDescription()));
		fieldsWidget.addField("Effort", new Label(item.getEffortString()));
		fieldsWidget.addField("", new Label("hier kommen todos..."));
		return fieldsWidget;
	}

	@Override
	protected Widget buildToolbar() {
		if (!isExtended()) return null;
		VerticalPanel toolbar = new VerticalPanel();
		toolbar.setStyleName(StyleSheet.TOOLBAR);

		Button removeButton = new Button("Remove");
		removeButton.addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
			// ScrumGwtApplication.get().getProject().deleteBacklogItem(item);
			// WorkspaceWidget.backlog.list.removeSelectedRow();
			}
		});
		toolbar.add(removeButton);

		if (!item.isDone()) {
			Button solveButton = new Button("Done");
			solveButton.addClickListener(new ClickListener() {

				public void onClick(Widget sender) {
					item.setDone(true);
					rebuild();
				}
			});
			toolbar.add(solveButton);
		} else {
			Button unsolveButton = new Button("Undone");
			unsolveButton.addClickListener(new ClickListener() {

				public void onClick(Widget sender) {
					item.setDone(false);
					rebuild();
				}
			});
			toolbar.add(unsolveButton);
		}

		return toolbar;
	}

	@Override
	protected String getBlockTitle() {
		return item.getLabel();
	}

	@Override
	protected AbstractImagePrototype getIcon() {
		if (item.isDone()) return Img.bundle.backlogItemDoneIcon32();
		return Img.bundle.backlogItemIcon32();
	}

	@Override
	public void delete() {
		ScrumGwtApplication.get().getProject().deleteBacklogItem(item);
		WorkspaceWidget.backlog.list.remove(this);
	}

	@Override
	protected DropController getDropController() {
		return new BlockListDropController(this, WorkspaceWidget.backlog.list);
	}
}
