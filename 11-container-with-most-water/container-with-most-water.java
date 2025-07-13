class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            result = Math.max(result, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}