package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.DegroupButtonHandler;
import drawing.handlers.GroupButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import drawing.commands.ClearCommand;

public class ToolBar extends HBox {

    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button deleteButton;
    private Button groupButton;
    private Button degroupButton;

    public ToolBar(DrawingPane drawingPane) {

        FactoryButton factory = new FactoryButton();

        clearButton = factory.createButton(FactoryButton.CLEAR);
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(new ClearCommand(drawingPane)));
        rectangleButton = factory.createButton(FactoryButton.RECTANLGE);
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        circleButton = factory.createButton(FactoryButton.CIRCLE);
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        triangleButton = factory.createButton(FactoryButton.TRIANGLE);
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
        deleteButton = factory.createButton(FactoryButton.DELETE);
        deleteButton.addEventFilter(ActionEvent.ACTION, new DeleteButtonHandler(drawingPane));
        groupButton = factory.createButton(FactoryButton.GROUP);
        groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(drawingPane));
        degroupButton = factory.createButton(FactoryButton.DEGROUP);
        degroupButton.addEventFilter(ActionEvent.ACTION, new DegroupButtonHandler(drawingPane));

        this.getChildren().addAll(clearButton, rectangleButton, circleButton,triangleButton, deleteButton, groupButton, degroupButton);
        this.setPadding(new Insets(5));
        this.setSpacing(5.0);
        this.getStyleClass().add("toolbar");
    }
}
