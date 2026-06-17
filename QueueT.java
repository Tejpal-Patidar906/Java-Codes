import java.util.*;
import java.util.LinkedList;

public class QueueT {

    public static void nonRep(String str){
         int freq[] = new int[26];
         Queue<Character> q = new LinkedList<>();
         for(int i=0; i<str.length(); i++){
             char ch = str.charAt(i);
             q.add(ch);
             freq[ch - 'a']++;
             while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
             }
             if(q.isEmpty()){
                System.out.print(-1 + " ");
             }else{
                System.out.print(q.peek() + " ");
             }
         }
         System.out.println();
    }

    public static void interLeave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=1; i<=(size/2); i++){
            q2.add(q.remove());
        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        } 
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=5; i++){
            q.add(i);
        }
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
