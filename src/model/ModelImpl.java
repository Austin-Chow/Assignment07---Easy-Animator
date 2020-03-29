package model;

import java.util.ArrayList;
import java.util.List;

import shape.Shape;

/**
 * ModelImpl implements methods associated with the animation model such as adding shapes, adding
 * moves to shapes, adding color changes to shapes, adding scaling to shapes, and (only until we
 * have created a proper view) printing out the added shapes and their move/color/scaling changes.
 */
public class ModelImpl implements IModel {
  private List<Shape> listOfShapes;

  /**
   * Lazy instantiation of our List containing Shapes.
   */
  public ModelImpl() {
    this.listOfShapes = new ArrayList<Shape>();
  }

  /**
   * Adds a shape to our ModelImpl, allowing us to keep track of it. If the shape has already
   * been added to ModelImpl, throws an IAE.
   * @param shape representing a Shape object.
   * @throws IllegalArgumentException if the Shape object has already been added.
   */
  public void addShape(Shape shape) throws IllegalArgumentException {
    if (this.listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("This shape has already been added to the model.");
    }
    else {
      this.listOfShapes.add(shape);
    }
  }

  /**
   * Moves the specified shape from its current position to (endPosX,endPosY) from
   * time t=startTick to t=endTick. If the shape has not been added to the ModelImpl,
   * throws an IAE.
   * @param shape the shape being moved.
   * @param endPosX X-coordinate that the shape will end at.
   * @param endPosY Y-coordinate that the shape will end at.
   * @param startTime start time that the shape will start moving at.
   * @param endTime end time that the shape will stop moving at.
   * @throws IllegalArgumentException if Shape object has not been added to ModelImpl, or if
   *     Shape's addMove throws an IAE.
   */
  public void addMove(Shape shape, double endPosX, double endPosY, int startTime, int endTime)
          throws IllegalArgumentException {
    if (!this.listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been added to our ModelImpl.");
    }
    else {
      shape.addMove(endPosX, endPosY, startTime, endTime);
    }
  }

  /**
   * Changes the specified shape color from its current color to the specified (red,green,blue)
   * color from time t=startTime to t=endTime. If the shape has not been added to the ModelImpl,
   * throws an IAE.
   * @param shape the shape that is getting its color changed.
   * @param red integer representing intensity of red hue from 0-255.
   * @param green integer representing intensity of green hue from 0-255.
   * @param blue integer representing intensity of blue hue from 0-255.
   * @param startTime start time that the shape will start changing color at.
   * @param endTime end time that the animation will stop changing color at.
   * @throws IllegalArgumentException if Shape object has not been added to ModelImpl, or if
   *     Shape's addChangeColor throws an IAE
   */
  @Override
  public void addChangeColor(Shape shape, int red, int green, int blue, int startTime, int endTime)
          throws IllegalArgumentException {
    if (!this.listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      shape.addChangeColor(red, green, blue, startTime, endTime);
    }
  }

  /**
   * Changes the specified shape's left-to-right side (X-radius for oval, width for rectangle)
   * to the specified leftToRightNewDimension and the up-to-down side
   * (Y-radius for oval, height for rectangle) to the specified upToDownNewDimension from time
   * t=startTime to t=endTime. If the shape has not been added to the ModelImpl,
   * throws an IAE.
   * @param shape the shape that is getting its dimensions scaled.
   * @param leftToRightNewDimension new length of the shape's left-to-right side.
   * @param upToDownNewDimension new length of the shape's up-to-down side.
   * @param startTime start time that the shape will start scaling its dimensions at.
   * @param endTime end time that the animation will stop scaling its dimensions at.
   * @throws IllegalArgumentException if Shape object has not been added to ModelImpl, or if
   *     Shape's addScale throws an IAE.
   */
  @Override
  public void addScale(Shape shape, double leftToRightNewDimension, double upToDownNewDimension,
                       int startTime, int endTime) throws IllegalArgumentException {
    if (!this.listOfShapes.contains(shape)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      shape.addScale(leftToRightNewDimension, upToDownNewDimension, startTime, endTime);
    }
  }

  /**
   * Returns a text description of the animation as follows:
   * -Shapes with their names, types, location, color, appears and disappears timers.
   * -Each shape's "motion" operations describing how the shape was changed.
   *
   * <p>An example is as follows:</p>
   *
   * <p>Shapes:
   * Name: R
   * Type: rectangle
   * Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
   * Appears at t=1
   * Disappears at t=100</p>
   *
   * <p>Name: C
   * Type: oval
   * Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)
   * Appears at t=6
   * Disappears at t=100</p>
   *
   * <p>Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
   * Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70
   * Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
   * Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
   * Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100</p>
   *
   * <p>Our output will be very similar to the above output, except instead of returning the
   * colors in 0.0-1.0 format they will be in 0-255 format. (Professor Clark said this was OK.)</p>
   *
   * <p>This method is only here until we can come up with a proper view for the animation!</p>
   */
  public String toString() {
    String returned = "";
    returned += "Shapes: \n";
    for (Shape shape: this.listOfShapes) {
      returned += shape.toString() + "\n";
    }
    for (Shape shape: this.listOfShapes) {
      returned += shape.getMotionToStrings();
    }
    return returned;
  }

}
