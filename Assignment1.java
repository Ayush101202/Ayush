// Factorial
import java.util.Scanner;

class factorial{
    int n;
    int fact;

    public void getN() {
        System.out.print("Enter a number to get it's Factorial\n-> ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    public void calFact(){
        fact = 1;
        for(int i = 2;i<=n;i++){
            fact *= i;
        }
    }

    public void getFact(){
        System.out.println("The Factorial of "+n+" is : "+fact);
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        factorial f = new factorial();
        f.getN();
        f.calFact();
        f.getFact();
    }
}