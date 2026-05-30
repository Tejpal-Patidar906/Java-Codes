import java.util.*;

public class AdvancePatterns {
    public static void hollowRectangle(int r , int c){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i == 0 || i == r-1 || j == 0 || j == c-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void invRothapy(int n){
        for(int i=1; i<=n; i++){
            for(int j=0; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void inverted_half_pyramid(int n){
        for(int i=0; i<n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void floydsTriangle(int n){
         int num = 1;
         for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
         }
    }
    public static void zeroOneTriangle(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if((i+j) % 2 == 0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
        for(int i=1; i<=n; i++){
            for(int k = 1; k<=i; k++){
                System.out.print("* ");
            }
            for(int k=1; k<=2*(n-i); k++){
                System.out.print("  ");
            }
             for(int k=1; k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--){
            for(int k = 1; k<=i; k++){
                System.out.print("* ");
            }
            for(int k=1; k<=(2*n)-(2*i); k++){
                System.out.print("  ");
            }
            for(int k=1; k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void solidRohmbus(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }   
            for(int j=0; j<n; j++){
                if(i == 0 || i == n-1 || j == 0 || j == n-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void diamond(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=2*i-1; j++){
                 System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1; i>=1; i--){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=2*i-1; j++){
                 System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("enter rows = ");
         int r = sc.nextInt();
        //  System.out.print("enter cols = ");
        //  int c = sc.nextInt();
         //hollowRectangle(r, c);
         //invRothapy(r);
         //inverted_half_pyramid(r);
        //  floydsTriangle(r);
        // zeroOneTriangle(r);
        //butterfly(r);
        //solidRohmbus(r);
        diamond(r);
    }

}
