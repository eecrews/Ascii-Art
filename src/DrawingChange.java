//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java, Canvas.java,
//                  AsciiArtTester.java, StackADT.java, LinkedNode.java
// Course:          CS 300

/*
 * This class contains the details of a singular change to the canvas.
 */
public class DrawingChange {
  public final int row; // row (y-coordinate) for this DrawingChange
  public final int col; // col (x-coordinate) for this DrawingChange
  public final char prevChar; // previous character in the (row,col) position
  public final char newChar; // new character in the (row,col) position
  
  /*
   * Constructor that initializes a new DrawingChange object with the specified information.
   * 
   * @param row the row in which the character is going to be added
   * 
   * @param col the column in which the character is going to be added
   * 
   * @param prevChar the character that is being replaced by the DrawingChange
   * 
   * @param newChar the new character that is being implemented by the DrawingChange
   * 
   */
  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
