import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam , int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }


    static class BinaryTreee{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){      // TC = O(n)
            if(root == null){
                //System.out.print(-1 +" ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){     // TC = O(n)
            if(root == null){
                //System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){     // TC = O(n)
            if(root == null){
                //System.out.print(-1 + " ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void leverOrder(Node root){
            if(root == null){
                return; 
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            
            return Math.max(lh,rh) + 1;
        }

        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int lcount = count(root.left);
            int rcount = count(root.right);
            
            return lcount + rcount + 1;
        }

        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int lsum = sum(root.left);
            int rsum = sum(root.right);

            return lsum + rsum + root.data;
        }

        public static int diameter(Node root){ // TC = O(n^2)  
            if(root == null){
                return 0;
            }

            int leftDiameter = diameter(root.left);
            int leftHt = height(root.left);
            int rightDiameter = diameter(root.right);
            int righttHt = height(root.right);
            int selfDiameter = leftHt + righttHt + 1;

            return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
        }

        public static Info diameter2(Node root){    //TC = O(n)
            if(root == null){
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(leftInfo.diam , Math.max(rightInfo.diam , (leftInfo.ht + rightInfo.ht + 1)));
            int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;

            return new Info(diam , ht);
        }

    }



    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreee tree = new BinaryTreee();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.diameter(root));
    }
}
