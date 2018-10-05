package drawing;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class StatutBar extends HBox implements Observer{
    private Label labelForm;
    private DrawingPane dp;

    public StatutBar(DrawingPane drawingPane) {
        this.dp = drawingPane;
        this.labelForm = new Label("0 shapes(s)");
        this.getChildren().addAll(this.labelForm);
    }

    public void update () {
        this.labelForm.setText(this.dp.getNumberShape() + " shape(s)");
    }
}
