package cs5004.shape;

import java.awt.*;

//YOU NEED TO USE THESE TO DRAW SHIT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//import java.awt.Graphics;
//import javax.swing.JFrame;
//import javax.awt.Color;
//import javax.swing.JPanel;

/**
 * Notes from TAs and Clark:
 * representation of shape, ability to add shape to model, remove shape
 * ability a transformation to a particular transformation (color change,)
 * string output that dumps everything in the model
 *
 * be able to support other shapes: abstractShape class that your concrete shape class extends
 * the other classes extends your abstractClass
 */

/**
 * This interface contains all operations that all types of shapes
 * should support.
 */
public interface Shape {

  String getColor();

  String getName();

  double getPosX();

  double getPosY();

  double getHeight();

  double getWidth();

  int getAppears();

  int getDisappears();

  String move(double endPosX, double endPosY, int startTime, int endTime);

  String changeColor(int red, int green, int blue, int startTime, int endTime);

  String scale(double leftToRightNewDimension, double upToDownNewDimension, int startTime, int endTime);
}