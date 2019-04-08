
public class Main {

	public static void main(String[] args) {
		
		int i =100;
		int j = 51;
		
		byte b= 126;
		
		long l = 100L;
		long l2 = 9000000000L;		
		
		System.out.println(i+j);
		System.out.println(i-j);
		System.out.println(i*j);
		//type casting
		System.out.println((double)i/(double)j);
		
		i+=5;
		System.out.println(i);
		//Post increment
		System.out.println(i++);
		//Pre Incremenent
		System.out.println(++i);
		
		//Array is a collection of same data type
		int[] arr = {1,2,3,4};
		System.out.println(arr[1]);
		char[] myName = {'S','U','N','E','E','L'};
		System.out.println(myName);
		
		

	}

}
