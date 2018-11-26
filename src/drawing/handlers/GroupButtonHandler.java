package drawing.handlers;
import java.util.List;
import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class GroupButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane dPane;

    public GroupButtonHandler(DrawingPane drawingPane) {
        this.dPane = drawingPane;
    }
    @Override
    public void handle(ActionEvent event)
    {
        List<IShape> selectedShapes = dPane.getSelection();
        ShapeGroup group = new ShapeGroup();
        group.addAllShapes(selectedShapes);

        for(IShape s : group.getShapes())
            dPane.removeShape(s);

        dPane.addShape(group);
    }
}