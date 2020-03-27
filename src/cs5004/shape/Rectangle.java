package cs5004.shape;

import java.awt.*;

public class Rectangle extends AbstractShape {
  public Rectangle(int red, int green, int blue, String name, double posX, double posY,
                   double height, double width, int appears, int disappears) {
    super(red, green, blue, name, posX, posY, height, width, appears, disappears);

    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Both width and height must be non-negative.");
    }

    System.out.println("Name: " + this.getName() + "\n" +
            "Type: rectangle\n" +
            "Min corner: (" + this.posX + "," + this.posY +"), Width: " + this.getWidth() +
            ", Height: " + this.getHeight() + ", Color: " + this.getColor() + "\n" +
            "Appears at t=" + this.getAppears() + "\n" +
            "Disappears at t=" + this.getDisappears());
  }

  @Override
  public String scale(double leftToRightNewDimension, double upToDownNewDimension,  int startTime, int endTime) throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.getAppears()) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.getDisappears()) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    double currWidth = this.getWidth();
    double currHeight = this.getHeight();

    this.width = leftToRightNewDimension;
    this.height = upToDownNewDimension;

    return "Shape " + this.getName() + " scales from Width: " + currWidth +
            ", Height: " + currHeight + " to Width: " + leftToRightNewDimension +
            ", Height: " + upToDownNewDimension + " from time t=" + startTime + " to t=" + endTime;
  }
}