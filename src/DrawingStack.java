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

import java.util.EmptyStackException;
import java.util.Iterator;

/*
 * A stack data structure, in which the data type to be added is DrawingChange. The stack is
 * implemented through LinkedNodes containing DrawingChange objects. DrawingStack contains
 * a field for the current size of the stack and the current top of the stack.
 */
public class DrawingStack implements StackADT<DrawingChange>, java.lang.Iterable<DrawingChange> {
  private LinkedNode<DrawingChange> top;
  private int size;
  
  /*
   * Add an element to this stack
   * 
   * @param element an element to be added
   * 
   * @throws java.util.IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    if(element == null)
      throw new IllegalArgumentException("Element to be added cannot be null.");
    
    LinkedNode<DrawingChange> input = new LinkedNode<DrawingChange>(element);
    size++;
    
    if(top == null)
      top = input;
    else {
      input.setNext(top);
      top = input;
    }
  }
  
  /*
   * Remove the element on the top of this stack and return it
   * 
   * @return the element removed from the top of the stack
   * 
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public DrawingChange pop() throws EmptyStackException {
    if(top == null)
      throw new EmptyStackException();
    
    LinkedNode<DrawingChange> temp = top;
    size--;
    top = top.getNext();
    return temp.getData();
  }
  
  /*
   * Get the element on the top of this stack
   * 
   * @return the element on the stack top
   * 
   * @throws java.util.EmptyStackException if the stack is empty
   */
  @Override
  public DrawingChange peek() throws EmptyStackException {
    if(size == 0)
      throw new EmptyStackException();
    return top.getData();
  }
  
  /*
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return top == null;
  }
  
  /*
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }
  
  /*
   * This method returns an Iterator over elements of type DrawingChange, which allows the user to
   * access each element in a DrawingStack in order.
   * 
   * @return Iterator<DrawingChange> that allows you to access every element in a DrawingStack in a
   * specific order
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(top);
  }
  
}
