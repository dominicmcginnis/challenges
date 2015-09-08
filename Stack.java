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


