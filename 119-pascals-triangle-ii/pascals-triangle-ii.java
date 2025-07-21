class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<=rowIndex; i++) {
            int index = calculateC(i, rowIndex);
            result.add(index);
        }

        return result;

    }

    private int calculateC(int k, int n) {
        if (k > n-k) k=n-k;

        long result = 1;
        for (int i=0; i<k; i++) {
            result *= (n-i);
            result /= (i+1);
        }

        return (int) result;
    }
}