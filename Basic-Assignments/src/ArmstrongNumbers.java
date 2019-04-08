
public class ArmstrongNumbers {

    public static void main(String []args){
      	int temporary;
    	System.out.println("Armstrong Numbers in the range 0f 99 and 1000 are:");
		for (int i=100; i<1000;i++){
		temporary = i;
		int result1 = 0;
		int result2 = 0;
		while(temporary > 0) {
			result1	=temporary %	10;
			result2 += result1*result1*result1;
			temporary /= 10;
		}
		if (result2 == i) {
			System.out.println(result2);
		}
		}
    }
}


