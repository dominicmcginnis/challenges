/*
Create a simple stack object such that the following unit tests would pass.

1. String a = "foo";
   Stack s = new Stack();
   s.push(a);
   assert "foo".equals(s.pop());

2. Integer b = new Integer(123);
   Stack s = new Stack();
   s.push(b);
   assert b.equals(s.pop());
  
3. Integer a = new Integer(1);
   Integer b = new Integer(2);
   Stack s = new Stack(); 
   s.push(a);
   s.push(b);
   Integer x = s.pop();
   Integer y = s.pop();
   assert s.size() = 0;
   assert x.equals(b);
   assert y.equals(a);
 *
 */


/*
* A simple object for maintaining a stack of objects
* In LIFO order
*/
import java.util.Arrays;

public class Stack {
	
	Object[] s = null;

	public Stack() {
		s = new Object[0];
	}

	/* 
	* Return the last object added to the stack
	*/
	public Object pop() {
		if(s.length > 0) {
			Object o = s[s.length - 1];
 			s = Arrays.copyOf(s, s.length - 1);
 			return o;
		} else {
			return null;
		}
	}

	/*
	* Add an object to the stack
	*/
	public void push(Object o) {
 		s = Arrays.copyOf(s, s.length + 1);
 		s[s.length-1] = o;
	}

	public int size() {
		return s.length;
	}
}