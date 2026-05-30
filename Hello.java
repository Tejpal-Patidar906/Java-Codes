import java.util.*;

public class Hello{
     public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          System.out.print("enter n = ");
          int n = sc.nextInt();
          // System.out.print("enter r = ");
          // int r = sc.nextInt();
          // System.out.println(binomialCoefficient(n, r));
          // int a = sc.nextInt();
          // int b = sc.nextInt();
          // swapNumbers(a , b);
          // primesInRange(n);
          // System.out.println(n+" Decimal number is = " + binTODec(n));
          System.out.println(n+" Binary number is = " + dectobin(n));
     }
     public static void printSquare(int n){
          for(int i=0; i<n; i++){
               System.out.print("* * * *");
               System.out.println();
          }
     }
     public static void reverseNumber(int n){
          int ld = 0;
          while(n>0){
               ld = n%10;
               System.out.print(ld);
               n = n/10;
          }
     }
     public static int reverseNum(int n){
          int ld = 0;
          int rev = 0;
          while(n>0){
               ld = n%10;
               rev = (rev * 10) + ld;
               n = n/10;
          }
          return rev;
     }
     public static boolean isPrime(int n){
          if(n==2){
               return true;
          }else{
               for(int i=2; i<=Math.sqrt(n); i++){
                    if(n % i == 0){
                         return false;
                    }
               }
          }
          return true;
     }
     public static void swapNumbers(int a , int b){
          int temp = a;
          a = b;
          b = temp;
          System.out.println("a = "+a);
          System.out.println("b = "+b);
     }
     public static int fact(int n){
          int f = 1;
          for(int i=n; i>0; i--){
               f = f * i;
          }
          return f;
     }
     public static int binomialCoefficient(int n , int r){
          int nFact = fact(n);
          int rFact = fact(r);
          int nmrFact = fact(n-r);
          int coefficient = (nFact) / (rFact * nmrFact);
        return coefficient;
     }
     public static void primesInRange(int n){
          for(int i=2; i<=n; i++){
               if(isPrime(i)){
                    System.out.print(i + " ");
               }
          }
     }
     public static int binTODec(int n){
          int pow = 0;
          int dec = 0;
          while(n > 0){
               int ld = n % 10;
               dec = dec + (ld * (int)Math.pow(2, pow));
               n = n/10;
               pow++;
          }
          return dec;
     }
 
     public static int dectobin(int n){
          int bin = 0;
          int pow = 0;
          while(n > 0){
               int rem = n % 2;
               bin = bin + (rem * (int) Math.pow(10, pow));
               pow++;
               n = n/2;
          }
          return bin;
     }
}

