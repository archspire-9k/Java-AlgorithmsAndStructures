import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.*;

/**
 * Test classes LinkedList and LLNode
 */
@SuppressWarnings("unchecked")   // there is an unavoidable typecast involving a generic type
public class MergeSortTester {
  
  /**
   * Test the split method
   */
  @Test
  public void testSplit() throws Exception {    
    LinkedList<Integer> list = new LinkedList<Integer>();
    // create a list with 1, 2
    LLNode<Integer> list1Node = new LLNode<Integer>(1, new LLNode<Integer>(2, null));
    
    // the split method is private so we will use reflection to access it
    Class<?> cls = list.getClass();
    Method m = cls.getDeclaredMethod("split", list1Node.getClass());
    m.setAccessible(true);
    LLNode<Integer> list2Node = (LLNode<Integer>)m.invoke(list, list1Node);
    
    // now check that one list has 1 and the other has 2
    assertEquals("", new Integer(1), list1Node.getElement());
    assertEquals("", null, list1Node.getNext());
    assertEquals("", new Integer(2), list2Node.getElement());
    assertEquals("", null, list2Node.getNext());
    
    // test again but with a larger list of 4 elements
    list1Node = new LLNode<Integer>(1, new LLNode<Integer>(2, new LLNode<Integer>(3, new LLNode<Integer>(4, null))));
    list2Node = (LLNode<Integer>)m.invoke(list, list1Node);
    
    // check that the first list is 1, 3 and the second is 2, 4
    assertEquals("", new Integer(1), list1Node.getElement());
    assertEquals("", new Integer(3), list1Node.getNext().getElement());
    assertEquals("", null, list1Node.getNext().getNext());
    assertEquals("", new Integer(2), list2Node.getElement());
    assertEquals("", new Integer(4), list2Node.getNext().getElement());
    assertEquals("", null, list2Node.getNext().getNext());
  }
  
  /**
   * Test the merge method
   */
  @Test
  public void testMerge() throws Exception {
    LinkedList<Integer> list = new LinkedList<Integer>();
    
    // Just one test.  A better test should cover a few more cases  
    LLNode<Integer> list1Node = new LLNode<Integer>(1, new LLNode<Integer>(3, null));
    LLNode<Integer> list2Node = new LLNode<Integer>(2, new LLNode<Integer>(4, null));
   
    // merge is private so we will use reflection to access it
    Class<?> cls = list.getClass();
    Method m = cls.getDeclaredMethod("merge", list1Node.getClass(), list1Node.getClass());
    m.setAccessible(true);
    
    LLNode<Integer> result = (LLNode<Integer>)m.invoke(list, list1Node, list2Node);
    assertEquals("", new Integer(1), result.getElement());
    assertEquals("", new Integer(2), result.getNext().getElement());
    assertEquals("", new Integer(3), result.getNext().getNext().getElement());
    assertEquals("", new Integer(4), result.getNext().getNext().getNext().getElement());
    assertEquals("", null, result.getNext().getNext().getNext().getNext());
  }
  
}
