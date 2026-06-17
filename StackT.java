import java.util.*;

public class StackT {
     public static void pushBottom(Stack<Integer> s, int data){
         if(s.isEmpty()){
            s.push(data);
            return;
         }
         int top = s.pop();
         pushBottom(s, data);
         s.push(top);
    }
    
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder newStr = new StringBuilder("");
        while(!s.isEmpty()){
             newStr.append(s.pop());
        }
        return newStr.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushBottom(s,top);
    }
    
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i<stocks.length; i++){
             int curr = stocks[i];
             while(!s.isEmpty() && curr >= stocks[s.peek()]){
                 s.pop();
             }
             if(s.isEmpty()){
                span[i] = i+1;
            }else{
                 int prevHigh = s.peek();
                 span[i] = i-prevHigh;
             }
             s.push(i);
        }
    }

    public static int[] nextGreater(int arr[] , int nextGreater[]){
         Stack<Integer> s = new Stack<>();
         for(int i=arr.length-1; i>=0; i--){
             while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
             }
             if(s.isEmpty()){
                 nextGreater[i] = -1;
             }else{
                nextGreater[i] = arr[s.peek()];
             }
             s.push(i);
         }
         return nextGreater;
    }

    public static boolean isValid(String str){
         Stack<Character> s = new Stack<>();
         char c = str.charAt(0);
         if(c == ')' || c == ']' || c == '}'){
            return false;
         }
         for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);  
            if(ch == '[' || ch == '{' || ch == '('){
                 s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
         }
         if(s.isEmpty()){
            return true;
         }else{
            return false;
         }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }

    public static int maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // for next smaller left
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // for next smaller right
        s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //current area
        for(int i=0; i<arr.length; i++){
            int h = arr[i];
            int width = nsr[i] - nsl[i] -1;
            int currArea = h * width;
            maxArea = Math.max(maxArea, currArea);
        }
       return maxArea;
    }


    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.println(maxArea(arr));
    }
}
