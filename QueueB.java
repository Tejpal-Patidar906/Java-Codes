import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;

public class QueueB {

    // static class Queue{ //Queue implementation using array
    // static int arr[];
    // static int size;
    // static int rear;
    // Queue(int n){
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // }

    // public static boolean isEmpty(){ //O(1)
    // return rear == -1;
    // }

    // //add
    // public static void add(int data){ //O(1)
    // if(rear == size-1){
    // System.out.println("Queue is fulled !");
    // return;
    // }
    // rear = rear + 1;
    // arr[rear] = data;
    // }

    // //remove
    // public static int remove(){ //O(n)
    // if(isEmpty()){
    // System.out.println("Queue is empty !!");
    // return -1;
    // }

    // int front = arr[0];
    // for(int i=0; i<rear; i++){
    // arr[i] = arr[i+1];
    // }
    // rear = rear - 1;

    // return front;
    // }

    // //peek()
    // public static int peek(){ // O(1)
    // if(isEmpty()){
    // System.out.println("Queue is Empty !!");
    // return -1;
    // }
    // return arr[0];
    // }
    // }

    // static class Queue{ //Queue(Circular) implementation using array
    // static int arr[];
    // static int size;
    // static int rear;
    // static int front;

    // Queue(int n){
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // front = -1;
    // }

    // public static boolean isEmpty(){ //O(1)
    // return rear == -1 && front == -1;
    // }

    // public static boolean isFull(){ //O(1)
    // return (rear+1)%size == front;
    // }

    // //add
    // public static void add(int data){ //O(1)
    // if(isFull()){
    // System.out.println("Queue is fulled !");
    // return;
    // }
    // if(front == -1){
    // front = 0;
    // }

    // rear = (rear + 1)%size;
    // arr[rear] = data;
    // }

    // //remove
    // public static int remove(){ //O(n)
    // if(isEmpty()){
    // System.out.println("Queue is empty !!");
    // return -1;
    // }

    // int res = arr[front];
    // if(rear == front){
    // rear = front = -1;
    // }else{
    // front = (front + 1) % size;
    // }
    // return res;
    // }

    // //peek()
    // public static int peek(){ // O(1)
    // if(isEmpty()){
    // System.out.println("Queue is Empty !!");
    // return -1;
    // }
    // return arr[front];
    // }
    // }

    // static class Node{ //queue implementation using linkedlist
    // int data;
    // Node next;
    // Node(int data){
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Queue{
    // static Node head = null;
    // static Node tail = null;

    // public static boolean isEmpty(){
    // return head == null && tail == null;
    // }

    // public static void add(int data){
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // }

    // public static int remove(){
    // if(isEmpty()){
    // System.out.println("Empty Queue!!");
    // return -1;
    // }
    // int res = head.data;
    // if(tail == head){
    // head = tail = null;
    // }else{
    // head = head.next;
    // }
    // return res;
    // }

    // public static int peek(){
    // if(isEmpty()){
    // System.out.println("Empty Queue!!");
    // return -1;
    // }
    // return head.data;
    // }

    // }

    // Queue using 2 Stacks;
    // static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();
        
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }

    //     //add
    //     public static void add(int data){         // TC = O(n)
    //          while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //          }

    //          s1.push(data);

    //          while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //          }
    //     }

    //     //remove
    //     public static int remove(){         // TC = O(1)
    //         if(s1.isEmpty()){
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    //     public static int peek(){          // TC = O(1)
    //         if(s1.isEmpty()){
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }

    // static class Queue{       
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();
        
    //     public static boolean isEmpty(){
    //         return s1.isEmpty() && s2.isEmpty();
    //     }

    //     //add
    //     public static void add(int data){   // TC = O(1)
    //          s1.push(data);
    //     }

    //     //remove
    //     public static int remove(){        // TC = O(n)
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         if(isEmpty()){
    //            System.out.println("Empty Queue !!");
    //            return -1; 
    //         }
    //         return s2.pop();
    //     }

    //     public static int peek(){      // TC = O(n)
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         if(isEmpty()){
    //            System.out.println("Empty Queue !!");
    //            return -1; 
    //         }
    //         return s2.peek();
    //     }
    // }


    //stack using 2 queues
    // static class Stack{
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     public static boolean isEmpty(){
    //          return q1.isEmpty() && q2.isEmpty();
    //     }

    //     public static void push(int data){        // TC = O(1)
    //         if(!q1.isEmpty()){
    //             q1.add(data);
    //         }else{
    //             q2.add(data);
    //         }
    //     }

    //     public static int pop(){         // TC = O(n)
    //         if(isEmpty()){
    //             System.out.println("Empty Stack");
    //             return -1;
    //         }
    //         int top = -1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 if(q1.isEmpty()){
    //                     break;
    //                 }
    //                 q2.add(top);
    //             } 
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 if(q2.isEmpty()){
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    //     public static int peek(){               // TC = O(n)
    //         if(isEmpty()){
    //             System.out.println("Empty Stack");
    //             return -1;
    //         }
    //         int top = -1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 q2.add(top);
    //             } 
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    // }

    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        public static void push(int data){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            q1.add(data);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        public static int pop(){
            if(q1.isEmpty()){
                System.out.println("Empty Stack !!");
                return -1;
            }
            return q1.remove();
        }
        public static int peek(){
            if(q1.isEmpty()){
                System.out.println("Empty Stack !!");
                return -1;
            }
            return q1.peek();
        }

        
    }



    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
