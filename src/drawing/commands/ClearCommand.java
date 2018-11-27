package drawing.commands;
import java.util.ArrayList;
import java.util.List;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
public class ClearCommand implements ICommand {
    private DrawingPane pane;
    private List<IShape> shapes;

    public ClearCommand(DrawingPane receiver) {
        this.pane = receiver;
        shapes = new ArrayList<>();
    }

    @Override
    public void execute() {
        shapes = this.pane.getShapes();
        pane.clear();
    }
    @Override
    public void undo() {
        for(IShape shape : shapes)
            this.pane.addShape(shape);
        shapes.clear();
    }
}