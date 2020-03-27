package cs5004.motion;

import cs5004.shape.AbstractShape;

public class ChangeColor extends AbstractMotion {

  int red;
  int green;
  int blue;

  public ChangeColor(int red, int green, int blue, int startTime, int endTime) {
    super(startTime, endTime);
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
}
