package drawing.ui;

import drawing.handlers.SelectHandler;
import drawing.shapes.IShape;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class StatutBar extends HBox implements Observer {
    private Label labelForm;
    private DrawingPane dp;
    private SelectHandler selectHandler;
    private Label selectLabel;

    public StatutBar(DrawingPane drawingPane) {
        this.dp = drawingPane;
        this.labelForm = new Label("0 shapes(s)");
        this.selectLabel = new Label("0 selected");
        this.getChildren().addAll(this.labelForm);
        this.getChildren().addAll(this.selectLabel);
        this.dp.addObserver(this);
        this.selectHandler = this.dp.getSelectHandler();
        this.selectHandler.addObserver(this);
    }

    public void update () {
        Iterable<IShape> newIterable = () -> dp.iterator();
        // long count = StreamSupport.stream(newIterable.spliterator(), false).count();
        this.labelForm.setText(this.dp.getNumberShape() + " shape(s)");
        this.selectLabel.setText(this.selectHandler.getShapes().size() + " selected");
    }
}
