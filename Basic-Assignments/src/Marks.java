import java.util.*;
class Marks{
    public static void  main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Marks for 3 subjects");
        double physics  =   input.nextDouble();
        double chemistry    =   input.nextDouble();
        double maths    =   input.nextDouble();
        if (physics >60 && chemistry > 60 && maths >60 ) {
            
         System.out.println("Passed");
        }else if(physics > 60 && chemistry > 60 || physics > 60 && maths >60 || chemistry > 60 && maths >60){
            System.out.println("Promoted");
   
        }
        else{
            System.out.println("Failed");

        }

        input.close();
    }
}