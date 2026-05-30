public class Practice {
    public static void maxArea(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        rightMax[rightMax.length-1] = height[height.length-1];
        for(int i=1; i<leftMax.length; i++){
             leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }
        for(int i = rightMax.length-2; i>=0; i--){
             rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }
        for(int i=0; i<leftMax.length; i++){
            System.out.print(rightMax[i] + " ");
        }

    }
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }
}
