package neetcode.twoPointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] leftArray = new int[height.length];
        int[] rightArray = new int[height.length];
        int trapArea = 0;
        leftArray[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], height[i]);
        }
        rightArray[height.length - 1] = 0;
        for (int i = 0; i < height.length; i++) {
            int currentArea = Math.min(leftArray[i], rightArray[i]) - height[i];
            if(currentArea > 0 ){
                trapArea += currentArea;
            }
        }
        return trapArea;
    }

    // space -> O(1)
    public int trap1(int[] heights) {
        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }

        return res;

    }
}
