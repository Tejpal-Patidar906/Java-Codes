import java.util.*;
import java.util.LinkedList;

public class DequeB {

    // static class Stack{                  //stack using Deque
    //     Deque<Integer> deque = new LinkedList<>();

    //     public boolean isEmpty(){
    //         return deque.isEmpty();
    //     }
        
    //     //push()
    //     public void push(int data){
    //         deque.addLast(data);
    //     }

    //     //pop()
    //     public int pop(){
    //         return deque.removeLast();
    //     }

    //     //peek()
    //     public int peek(){
    //         return deque.getLast();
    //     }
    // }

    // Queue using Deque
    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.isEmpty();
        }

        // add  -------> TC = O(1)
        public void add(int data){
            dq.addLast(data);
        }

        // remove  ------> TC = O(1)
        public int remove(){
            return dq.removeFirst();
        }

        // peek  ------> TC = O(1)
        public int peek(){
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
       Queue q = new Queue();
       for(int i=1; i<=4; i++){
          q.add(i);
       } 
       while(!q.isEmpty()){
          System.out.println(q.remove());
       }
    }
}
