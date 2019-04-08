import java.util.*;
class Search{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] intArray = new int[]{ 5,12,14,6,78,19,1,23,26,35,37,7,52,86,47 }; 
        System.out.print("Enter the number to be searched : ");
        int number  =   input.nextInt();
        int i  =    0;
        while(i < 15){
            if(number == intArray[i]){
                System.out.println("Number found at position:"+i);
                break;
            }
        
        ++i;
    }
    if(i==15){
        System.out.println("Number not found");
    }
        input.close();
}
    }