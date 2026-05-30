import java.util.*;
public class linearSearch {
    public static int linear(int arr[] , int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter terget = ");
        int target = sc.nextInt();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
    }
}
