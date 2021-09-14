//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java, Canvas.java,
//                  AsciiArtTester.java, StackADT.java, LinkedNode.java
// Course:          CS 300, Fall Term, 2019
//
// Author:          Erin Crews
// Email:           eecrews@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/*
 * Represents an ASCII-art image. A user can draw a new character onto the canvas, undo a previously
 * drawn character, redo a previously undid character, and print out a visual representation of the
 * canvas in whatever state it's in. The characters are stored in a 2d array.
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char [][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  /* 
   * Constructor that initializes a new, blank canvas object. Each space is filled with the char
   * value ' ' (a space).
   * 
   * @param width the amount of characters that make up the Canvas' width
   * 
   * @param height the amount of characters that make up the Canvas' height
   * 
   * @throws IllegalArgumentException if either width or height are 0 or below
   */
  public Canvas(int width, int height) {
    if(width <=0 || height <= 0)
      throw new IllegalArgumentException("Width and height both must be above 0.");
    
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    for(int i=0; i<drawingArray.length; i++) {
      for(int j=0; j<drawingArray[i].length; j++)
        drawingArray[i][j] = ' ';
    }
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }

  /*
   * Draws a certain character at a given position. If given position already contains a character,
   * the current character is replaced with the new one. A DrawingChange object representing this
   * change is added to the undoStack so the change can be undone. The redoStack is cleared. 
   * 
   * @param row the row in which the character is going to be added
   * 
   * @param col the column in which the character is going to be added
   * 
   * @param c the character to be added
   * 
   * @throws IllegalArgumentException if either the row or column inputted is invalid, meaning they
   * are below 0 or would be outside the bounds of the canvas
   */
  public void draw(int row, int col, char c) {
    if(row > height || col > width || row < 0 || col < 0)
      throw new IllegalArgumentException("Drawing position is outside the canvas.");
    
    char temp = drawingArray[row][col];
    drawingArray[row][col] = c;
    undoStack.push(new DrawingChange(row, col, temp, c));
    while(!redoStack.isEmpty())
      redoStack.pop();
  }

  /*
   * Undoes the most recent drawing change on the Canvas. An undone DrawingChange is popped off the
   * undoStack and pushed onto the redoStack so it can be redone. The drawingArray is updated to
   * reflect this change.
   * 
   * @return true if the undo operation is successful, false otherwise
   */
  public boolean undo() {
    if(undoStack.isEmpty())
      return false;
    
    DrawingChange undone = undoStack.pop();
    redoStack.push(undone);
    drawingArray[undone.row][undone.col] = undone.prevChar;
    return true;
  }

  /*
   * Redoes the most recent undone drawing change. A redone DrawingChange is popped off the redoStack
   * and pushed onto the undoStack so it can be undone. The drawingArray is updated to reflect this
   * change.
   * 
   * @return true if the redo operation is successful, false otherwise
   */
  public boolean redo() {
    if(redoStack.isEmpty())
      return false;
    
    DrawingChange redone = redoStack.pop();
    undoStack.push(redone);
    drawingArray[redone.row][redone.col] = redone.newChar;
    return true;
  }

  /*
   * Returns a printable String version of the Canvas, with each character in the drawingArray
   * displayed. There is a new line in between each row.
   * 
   * @return String representation of the drawingArray, with blank spots in the array being 
   * represented by a "_" 
   */
  public String toString() {

    String message = "";
    for(int i=0; i<drawingArray.length; i++) {
      for(int j=0; j<drawingArray[i].length; j++) {
        if(drawingArray[i][j] == ' ')
          message += "_";
        else
          message += drawingArray[i][j];
      }
      message += System.lineSeparator();
    }
    return message;
  }
  
}
