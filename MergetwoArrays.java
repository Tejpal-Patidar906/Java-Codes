public class MergetwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i<m+n; i++){
            for(int j=0; j<n; j++){
                nums1[i] = nums2[j];
            }
        }
    }

    public static void main(String[] args){
        
    }
}
