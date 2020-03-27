package cs5004.shape;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractShape implements Shape {

  //protected List<AbstractMotion> allMotions;
  //List<Move> listOfMoves = new ArrayList<Move>();
  int red;
  int green;
  int blue;

  String name;

  double posX;
  double posY;
  double height;
  double width;
  int appears;
  int disappears;

  //Uses floats for color
  public AbstractShape(int red, int green, int blue, String name, double posX, double posY,
                       double height, double width, int appears, int disappears) throws IllegalArgumentException {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    //if (posX < 0 || posY < 0) {
    //throw new IllegalArgumentException("Make sure posX and posY are non-negative values.");
    //}
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Make sure height and width are greater than 0.");
    }
    if (appears < 0) {
      throw new IllegalArgumentException("Make sure appears is 0 or greater.");
    }
    if (appears > disappears) {
      throw new IllegalArgumentException("Make sure disappear time comes after appear time.");
    }

    this.red = red;
    this.green = green;
    this.blue = blue;

    this.name = name;

    this.posX = posX;
    this.posY = posY;
    this.height = height;
    this.width = width;
    this.appears = appears;
    this.disappears = disappears;
  }


  @Override
  public String getColor() {
    return "(" + this.red + "," + this.green + "," + this.blue +")";
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getPosX() {
    return this.posX;
  }

  @Override
  public double getPosY() {
    return this.posY;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public int getAppears() {
    return this.appears;
  }

  @Override
  public int getDisappears() {
    return this.disappears;
  }


  @Override
  public String move(double endPosX, double endPosY, int startTime, int endTime) throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.getAppears()) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.getDisappears()) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    double currX = this.getPosX();
    double currY = this.getPosY();
    this.posX = endPosX;
    this.posY = endPosY;
    return "Shape " + this.getName() + " moves from (" + currX + "," +
            currY + ") to (" + endPosX + "," + endPosY + ") from time t="
            + startTime + " to t=" + endTime;
  }

  @Override
  public String changeColor(int red, int green, int blue, int startTime, int endTime) {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.getAppears()) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.getDisappears()) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    String currColor = this.getColor();
    this.red = red;
    this.green = green;
    this.blue = blue;
    return "Shape " + this.getName() + " changes color from " + currColor +
            " to (" + red + "," + green + "," + blue  + ") from time t="
            + startTime + " to t=" + endTime;

  }

}
