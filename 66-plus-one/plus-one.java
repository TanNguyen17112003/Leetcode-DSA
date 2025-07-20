class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        int memory = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int newDigit = digits[i] + memory;
            if (newDigit >= 10) memory = 1;
            else memory = 0;
            result.add(0, newDigit % 10);
        }

        if (memory == 1) result.add(0, 1);

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }

        return arr;
        
    }
}