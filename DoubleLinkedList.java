public class DoubleLinkedList {

    public class Node{
         int data;
         Node next;
         Node prev;
         public Node(int data){
             this.data = data;
             this.next = null;
             this.prev = null; 
         }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
             head = tail = newNode;
             return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
         Node newNode = new Node(data);
         size++;
         if(head == null){
             head = tail = newNode;
             return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }


    public void removeFirst(){
         if(head == null){
             System.out.println("LinkedList is Empty!");
             return;
         }
         if(size == 1){
             head = tail = null;
             size--;
             return;
         }
         head = head.next;
         head.prev = null;
         size--;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("LinkedList is Empty!");
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void reverse(){
         Node prev = null;
         Node curr = head;
         Node next;
         while(curr != null){
             next = curr.next;
             curr.next = prev;
             curr.prev = next;

             prev = curr;
             curr = next;
         }
         head = prev;
    }


    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        for(int i = 5; i>=1; i--){
            dll.addFirst(i);
        }
        dll.addLast(6);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
