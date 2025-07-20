class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (nums[index] == val) {
                for (int j = index; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
            }
            else {
            index++;
            }
        }
        return len;
    }
}