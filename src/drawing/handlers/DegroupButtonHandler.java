package drawing.handlers;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;

public class DegroupButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane pane;
    public DegroupButtonHandler(DrawingPane drawingPane) {
        this.pane = drawingPane;
    }
    @Override
    public void handle(ActionEvent event) {
        List<IShape> selectedShapes = this.pane.getSelection();
        List<ShapeGroup> groups = new ArrayList<>();
        for(IShape shape : selectedShapes) {
            if(shape instanceof ShapeGroup) {
                groups.add((ShapeGroup)shape);
            }
        }

        for(ShapeGroup g : groups)
            degroup(g);
    }

    private void degroup(ShapeGroup group) {
        List<IShape> shapes = group.getShapes();
        this.pane.removeShape(group);
        for(IShape s : shapes)
            this.pane.addShape(s);
    }
}