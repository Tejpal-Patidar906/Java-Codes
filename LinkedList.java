public class LinkedList{
     public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
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
         tail = newNode;
     }
     public void addMiddle(int index , int data){
        if(index == 0){
            addFirst(data);
            return;
        }
          Node newNode = new Node(data);
          size++;
          Node temp = head;
          int i = 0;
          while(i < index-1){
              temp = temp.next;
              i++;
          }
          newNode.next = temp.next;
          temp.next = newNode;
     }
     public int removeFirst(){
        if(size == 0){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
             int val = head.data;
             head = tail = null;
             size--;
             return val;
        }
        int val = head.data;
         head = head.next;
         size--;
         return val;
     }
     public int removeLast(){
         if(size == 0){
            System.out.println("Linkedlist is empty");
            return Integer.MAX_VALUE;
        }else if(size == 1){
             int val = head.data;
             head = tail = null;
             size--;
             return val;
        }
        int i = 0;
        Node temp = head;
        int val = tail.data;
        while(i < size-2){
             temp = temp.next;
             i++;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;
     }
     public int search(int key){
         if(size == 0){
             System.out.println("LL is empty");
             return -1;
         }
         int i = 0;
         Node temp = head;
         while(temp != null){
             if(temp.data == key){
                return i;
             }else{
                i++;
                temp = temp.next;
             }
         }
         return -1;
     }
     public int helper(Node head , int key){
         if(head == null){
               return -1;
           }
           if(head.data == key){
               return 0;
           }
           int res = helper(head.next , key);
           if(res == -1){
             return -1;
           }
        return res+1;
     }
     public int recursiveSearch(int key){
        return helper(head, key);
     }
     public void print(){
        if(head == null){
            System.out.println("empty LinkedList");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
     }
     public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
     }
     public int removeNthfromEnd(int n){
        int v;
        if(n == size){
            v = head.data;
            head = head.next;
            size--;
            return v;
        }
        int i = 0;
        Node temp = head;
        while(i < size-n-1){
            temp = temp.next;
            i++;
        }
        v = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return v;
     }
     public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
     }

     public Node reverseHalf(Node mid){
        Node prev = null;
        Node curr = tail = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
     }

     public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node mid = findMid();
        Node rightHead =  reverseHalf(mid);
        Node left = head;
        while(rightHead != null){
            if(left.data != rightHead.data){
                 return false;
            }
            rightHead = rightHead.next;
            left = left.next;
        }
        return true;
     }

     public static boolean isCyclic(){
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 return true;
             }
         }
         return false;
     }

     public static void removeCycle(){
         // find is LL is cyclic or not
         Node slow = head;
         Node fast = head;
         boolean cycle = false;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                cycle = true;
                break;
             }
         }
         if(cycle == false){
             return;
         }
         slow = head;
         Node prev = null;
         while(slow != fast){
             prev = fast;
             slow = slow.next;
             fast = fast.next;
         }
         prev.next = null;
     }

     private Node getMid(Node head){
         Node slow = head;
         Node fast = head.next;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
     }

     private Node merge(Node head1 , Node head2){
         Node mergeLL = new Node(-1);
         Node temp = mergeLL;
         while(head1 != null && head2 != null){
             if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
             }else{
                temp.next = head2;
                head2 = head2.next;
             }
            temp = temp.next;
         }

         while(head1 != null){
             temp.next = head1;
             head1 = head1.next;
             temp = temp.next;
         }

         while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
         }
         return mergeLL.next;
     }

     public void zigZag(){
          //find mid node
          Node slow = head;
          Node fast = head.next;
          while(fast != null && fast.next != null){
              slow = slow.next;
              fast = fast.next.next;
          }

          Node mid = slow;

          //reverse half LL
          Node curr = mid.next;
          mid.next = null;
          Node prev = null;
          Node next;
          while(curr != null){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
          }

          // zig - zag merge
          Node leftHead = head;
          Node rightHead = prev;
          Node newLeft;
          Node newRight;
          while(leftHead != null && rightHead != null){
              newLeft = leftHead.next;
              leftHead.next = rightHead;
              newRight = rightHead.next;
              rightHead.next = newLeft;

              leftHead = newLeft;
              rightHead = newRight;
          }
     }

    public Node mergesort(Node head){
        //base case
        if(head == null || head.next == null){
             return head;
        }

        //find mid node
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        //sort leftpart and rightpart
        Node newLeft = mergesort(head);
        Node newRight = mergesort(rightHead);

        return merge(newLeft , newRight);
    }

    public Node reverseBetween(Node head, int left, int right) {

        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = head;
        Node beforeFirstOccurance = dummy;
        for(int i=0;i<left-1;i++){
            beforeFirstOccurance = beforeFirstOccurance.next;
            curr = curr.next;
        }

        Node prev = null, subNode = curr;
        for(int i=0;i<=right-left;i++){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        beforeFirstOccurance.next =prev;
        subNode.next = curr;
        return dummy.next;
    }

     public static void main(String[] args) {
         LinkedList ll = new LinkedList();
         for(int i=1; i<=6; i++){
             ll.addLast(i);
         }
         ll.print();
         ll.zigZag();
         ll.print();
     }
}