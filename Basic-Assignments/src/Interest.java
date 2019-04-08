import java.util.Scanner;
import java.lang.Math;
public class Interest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double principalAmount;
        double noOfYears;
        double rateOfInterest;
        principalAmount	=	sc.nextDouble();
        noOfYears	=	sc.nextDouble();
        rateOfInterest	=	sc.nextDouble();
        double compoundInterest   =   (double)(principalAmount*(Math.pow(1 + rateOfInterest/100,noOfYears)));
        double simpleInterest   =   (double)((principalAmount*noOfYears*rateOfInterest)/100);
        System.out.println("Compound Interest:"+compoundInterest);
        System.out.println("Simple Interest:"+simpleInterest);
                
        
        sc.close();
    }
    }
    