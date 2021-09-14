//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java, Canvas.java,
//                  AsciiArtTester.java, StackADT.java, LinkedNode.java
// Course:          CS 300

import java.util.EmptyStackException;
import java.util.Iterator;

/*
 * This class tests various public methods and constructors in the DrawingChange, DrawingStack,
 * DrawingStackIterator, and Canvas classes.
 * 
 */
public class AsciiArtTester {
  
  /*
   * This method tests the push method and peek method of the DrawingStack class. First, it checks
   * to see if calling the peek method on an empty stack correctly throws an EmptyStackException. 
   * Then the method pushes a new DrawingChange object onto the stack. If calling the peek method on
   * this stack does not equal what was pushed, it returns false. If the size of the array at this 
   * point does not equal 1, it returns false.
   * 
   * @return true if the push and peek method calls are successful, false otherwise
   * 
   */
  public static boolean testStackPushPeek() {
    DrawingStack x = new DrawingStack();
    try {
      x.peek();
    }
    catch(EmptyStackException e) {
      DrawingChange y = new DrawingChange(2, 2, 'a', 'b');
      x.push(y);
      if(x.peek() != y) return false;
      if(x.size() != 1) return false;
      return true;
    }
    return false;
  }
  
  /*
   * This method tests the pop method of the DrawingStack class. First, it checks to see if calling
   * the pop method on an empty stack correctly throws an EmptyStackException. Then the method
   * pushes two new DrawingChange objects onto the stack. If calling the pop method doesn't return 
   * the added DrawingChanges in a last-in-first-out order, it returns false. 
   * 
   * @return true if the pop method calls are successful, false otherwise
   * 
   */
  public static boolean testPop() {
    DrawingStack x = new DrawingStack();
    try {
      x.pop();
      return false;
    }
   catch(EmptyStackException e) {
      DrawingChange y = new DrawingChange(2, 2, 'a', 'b');
      DrawingChange z = new DrawingChange(3, 3, 'a', 'b');
      x.push(y);
      x.push(z);
      if(x.pop() != z) return false;
      if(x.pop() != y) return false;
      return true;
    }
  }
  
  /*
   * This method tests the size method of the DrawingStack class. It pushes two new 
   * DrawingChange objects onto a DrawingStack. If calling the size method doesn't return the 
   * expected value of 2, it returns false.
   * 
   * @return true if the size method call is successful, false otherwise
   * 
   */
  public static boolean testSize() {
    DrawingStack x = new DrawingStack();
    x.push(new DrawingChange(2, 2, 'a', 'b'));
    x.push(new DrawingChange(3, 3, 'a', 'b'));
    if(x.size() != 2) return false;
    return true;
  }
  
  /*
   * This method tests the DrawingStackIterator object and its next and hasNext methods. First, it
   * creates a DrawingStack and pushes two DrawingChange objects onto the stack. Then it creates a 
   * new iterator from the DrawingStack. If calling the next method on the iterator doesn't return
   * the second DrawingChange, it returns false. If calling the hasNext method on the iterator at
   * this point doesn't return true, the testIterator method returns false. If calling the next
   * method on the iterator at this point doesn't return the first DrawingChange, it returns false.
   * 
   * @return true if the creation of an iterator and the next and hasNext method calls are 
   * successful, false otherwise
   * 
   */
  public static boolean testIterator() {
    DrawingStack x = new DrawingStack();
    DrawingChange drawing1 = new DrawingChange(2, 2, 'X', 'b');
    DrawingChange drawing2 = new DrawingChange(3, 3, 'a', 'b');    
    x.push(drawing1);
    x.push(drawing2);
    
    Iterator<DrawingChange> iterator = x.iterator();
    
    if(iterator.next() != drawing2) return false;
    if(iterator.hasNext() != true) return false;
    if(iterator.next() != drawing1) return false;
    return true;
  }
  
  /*
   * This method tests the undo method of the Canvas class. It draws two characters onto an empty
   * Canvas, then undoes the latest character drawing. 
   * 
   * @return true if the undo method is completed successfully, false otherwise
   * 
   */
  public static boolean testUndo() {
    Canvas x = new Canvas(5,5);
    x.draw(0, 0, 'x');
    x.draw(1, 1, 'y');
    return x.undo();
  }
  
  /*
   * This method tests the redo method of the Canvas class. It draws two characters onto an empty
   * Canvas, undoes the latest character drawing, then redoes the undid character.
   * 
   * @return true if the redo method is completed successfully, false otherwise
   * 
   */
  public static boolean testRedo() {
    Canvas x = new Canvas(5,5);
    x.draw(0, 0, 'x');
    x.draw(1, 1, 'y');
    x.undo();
    return x.redo();
  }
  
  /*
   * Calls all test methods.
   * 
   * @return true if all the test methods succeed, false otherwise 
   */
  public static boolean runAsciiArtTestSuite() {
    return (testStackPushPeek() && testPop() && testSize() && testIterator() && testUndo()
        && testRedo());
  }
  
  /*
   * Calls the runAsciiArtTestSuite method, effectively calling all test methods and printing the
   * output to the console.
   * 
   * @param args input parameters
   */
  public static void main(String[] args) {
    System.out.println(runAsciiArtTestSuite());
  }

}
