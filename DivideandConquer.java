public class DivideandConquer {

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[] , int si , int ei){
         if(si >= ei){
            return;
         }
         int mid = si + (ei - si)/2;
         mergeSort(arr, si, mid);  //left part
         mergeSort(arr, mid+1, ei); //right part
         merge(arr, si, mid, ei);
    }

    public static void merge(int arr[] , int si , int mid , int ei){
          int temp[] = new int[ei - si + 1];
          int i = si;  //iterator for left part
          int j = mid+1;  //iterator for right part
          int k = 0;  //iterator for temp arr

          while(i <= mid && j <= ei){
              if(arr[i] < arr[j]){
                  temp[k] = arr[i];
                  i++;
              }else{
                 temp[k] = arr[j];
                 j++;
              }
              k++;
          }

          //left part
          while(i <= mid){
               temp[k++] = arr[i++];
          }
          //right part
          while(j <= ei){
             temp[k++] = arr[j++];
          }

          //copy temp to original array
          for(k=0 , i=si; k<temp.length; k++ , i++){
               arr[i] = temp[k];
          }
    }

    public static void quickSort(int arr[] , int si , int ei){
         if(si >= ei){
             return;
         }
         int pIdx = partition(arr , si , ei);
         quickSort(arr, si, pIdx-1);   // left part
         quickSort(arr, pIdx+1, ei);  // right part
    }

    public static int partition(int arr[] , int si , int ei){
         int i = si-1;
         int pivot = arr[ei];
         for(int j=si; j<ei; j++){
             if(arr[j] <= pivot){
                 i++;
                 int temp = arr[j];
                 arr[j] = arr[i];
                 arr[i] = temp;
             }
         }
         i++;
         int temp = pivot;
         arr[ei] = arr[i];
         arr[i] = temp; 
       return i;
    }


     public static int search(int arr[] , int target , int si , int ei){
         if(si > ei){
            return -1;
         }
         int mid = si + (ei - si)/2;
         if(arr[mid] == target){
            return mid;
         }

         if(arr[si] <= arr[mid]){
             if(arr[si] <= target && arr[mid] >= target){
                 return search(arr, target, si, mid-1);
             }else{
                return search(arr, target, mid+1, ei);
             }
         }else{
             if(arr[ei] >= target && arr[mid] <= target){
                 return search(arr, target, mid+1, ei);
             }else{
                return search(arr, target, si, mid-1);
             }
         }
    }

    public static int search1(int arr[] , int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
             int mid = start + (end - start) / 2;
             if(arr[mid] == target){
                return mid;
             }
             if(arr[mid] >= arr[start]){
                 if(arr[start] <= target && target < arr[mid]){
                     end = mid-1;
                 }else{
                     start = mid+1;
                 } 
             }else{
                 if(arr[mid] < target && arr[end] >= target){
                     start = mid + 1;
                 }else{
                     end = mid-1;
                 }
             }
        }
        return -1;
    }
    public static void main(String[] args){
         int arr[] = {4,5,6,7,0,1,2};
         System.out.println(search1(arr, 0));
    }
}


