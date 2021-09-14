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
