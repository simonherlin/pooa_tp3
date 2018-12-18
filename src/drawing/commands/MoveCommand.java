package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;

public class MoveCommand implements ICommand{

    private List<IShape> shapes;
    private double offsetX;
    private double offsetY;

    public MoveCommand(List<IShape> shapes, double offsetX, double offsetY) {
        this.shapes = new ArrayList<>();
        shapes.forEach(shape -> this.shapes.add(shape));
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public void execute() {
        shapes.forEach(shape -> shape.offset(offsetX, offsetY));
    }

    @Override
    public void undo() {
        shapes.forEach(shape -> shape.offset(-offsetX, -offsetY));
    }

}
