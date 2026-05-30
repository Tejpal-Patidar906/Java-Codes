import java.util.ArrayList;
import java.util.*;

public class Arraylistt {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i=1; i<=5; i++){
        //     list.add(i);
        // }
         //System.out.println(list);
        // int element = list.get(4);
        // System.out.println(element);
        // list.remove(4);
        // System.out.println(list);
        // list.set(4,20);
        // System.out.println(list.get(4));
        // System.out.println(list);
        // System.out.println(list.contains(4));
        // System.out.println(list.contains(11));
        // System.out.println(list.contains(10));

        // list.add(1,20);
        // list.add(4,40);
        // System.out.println(list);
        // for(int i=list.size()-1; i>=0; i--){
        //      System.out.print(list.get(i) + "  ");
        // }

        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<list.size(); i++){
        //      if(list.get(i) > max){
        //          max = list.get(i);
        //      }
        // }
        // System.out.println(max);

        // int idx1 = 1;
        // int idx2 = 3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // list.add(5);
        // list.add(3);
        // list.add(2);
        // list.add(4);
        // list.add(1);
        // list.add(6);

        // System.out.println(list);
        // Collections.sort(list); //ascending
        // System.out.println(list);
        // Collections.sort(list , Collections.reverseOrder()); //descending
        // System.out.println(list);

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
    //     ArrayList<Integer> list2 = new ArrayList<>();
    //     ArrayList<Integer> list3 = new ArrayList<>();
    //     for(int i=1; i<=5; i++){
    //       list.add(i*1);
    //       list2.add(i*2);
    //       list3.add(i*3);
    //    }       

    //     mainList.add(list);
    //     mainList.add(list2);
    //     mainList.add(list3);

    //     for(int i=0; i<mainList.size(); i++){
    //          ArrayList<Integer> currList = mainList.get(i);
    //          for(int j = 0; j<currList.size(); j++){
    //             System.out.print(currList.get(j) + " ");
    //          }
    //          System.out.println();
    //     }
    //     System.out.println(mainList);

        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        System.out.println(pairSum2(height, 16));

    }

    public static int mostWater(ArrayList<Integer> height){
         int max = Integer.MIN_VALUE;
        //  for(int i=0; i<height.size(); i++){   //brute force  O(n^2)
        //     int water = 0;
        //      for(int j=i+1; j<height.size(); j++){
        //          int h = Math.min(height.get(i) , height.get(j));
        //          int w = j - i;
        //          water = h * w;
        //      }
        //      max = Math.max(max,water);
        //  }

        int lp = 0;
        int rp = height.size()-1;
        while(lp < rp){
            int h = Math.min(height.get(lp) , height.get(rp));
            int w = rp - lp;
            int currWater = h * w;
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                 rp--;
            }
            max = Math.max(max,currWater);
        }

         return max;
    }

    public static boolean pairSum1(ArrayList<Integer> height , int target){
         int lp = 0;
         int rp = height.size()-1;
         while(lp != rp){
             if(height.get(lp) + height.get(rp) == target){
                  System.out.println("(" + height.get(lp) + " , " + height.get(rp) + ")"); 
                  return true;
             }
             if(height.get(lp) + height.get(rp) < target){
                  lp++;
             }else{
                rp--;
             }
         }
         System.out.println("Not Found!!");
         return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target){
         int pivot = -1;
         int n = list.size();
         for(int i = 0; i<list.size(); i++){
             if(list.get(i) > list.get(i+1)){
                 pivot = i;
                 break;
             }
         }
         int lp = pivot + 1;
         int rp = pivot;

         while(lp != rp){
             if(list.get(lp) + list.get(rp) == target){
                System.out.println("(" + list.get(lp) + " , " + list.get(rp) + ")"); 
                return true;
             }
             if(list.get(lp) + list.get(rp) < target){
                 lp = (lp + 1) % n;
             }else{
                 rp = (n + rp - 1) % n;
             }
         }
         return false;
    }

    public static void swap(ArrayList<Integer> l , int idx1 , int idx2){
        int temp = l.get(idx1);
        l.set(idx1 , l.get(idx2));
        l.set(idx2 , temp);
    }
}
