package drawing;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane dPane;

    public ClearButtonHandler(DrawingPane dp)
    {
        dPane = dp;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        dPane.clear();
    }

}