import java.util.Scanner;
class DynamicArray {
  public static void main(String[] args) {
    
    Scanner userinput = new Scanner(System.in);
    String Selection;
    
    class Chore {

    private String name;

    public String getName() {
        return this.name;
    }

    public Chore(String name) {
        this.name = name;
    }
}
    
 //------------------------------------------------//
    
    class Chores {

    private Chore[] list;

    public Chores(Chore firstChore)
    {
        this.list = new Chore[1];
        this.list[0] = firstChore;
    }

    public void print()
    {
        for (Chore chore: this.list)
        {
            System.out.println(chore.getName());
        }
    }

    public void Add(Chore chore, int position)
    {
        if (this.list.length == 0 && position == 0)
        {
            this.list[0] = chore;
            this.list = new Chore [1];
            return;
          // This command enters a new chore to the Chore list
        } 
      
        if (position < 0 || position > this.list.length)
        {
            return;
          // This organizes the chore based on the position it is assigned based on the specific list. 
        }

        Chore[] newChores = new Chore [this.list.length + 1];

        for (int i=0; i<this.list.length+1; i++)
        {
            if (i < position)
            {
                newChores[i] = this.list[i];
            }
            else if (i > position)
            {
                newChores[i] = this.list[i-1];
            }
            else
            {
                newChores[i] = chore;
            }
        }

        this.list = newChores;
    }
    }
    System.out.println("Welcome to your personal chore list keeper");
    System.out.println("Would you like to see your Chores?");
    Selection = userinput.nextLine();
    
    if (Selection.equals("yes"))
    {
    System.out.println();
        System.out.println("By Room (Bedroom to Basement:");
        Chores list1 = new Chores(new Chore("Bedroom"));
        list1.Add(new Chore("Bathroom"), 1); 
        list1.Add(new Chore("Hallway"), 2); 
        list1.Add(new Chore("Dining Room"), 3);  
        list1.Add(new Chore("Kitchen"), 4);
    	list1.Add(new Chore("Basement"), 5);
        list1.print();

        System.out.println();
        System.out.println("Reverse Order (Basement to Bedroom:");
        Chores list2 = new Chores(new Chore("Bedroom"));
        list2.Add(new Chore("Bathroom"), 0);
        list2.Add(new Chore("Hallway"), 0);
        list2.Add(new Chore("Dining Room"), 0);
        list2.Add(new Chore("Kitchen"), 0);
    	list2.Add(new Chore("Basement"), 0);
        list2.print();

        System.out.println();
        System.out.println("Dirtiest rooms first:");
        Chores list3 = new Chores(new Chore("Bedroom"));
        list3.Add(new Chore("Bathroom"), 1);
        list3.Add(new Chore("Hallway"), 2);
        list3.Add(new Chore("Dining Room"), 1);
        list3.Add(new Chore("Kitchen"), 2);
    	list3.Add(new Chore("Basement"), 1);
        list3.print();
    	}
    else if (Selection.equals("no"))
    {
      System.out.println("Closing List");
      System.out.println("Have a wonderful day");
    }
    }
}
   