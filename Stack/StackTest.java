/*
Create a simple stack object such that the following unit tests would pass.



  
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
Stack Test object
*/


public class StackTest {

/*
1. String a = "foo";
   Stack s = new Stack();
   s.push(a);
   assert "foo".equals(s.pop());
*/
   public static boolean test1() {
      String a = "foo";
      Stack s = new Stack();
      s.push(a);
      return a.equals((String)s.pop());   
   }

/*
2. Integer b = new Integer(123);
   Stack s = new Stack();
   s.push(b);
   assert b.equals(s.pop());
*/
   public static boolean test2() {
      Integer b = new Integer(123);
      Stack s = new Stack();
      s.push(b);
      return b.equals((Integer)s.pop());  
   }

/*
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
*/
   public static boolean test3() {
      Integer a = new Integer(1);
      Integer b = new Integer(2);
      Stack s = new Stack(); 
      s.push(a);
      s.push(b);
      Integer x = (Integer)s.pop();
      Integer y = (Integer)s.pop();
      return s.size() == 0 && x.intValue() == b.intValue() && y.intValue() == a.intValue();
   }

/*
Force failure
*/
   public static boolean test4() {
      Integer b = new Integer(123);
      Integer c = new Integer(456);
      Stack s = new Stack();
      s.push(b);
      return c.equals((Integer)s.pop());  
   }

   public static void main(String[] args) {
      if(test1()) {
         System.out.println("Test1: Passed");
      } else {
         System.out.println("Test1: Failed");
      }
      if(test2()) {
         System.out.println("Test2: Passed");
      } else {
         System.out.println("Test2: Failed");
      }
      if(test3()) {
         System.out.println("Test3: Passed");
      } else {
         System.out.println("Test3: Failed");
      }
      if(!test4()) {
         System.out.println("Test4: Passed");
      } else {
         System.out.println("Test4: Failed");
      }
   }
}