package drawing.handlers;

import java.util.ArrayList;
import java.util.List;

import drawing.commands.ICommand;
import drawing.commands.MoveCommand;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    double offsetX;
    double offsetY;
    private double totalOffsetX;
    private double totalOffsetY;

    private List<IShape> selectedShapes;

    private ICommand command;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
        selectedShapes = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

            selectedShapes = drawingPane.getSelection();

            totalOffsetX = 0;
            totalOffsetY = 0;
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShapes.size() == 0)
                return;

            offsetX = event.getSceneX() - orgSceneX;
            offsetY = event.getSceneY() - orgSceneY;

            for(IShape shape : selectedShapes)
                shape.offset(offsetX, offsetY);

            totalOffsetX += offsetX;
            totalOffsetY += offsetY;

            orgSceneX += offsetX;
            orgSceneY += offsetY;
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            if(totalOffsetX > 0 || totalOffsetY > 0) {
                command = new MoveCommand(selectedShapes, totalOffsetX, totalOffsetY);
                for(IShape shape : selectedShapes)
                    shape.offset(-totalOffsetX, -totalOffsetY);
                this.drawingPane.getHistory().exec(command);
            }
            selectedShapes = new ArrayList<>();
        }
    }
}
