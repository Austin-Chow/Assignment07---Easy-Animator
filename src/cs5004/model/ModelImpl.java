package cs5004.model;

import java.util.ArrayList;
import java.util.List;

import cs5004.shape.Shape;

public class ModelImpl implements IModel {
  List<Shape> listOfShapes = new ArrayList<Shape>();

  public void addShape(Shape shape){
    listOfShapes.add(shape);
  }

  public void addMove(Shape shape, double endPosX, double endPosY, int startTick, int endTick) throws IllegalArgumentException {
    if (!listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      shape.move(endPosX, endPosY, startTick, endTick);
    }
  }

  @Override
  public void addChangeColor(Shape shape, int red, int green, int blue, int startTime, int endTime) throws IllegalArgumentException {
    if (!listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      shape.changeColor(red, green, blue, startTime, endTime);
    }
  }

  @Override
  public void addScaling(Shape shape, double leftToRightNewDimension, double upToDownNewDimension, int startTime, int endTime) {
    if (!listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      shape.scale(leftToRightNewDimension, upToDownNewDimension, startTime, endTime);
    }
  }

//  @Override
//  public String toString() {
//
//  }
}

//  List<AbstractShape> shapes;
//
//  public void addShape(AbstractShape s) {
//    this.shapes.append(s);
//  }
//
//  public void moveShape(String shapeId) {
//    for (AbstractShape shape : this.shapes) {
//      if (shape.id.equals(shapeId)) {
//        AbstractMotion newMove = new AbstractMotion();
//        newMove.setType(AnimationTypes.MOVE);
//        shape.allMotions.append(newMove);
//      }
//    }
//  }