package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RedoButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane pane;

    public RedoButtonHandler(DrawingPane drawingPane) {
        this.pane = drawingPane;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.pane.getHistory().redo();
    }

}
