package drawing.handlers;

import java.util.ArrayList;
import java.util.List;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane dp;

    public DeleteButtonHandler(DrawingPane drawingPane) {
        this.dp = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        List<IShape> selectedShapes = this.dp.getSelection();
        List<IShape> shapes = new ArrayList<IShape>();
        dp.iterator().forEachRemaining(shapes::add);
        for(IShape shape : shapes)
        {
            if(selectedShapes.contains(shape))
                dp.removeShape(shape);
        }
    }

}
