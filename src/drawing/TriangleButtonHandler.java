package drawing;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class TriangleButtonHandler extends ShapeButtonHandler {
    public TriangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }
    @Override
    protected Shape createShape() {
        double x = Math.min(originX, destinationX);
        double y = Math.min(originY, destinationY);
        double width = Math.abs(destinationX - originX);
        double height = Math.abs(destinationY - originY);
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{
                x, y,
                x+width, y+height,
                x-width, y+height
                });

        triangle.getStyleClass().add("rectangle");
        return triangle;
    }
}
