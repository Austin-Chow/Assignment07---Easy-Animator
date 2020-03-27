package cs5004.model;

import java.awt.*;

import cs5004.shape.Shape;

public interface IModel {

  void addShape(Shape shape);

  void addMove(Shape shape, double endPosX, double endPosY, int startTick, int endTick);

  void addChangeColor(Shape shape, int red, int green, int blue, int startTime, int endTime);

  void addScaling(Shape shape, double leftToRightNewDimension, double upToDownNewDimension, int startTime, int endTime);
}
