import java.util.Random;
public class Merge {
    public static void fill(int array[])   
    {
        Random gen = new Random();
        for (int i =0;i<array.length;i++)
            array[i] = gen.nextInt();
    }
    
    public static void merge(int data[],int low,int mid, int high) {
        int first = mid;
        int second = mid + 1;
        int l = low;
        while ((l<=first) && (second <= high))  {
            if (data[low] < data[second])
                low++;
            else 
            {
                int temp = data[second];
                for (int j = second - 1; j>= low; j--)
                    data[j+1] = data[j];
                data[low] = temp;
                low++;
                first++;
                second++;
            }}}

    public static void mergeSort(int data[],int low,int high)   
    {
        if (low >= high)
        return;
        int mid = (low+high)/2;
        mergeSort(data,low,mid);
        mergeSort(data,mid+1,high);
        merge(data,low,mid,high);
    }
    public static void main(String[] args) {
        int [] data = new int[100];
        fill(data);
        display(data);
        mergeSort(data,0,99);
        display(data);
    }
    public static void display(int arr[]) 
    {
        System.out.println("The numbers of the set array are as such : ");
        for (int i =0;i<arr.length;i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }
}