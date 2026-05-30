public class Recursion {

    public static void printNtoOne(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printNtoOne(n-1);
    }
    public static void printOnetoN(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        printOnetoN(n-1);
        System.out.print(n + " ");
    }
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n * fnm1;
      return fn;
    }
    public static int sum(int n){
        if(n == 1){
            return n;
        }
        int snm1 = sum(n-1);
        int sum = n + snm1;
        return sum;
    }
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fibnnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        int fibN = fibnnm1 + fibnm2;
        return fibN;
    }

    public static boolean isSorted(int arr[] , int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOccurence(int arr[] , int n , int i){
         if(i == arr.length-1){
            return -1;
         }
         if(arr[i] == n){
            return i;
         }
         return firstOccurence(arr, n, i+1);
    }
    public static int lastOccurence(int arr[] , int n , int i){
         if(i == arr.length-1){
            return -1;
         }
         int isFound = lastOccurence(arr, n, i+1);
         if(isFound == -1 && arr[i] == n){
             return i;
         }
         return isFound;
    }
    public static int poww(int x , int n){
         if(n == 0){
             return 1;
         }
         int powww = poww(x , n-1);
         int ans = x * powww;
        return ans;
    } 
    public static int optimizedPower(int x , int n){
         if(n == 0){
            return 1;
         }
         int halfPower = optimizedPower(x, n/2);
         int halfPowerSq = halfPower * halfPower; 
         //n is odd
         if(n % 2 != 0){
            halfPowerSq = x * halfPowerSq;
         }
         return halfPowerSq;
    }
    public static int tilling(int n){
         if(n == 0 || n == 1){
            return 1;
         }
         int fnm1 = tilling(n-1);
         int fnm2 = tilling(n-2);
        return fnm1 + fnm2;
    }
    public static void removeDuplicates(String str , int idx , StringBuilder newStr , boolean map[]){
         if(idx == str.length()){
            System.out.println(newStr);
            return;
         }
         //kaam
         char currChar = str.charAt(idx);
         if(map[currChar - 'a'] == true){
              removeDuplicates(str, idx+1, newStr, map);
         }else{
             map[currChar - 'a'] = true;
             removeDuplicates(str, idx+1, newStr.append(currChar), map);
         }
    }
    public static void main(String[] args){
        String str = "appnnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }

}
