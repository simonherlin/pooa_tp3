package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane pane;

    public UndoButtonHandler(DrawingPane dPane) {
        this.pane = dPane;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.pane.getHistory().undo();
    }

}
