import java.util.*;
class Login{
    public static void main(String args[]){
        Scanner input =new Scanner(System.in);
        String password;
       String username;
        int attempt = 0; 
        while (attempt< 4) {

        System.out.println("Enter the Username:");
        username = input.next(); 
        System.out.println("Enter the Password:");
        password = input.next();

            if (username.equals("sky") && password.equals("12345")) {
                System.out.println("Welcome "+username);
                break;
            }
            attempt++;
            System.out.println("Please be Careful you have "+ (3-attempt)+" attempts left");
            
            if(attempt==3){
                System.out.println("Contact Admin");
                System.exit(0);
            }
                
        }
        input.close();
    }
}
