package datastructure;

public class BinarySearch {

	// searched in sorted array 
	public static void main(String[] args) {
		BinarySearch bs= new BinarySearch();
		int[] arr= {3,4,5,6,7,8,9};
		int length = arr.length;
		int element = 5;
		int result = bs.interationSearch(arr,element,length-1);
		if(result==-1)
			System.err.println("Not found by iterative approach");
		else
			System.out.println("Element found by iterative approach "+result);
		
		int low=0;
		int result1 = bs.recursiveSearch(arr,element,low,length-1);
		if(result1==-1)
			System.err.println("Not found by recursive approach");
		else
			System.out.println("Element found by recursive approach "+result);
		
	}

	

	//iterative approach
	private int interationSearch(int[] arr, int element, int high) {
		int low=0;
		int middle = (low+high)/2;
		//System.out.println("1 == low:"+low+" high:"+high+" middle: "+middle);
		while(low<=high){
			//System.out.println(arr[middle]+" "+element);
			if(arr[middle]==element){
				return arr[middle];
			}else if(arr[middle]<element){
				low=middle+1;
			}else{
				high=middle-1;
			}
			middle = (low+high)/2;
			//System.out.println("2== low:"+low+" high:"+high+" middle: "+middle);
		}
		return -1;
	}

	//recursive approach
	private int recursiveSearch(int[] arr, int element,int low, int high) {
		if(high>=low){
			int middle = (low+high)/2;
			//System.out.println("3 == low:"+low+" high:"+high+" middle: "+middle);
			//System.out.println(arr[middle]+" "+element);
			if(arr[middle]==element)
				return  arr[middle];
			else if(element>arr[middle]){
				low=middle+1;
				return recursiveSearch(arr,element,low,high);
			}else {
				high=middle-1;
				return recursiveSearch(arr,element,low,high);
			}
		}
		return -1;
	}
}
