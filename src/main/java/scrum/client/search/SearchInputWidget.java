package scrum.client.search;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.Gwt;
import scrum.client.common.AScrumWidget;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SearchInputWidget extends AScrumWidget {

	private Search search;
	private TextBox input;
	private boolean dirty;

	@Override
	protected Widget onInitialization() {
		search = Scope.get().getComponent(Search.class);

		input = new TextBox();
		input.addKeyUpHandler(new InputHandler());

		SearchTimer timer = new SearchTimer();
		timer.scheduleRepeating(1000);

		return Gwt.createDiv("SearchInputWidget", input);
	}

	private void submitSearch() {
		dirty = false;
		search.search(input.getText());
	}

	class InputHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			dirty = true;
		}

	}

	class SearchTimer extends Timer {

		@Override
		public void run() {
			if (dirty) {
				submitSearch();
			}
		}

	}

}
