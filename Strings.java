import java.util.Scanner;

public class Strings {
    public static boolean isPalindrome(String str){
          int start = 0;
          int end = str.length()-1;
          while(start<=end){
              if(str.charAt(start) != str.charAt(end)){
                  return false;
              }
              start++;
              end--;
          }
        return true;
    }
    public static float getShortestPath(String str){
         int x = 0;
         int y = 0;
         for(int i=0; i<str.length(); i++){
             if(str.charAt(i) == 'N'){
                 y++;
             }else if(str.charAt(i) == 'S'){
                y--;
             }else if(str.charAt(i) == 'W'){
                x--;
             }else{
                x++;
             }
         }
         int x2 = x*x;
         int y2 = y*y;
         return (float) Math.sqrt(x2+y2);
    }
    public static String toUppercase(String str){
         StringBuilder sb = new StringBuilder("");
         char ch = Character.toUpperCase(str.charAt(0));
         sb.append(ch);
         for(int i=1; i<str.length(); i++){
              if(str.charAt(i) == ' ' && i < str.length()-1){
                  sb.append(str.charAt(i));
                  i++;
                  sb.append(Character.toUpperCase(str.charAt(i)));
              }else{
                sb.append(str.charAt(i));
              }
         }
         return sb.toString();
    }
    public static String compression(String str){
         StringBuilder newStr = new StringBuilder("");
         for(int i=0; i<str.length(); i++){
             Integer count = 1;
             while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                 count++;
                 i++;
             }
             newStr.append(str.charAt(i));
             if(count > 1){
                 newStr.append(count.toString());
             }
         }
        return newStr.toString();
    }
    public static void compress(char[] chars) {
        StringBuilder newStr = new StringBuilder("");
        for(int i=0; i<chars.length; i++){
             Integer count = 1;
             while(i < chars.length-1 && chars[i] == chars[i+1]){
                 count++;
                 i++;
             }
             newStr.append(chars[i]);
             if(count > 1){
                 newStr.append(count.toString());
             }
         }
        chars = newStr.toString().toCharArray();
        for(int i=0; i<chars.length; i++){
            System.out.print(chars[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    }
}
