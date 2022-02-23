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
              System.out.println("You put " + x + " in pile");
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
          System.out.println("Lets put some cards in the pile: ");
    CardStack stack1 = new CardStack();
          stack1.push(2);
          stack1.push(5);
          stack1.push(8);
          stack1.push(6);
      System.out.println(" ");
      System.out.println("Lets take that last card back: ");
          System.out.println(stack1.pop() + " Has been pulled from the pile");
          System.out.println(" ");
      System.out.println("Next, lets take a peek at the top card again: ");
          System.out.println("Currently the top card is :" + stack1.peek());
          System.out.println(" ");
      System.out.println("What do we have left: ");
          System.out.print("Currently the cards in pile are :");
          stack1.print();  
  }}