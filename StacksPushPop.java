class StackPushPop {
    public static void main(String[] args) {
      
  class CardStack
  {
      static final int MAX = 9;
      int top;
      int a[] = new int[9];
   
      boolean EmptyStack()
      {
          return (top < 0);
      }
      CardStack()
      {
          top = -1;
      }
   
      boolean push(int x)
      {
          if (top >= (9 - 1)) {
              System.out.println("Stack Overflow");
              return false;
          }
          else {
              a[++top] = x;
              System.out.println(x + " put in pile");
              return true;
          }
      }
   
      int pop()
      {
          if (top < 0) {
              System.out.println("Stack Underflow");
              return 0;
          }
          else {
              int x = a[top--];
              return x;
          }
      }
   
      int peek()
      {
          if (top < 0) {
              System.out.println("Stack Underflow");
              return 0;
          }
          else {
              int x = a[top];
              return x;
          }
      }
      
      void print(){
      for(int i = top;i>-1;i--){
        System.out.print(" "+ a[i]);
      }
    }
  }
    CardStack s = new CardStack();
          s.push(2);
          s.push(5);
          s.push(8);
          s.push(6);
          System.out.println(s.pop() + " Has been pulled from the pile");
          System.out.println("The top card is :" + s.peek());
          System.out.print("Cards in pile :");
          s.print();  
  }}