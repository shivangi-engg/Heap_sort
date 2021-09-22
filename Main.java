import java.util.*;
import java.lang.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("length of array:");
		int n = sc.nextInt();
		int [] arr = new int[n];
		System.out.println("array elements:");
		for(int i=0; i<n; i++)
		{
			int ele = sc.nextInt();
			arr[i] = ele;
		}	
		buildHeap(arr,n);
		sort(arr,n);
		print(arr);
	}
	public static void print(int [] arr)
	{
		System.out.println("Sorted array");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void sort(int [] arr, int n)
	{
		for(int i=n-1;i>0;i--)
		{
			int temp;
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,0,i);
			/*we need to heapify root node ,we have already build maxheap
			so giving index of root node and i as length because length 
			keeps on decresing for the heap*/
		}
	}
	public static void buildHeap(int []arr, int n)
	{
		for(int i=n/2; i>=0; i--)
		{
			heapify(arr,i,n);
		}
	}
	public static void heapify(int []arr, int i, int n)
	{
		int largest = i;
		int left = i*2 +1;
		int right = i*2 +2;
		if(left < n && arr[left] > arr[largest] )
		{
			largest = left;
		}
		//left<n to check if the element is even there or not
		if(right < n && arr[right] > arr[largest])
		{
			largest = right;
		}
		if(largest != i)
		{
			int temp;
			temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, largest, n);
		}

	}
}