//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java, Canvas.java,
//                  AsciiArtTester.java, StackADT.java, LinkedNode.java
// Course:          CS 300

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class represents an instance of a DrawingStackIterator, which allows the user to iterate
 * through a DrawingStack object and access the nodes from top to bottom. It contains a field
 * which is a reference to the current node being accessed.
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  private LinkedNode<DrawingChange> current;
  
  /*
   * Constructor that initializes a DrawingStackIterator object with a specific node that is at the
   * top of the DrawingStack.
   * 
   * @param top LinkedNode<DrawingChange> object that is the top of a DrawingStack
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> top) {
    current = top;
  }
  
  /*
   * This method returns the current node being accessed in the DrawingStack and resets the current 
   * node pointer to point to the following node.
   * 
   * @return DrawingChange the DrawingChange object contained in the current node
   * 
   * @throws NoSuchElementException if the stack is empty
   */
  @Override
  public DrawingChange next() {
    if(!hasNext())
      throw new NoSuchElementException("Stack is empty.");
    
    LinkedNode<DrawingChange> temp = current;
    current = current.getNext();
    return temp.getData();
  }
  
  /*
   * This method checks to see if the next node in the DrawingStack exists.
   * 
   * @return true if the node after the node currently being accessed is not null, false otherwise
   */
  @Override
  public boolean hasNext() {
    return current != null;
  }

}
