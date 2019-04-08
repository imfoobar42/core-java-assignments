import java.util.*;
class Tax{
    public static void  main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your CTC:");
        double ctc  =   input.nextDouble();
        double taxAmount ;
        if (ctc <= 180000 ) {
         System.out.println("Tax Payable is NIL");
        }else if(181001 <= ctc && ctc <= 300000 ){
            taxAmount = 0.1 * ctc ;
            
         System.out.println("Tax Payable is :"+taxAmount);
   
        }
        else if(300001 <= ctc && ctc<= 500000 ){
            taxAmount = 0.2 * ctc ;
            
         System.out.println("Tax Payable is :"+taxAmount);
   
        }
        
        else{
            taxAmount = 0.3 * ctc ;
            
         System.out.println("Tax Payable is :"+taxAmount);
   
        }

        input.close();
    }
}