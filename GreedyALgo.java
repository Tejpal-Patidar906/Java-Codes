import java.util.*;

public class GreedyALgo {

    public static void maxAct(int start[] , int end[]){
        int maxAct = 0;
        ArrayList<Integer> list = new ArrayList<>();

        //sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function ------- shortfrom
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));

        //1st act
        maxAct = 1;
        list.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                list.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
         
        System.out.println("Maximum Activities = " + maxAct);
        for(int i=0; i<list.size(); i++){
            System.out.print("A" + list.get(i) + "  ");
        }
        System.out.println();
    }

    public static void fractionalKnapsack(int weight[] , int value[] , int w){
        double ratio[][] = new double[weight.length][2];
        for(int i=0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        double val = 0;
        int capacity = w;

        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                val = val + value[idx];
                capacity = capacity  - weight[idx];
            }else{
                val = val + (capacity * ratio[i][1]);
                 capacity = 0;
                break;
            }
        }
        System.out.println("Answer = " + val);
    }

    public static void minDiff(int A[] , int B[]){
         Arrays.sort(A);
         Arrays.sort(B);
         int minDiff = 0;
         for(int i=0; i<A.length; i++){
             minDiff += Math.abs(A[i] - B[i]);
         }
         System.err.println("Minimum Difference = " + minDiff);
    }

    public static void maxLength(int pairs[][]){
         int n = pairs.length;
         Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));
         int ans = 1;
         int chainend = pairs[0][1];
         for(int i=1; i<n; i++){
            if(pairs[i][0] > chainend){
                ans++;
                chainend = pairs[i][1];
            }
         }
         System.out.println("ans = " + ans);
    }

    public static void indianCoins(int amt){
        int arr[] = {2000 , 500 , 100 , 50 , 20 , 10 , 5 , 2 , 1};
        int n = arr.length;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(arr[i] < amt){
                while(arr[i] <= amt){
                    count++;
                    list.add(arr[i]);
                    amt -= arr[i];
                }
            }
        } 
        System.out.println(list);
        System.out.println("Ans = " + count);
    }

    
    

    public static void jobSequence(int jobsInfo[][]){

        ArrayList<Job> jobs = new ArrayList<>();
        
        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0] , jobsInfo[i][1]));
        }

        Collections.sort(jobs , (a,b) -> b.profit - a.profit);   //descending order of profit       // Lambda function() -> (a,b) -> b.profit - a.profit  
        int time = 0;

        ArrayList<Integer> seq = new ArrayList<>();

        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadLine > time){
                 seq.add(curr.id);
                 time++;
            }
        }

        System.out.println("Max Jobs = " + seq.size());
        System.out.println(seq);
    }

    static class Job{
        int deadLine;
        int profit;
        int id;

        public Job(int i , int d , int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }


    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20} , {1,10} , {1,40} , {1,30}};
        jobSequence(jobsInfo);
    }
}
