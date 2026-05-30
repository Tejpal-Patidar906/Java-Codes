public class arrays {
    public static int linearString(String arr[] , String target){
         int n = arr.length;
         for(int i=0; i<n; i++){
            if(arr[i].equals(target)){
                return i;
            }
         }
         return -1;
    }

    public static int linear(int arr[] , int target){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int arr[]){
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static int smallest(int arr[]){
        int n = arr.length;
        int largest = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] < largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int binarySearch(int arr[] , int target){
         int n = arr.length;
         int start = 0;
         int end = n-1;
         while(start<=end){
             int mid = (start+end)/2;
             if(arr[mid] == target){
                return mid;
             }else if(arr[mid] > target){
                 end = mid-1;
             }else{
                start = mid+1;
             }
         }
         return -1;
    }

    public static void reverseArray(int arr[]){
         int n = arr.length;
         int first = 0;
         int last = n-1;
         while(first < last){
             int temp = arr[first];
             arr[first] = arr[last];
             arr[last] = temp;
             first++;
             last--;
         }
    }

    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void printPairs(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("( " + arr[i] +" , " + arr[j] +" )");
            }
            System.out.println();
        }
    }

    public static int maxSubarrSum(int arr[]){  //bruteforce
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int curr;
         for(int i=0; i<n; i++){
            int start = i;
            for(int j=i; j<n; j++){
                int end = j;
                curr = 0;
                for(int k=start; k<=end; k++){
                    curr += arr[k];
                } 
                if(max < curr){
                    max = curr;
                }
            }
         }
         return max;
    }

   public static int prefixSubarrSumm(int arr[]){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int i=0; i<n; i++){
            int start = i;
            for(int j=i; j<n; j++){
                int end = j;
                curr = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if(max < curr){
                    max = curr;
                }
            }
        }
        return max;
   }
   public static int kadanseMaxSubarrSum(int arr[]){
        int n = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            currSum = currSum + arr[i];
             if(currSum <= 0){
                 currSum = 0;
             }
             if(maxSum < currSum){
                 maxSum = currSum;
             }
        }
        return maxSum;
   }


   public static int trappedRainWater(int height[]){
        int n = height.length;
        //left max boundry
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }

        // right max boundry
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i] , rightMax[i+1]);
        }

        //loop
        int trappedWater = 0;
        int width = 1;
        for(int i=0; i<height.length; i++){
            //waterlevel = min(leftmax , rightmax);
            int waterLevel = Math.min(leftMax[i] , rightMax[i]);
            //trappedwater = (waterlevel - height) * width ;  //width = 1
            trappedWater += (waterLevel - height[i]) * width;
        }
        return trappedWater;
   }

   public static int buyandSell(int prices[]){
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit , maxProfit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
   }

   public static void rightrotate(int arr[] , int k){
       int n = arr.length;
       int j=0;
       while(j <= k){
            int last = arr[n-1];
            for(int i=n-1; i>0; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = last;
            j++;
       }   
   }

   public static void reverse(int arr[] , int start , int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void bubble(int arr[]){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                 if(arr[j] > arr[j+1]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
            }
        }
    }

    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int minPos = i;
             for(int j=i+1; j<n; j++){
                 if(arr[minPos] > arr[j]){
                    minPos = j;
                 }
             }
             int temp = arr[minPos];
             arr[minPos] = arr[i];
             arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                 arr[prev+1] = arr[prev];
                 prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]){
         int largest = Integer.MIN_VALUE;
         for(int i =0; i<arr.length; i++){
            largest = Math.max(arr[i] , largest);
         }

         int count[] = new int[largest+1];
         for(int i=0; i<arr.length; i++){
             count[arr[i]]++;
         }

         int j=0;
         for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
         }
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
             int mid = (end + start)/2;
             if(nums[mid] == target){ 
                  return mid;
             }
             if(nums[mid] >= nums[start]){
                 if(target >= nums[start] && target < nums[mid]){
                     end = mid-1;
                 }else{
                    start = mid+1;
                 }
             }else{
                if(target > nums[mid] && target <= nums[end]){
                     start = mid+1;
                }else{
                    end = mid - 1;
                }
             }
        }
        return -1;
    }

    public static int singleNumber(int[] arr) {
        int n = arr.length;
        int ans = 0;
        if(n == 0){
            return -1;
        }else{
            int lg = -1;
            for(int i=0; i<arr.length; i++){
                lg = Math.max(arr[i] , lg);
            }
            int freq[] = new int[lg+1];
            for(int i=0; i<arr.length; i++){
                freq[arr[i]]++; 
            }
            for(int i=0; i<freq.length; i++){
                if(freq[i] == 1){
                    ans = i;
                }
            }
        }
        return ans;
    }
    

    public static int friendsPairing(int n){
         if(n == 1 || n == 2){
            return n;
         }
        
         //single
         int fnm1 = friendsPairing(n-1);

         //pair
         int fnm2 = friendsPairing(n-2);
         int pairways = (n-1) * fnm2;

         //total ways
         int totalWays = fnm1 + pairways;
        return totalWays;
    }
    public static void printBinStrings(int n , int last , String str){
         if(n == 0){
            System.out.println(str);
            return;
         }
         printBinStrings(n-1, 0, str+"0");
         if(last == 0){
             printBinStrings(n-1, 1, str+"1");
         }
    }

    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(singleNumber(arr));
    }
}

 