package datastructure;

public class LinearSearchExample {

	public static void main(String[] args) {
		int[] arr = {3,6,7,1,8,4};
		int element = 6;
		int result = linearSearch(arr,element);
		if(result==-1)
			System.err.println("Not found!!");
		else
			System.out.println("Element found "+result);
	}

	private static int linearSearch(int[] arr, int element) {
		int length = arr.length;
		for(int i=0;i<length;i++){
			if(arr[i]==element)
				return arr[i];
		}
		return -1;
	}

}
