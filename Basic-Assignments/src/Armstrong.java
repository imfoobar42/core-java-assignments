import java.util.Scanner;
import java.lang.Math;
public class Armstrong {

	public static void main(String[] args) {
		Scanner sc	=	new Scanner(System.in);
		int number;
		number = 153;
		int temporary	=	number;	
		int result1	=		0;
		int result2	=	0;
		while(temporary > 0) {
			result1	=	temporary %	10;
			result2 += result1*result1*result1;
			temporary 	/= 10;
		}
		if (result2 == number) {
			System.out.println("Given number is an Armstrong number" );
		}else {

			System.out.println("Given number is not an Armstrong number" );
		}
	}
}
