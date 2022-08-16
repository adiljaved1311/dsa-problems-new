package neetcode.twoPointer;

//https://leetcode.com/problems/container-with-most-water/
/*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxArea {
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int minHeight = Math.min(height[left],height[right]);
            int currentArea = minHeight * (right - left);
            maxArea = Math.max(maxArea,currentArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
