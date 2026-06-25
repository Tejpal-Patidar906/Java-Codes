import java.util.*;
import java.util.LinkedList;

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

    static class Info2{
        Node node;
        int hd;
        public Info2(Node node , int hd){
            this.node = node;
            this.hd = hd;
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

        public static boolean isIdentical(Node node , Node subRoot){
            if(node == null && subRoot == null){
                return true;
            }else if(node == null || subRoot == null || node.data != subRoot.data){
                return false;
            }
            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root , Node subRoot){
            if(subRoot == null){
                return true;
            }
            if(root == null){
                return false;
            }


            if(root.data == subRoot.data){
                if(isIdentical(root , subRoot)){
                    return true;
                }
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public static void topView(Node root){
            Queue<Info2> q = new LinkedList<>();
            HashMap<Integer , Node> map = new HashMap<>();

            int min = 0, max=0;
            q.add(new Info2(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info2 curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){     // first my horizontal distance is occuring
                      map.put(curr.hd , curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new Info2(curr.node.left , curr.hd-1));
                        min = Math.min(min , curr.hd-1); 
                    }
                    if(curr.node.right != null){
                        q.add(new Info2(curr.node.right , curr.hd+1));
                        max = Math.max(max , curr.hd+1); 
                    } 
                }  
            }
            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }

        public static void kLevel(Node root , int level , int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }

        public static boolean getPath(Node root , int n , ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);

            if(root.data == n){
                return true;
            }
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(path.size()-1);
            
            return false;
        }

        public static Node lca(Node root , int n1 , int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root , n1 , path1);
            getPath(root , n2 , path2);

            int i=0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            return path1.get(i-1);
        }

        public static Node lca2(Node root , int n1 , int n2){
            if(root == null){
                return null;
            }
            if(root.data == n1 || root.data == n2){
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }
            return root;
        }

        public static int lcaDist(Node root , int n){   
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }else if(leftDist == -1){
                return rightDist+1;
            }else{
                return leftDist+1;
            }
        }

        public static int minDist(Node root , int n1 , int n2){
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca , n1);
            int dist2 = lcaDist(lca , n2);

            return dist1 + dist2;
        }

        public static int kthAncestor(Node root , int k , int node){
            if(root == null){
                return -1;
            }
            if(root.data == node){
                return 0;
            }
            int leftDist = kthAncestor(root.left, k, node);
            int rightDist = kthAncestor(root.right, k, node);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }
            int max = Math.max(leftDist, rightDist);
            if(max+1 == k){
                System.out.println(root.data);
            }
            return max+1;
        }

        public static int transform(Node root){
            if(root == null){
                return 0;
            }
            
            int leftChild = transform(root.left);
            int rightChild = transform(root.right);

            int data = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;

            root.data = newLeft + leftChild + newRight + rightChild;

            return data;
        }
    }


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        //int nodes2[] = {2,4,-1,-1,5,-1,-1};
        BinaryTreee tree = new BinaryTreee();
        tree.idx = -1;
        Node root = tree.buildTree(nodes);
        tree.transform(root);
        tree.preOrder(root);
    }
}
