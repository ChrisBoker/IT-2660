import java.util.Scanner;
class Listing { 
 String name;
 String address;
 String number;

   public Listing(String name, String address, String number) 
   {
       this.name = name;
       this.address = address;
       this.number = number;
   }

   public String toString() 
   {
       return ("Name is "+name+
        "\nAddress is "+address+
        "\nNumber is "+number+"\n\n");
   }
  
   public Listing deepCopy() 
   {
       Listing clone = new Listing(name, address, number);
       return clone;
   }
  
   public int compareTo(String targetKey) 
   {
       return (name.compareTo(targetKey));
   }
  
   public void setAddress(String address) 
   {
       this.address = address;
   }

   public String getName() 
   {
       return name;
   }}

class BSTNode 
	{
   		BSTNode left, right;
   		Listing data;

   		public BSTNode(Listing listing) 
    {
       	left = null;
       	right = null;
       	data = listing;
    }
  
   public void setLeft(BSTNode n) 
   {
       left = n;
   }

   public void setRight(BSTNode n)
   {
       right = n;
   }

   public BSTNode getLeft() 
   {
       return left;
   }

   public BSTNode getRight() 
   {
       return right;
   }

   public void setData(Listing listing)
   {
       data = listing;
   }

   public Listing getData() 
   {
       return data;
   }}

class BST 
	{
   private BSTNode root;

   public BST() 
   {
       root = null;
   }

   public boolean isEmpty()
   {
       return root == null;
   }

   public void insert(Listing data)
   {
       root = insert(root, data);
   }

   private BSTNode insert(BSTNode node, Listing data)
   {
       if (node == null)
           node = new BSTNode(data);
       else 
       {
           if (data.compareTo(node.getData().getName())<=0)
               node.left = insert(node.left, data);
           else
               node.right = insert(node.right, data);
       }
       return node;
   }

   public void delete(String k)
   {
       if (isEmpty())
           System.out.println("Tree Empty");
       else if (search(k) == false)
           System.out.println("Sorry " + k + " is not present");
       else
   {
           root = delete(root, k);
           System.out.println(k + " deleted from the tree");
   }}

   private BSTNode delete(BSTNode root, String k) 
   {
       BSTNode p, p2, n;
       if (root.getData().getName().equalsIgnoreCase(k)) 
       {
           BSTNode lt, rt;
           lt = root.getLeft();
           rt = root.getRight();
           if (lt == null && rt == null)
               return null;
           else if (lt == null)
           {
               p = rt;
               return p;
           } else if (rt == null) 
           {
               p = lt;
               return p;
           } else 
           {
               p2 = rt;
               p = rt;
               while (p.getLeft() != null)
                   p = p.getLeft();
               p.setLeft(lt);
               return p2;
           }
       }
       if (k.compareTo(root.getData().getName())<0) 
       {
           n = delete(root.getLeft(), k);
           root.setLeft(n);
       } else 
       {
           n = delete(root.getRight(), k);
           root.setRight(n);
       }
       return root;
   }

   public int countNodes() 
   {
       return countNodes(root);
   }

   private int countNodes(BSTNode r) 
   {
       if (r == null)
           return 0;
       else {
           int l = 1;
           l += countNodes(r.getLeft());
           l += countNodes(r.getRight());
           return l;
       }
   }

   public boolean search(String val) 
   {
       return search(root, val);
   }

   private boolean search(BSTNode r, String val) 
   {
       boolean found = false;
       while ((r != null) && !found) 
       {
           String rval = r.getData().getName();
           if (val.compareTo(rval)<0)
               r = r.getLeft();
           else if (val.compareTo(rval)>0)
               r = r.getRight();
           else 
           {
               System.out.println("Search Result: \n");
               System.out.println(r.data);
               found = true;
               break;
           }
           found = search(r, val);
       }
       return found;
   }

   public void preorder() 
   {
       preorder(root);
   }

   private void preorder(BSTNode r) 
   {
       if (r != null) 
       {
           System.out.print(r.getData());
           preorder(r.getLeft());
           preorder(r.getRight());
       }}}

public class BinarySearchTree 
{ 
   public static void main(String[] args) 
   {   
       Scanner scan = new Scanner(System.in);
       BST bst = new BST();
       System.out.println("Binary Search Tree Test");
       String name;
       String address;
       String number;
      
       while(true) 
       {
           System.out.println("\nEnter the number of the task you'd like to engage and press Enter:");
         System.out.println("");
           System.out.println("(1) to insert a new student to the repository");
           System.out.println("(2) to display a specific student's information,");
           System.out.println("(3) to delete a student's information from the repository,");
           System.out.println("(4) to output all the student information in descending order, and");
           System.out.println("(5) to exit this program.");

           int choice = scan.nextInt();
           scan.nextLine();
           switch (choice) 
           {
           case 1:
               System.out.println("Please enter student details to insert");
               System.out.print("Enter Student's Name: ");
               name = scan.nextLine();
               System.out.print("Enter Student's Address: ");
               address = scan.nextLine();
               System.out.print("Enter Student's Number: ");
               number = scan.nextLine();
               bst.insert(new Listing(name, address, number));
               break;
           case 2:
               System.out.print("Enter the student's name that you'd like to search : ");             
               if(!bst.search(scan.nextLine())) 
               {
                   System.out.println("Requested student's information not found");
               }
               break;
           case 3:
               System.out.print("Enter the student's name you to delete :");
               bst.delete(scan.nextLine());
               break;     
           case 4:
               System.out.print("\nStudents in decending order : \n\n");
               bst.preorder();
               break;
           case 5:
               break;            
           default:
               System.out.println("Invalid Option\n");
               break;        
           }
           if(choice==6)
               break;
       }  
       System.out.println("Thank you!");
   }}
