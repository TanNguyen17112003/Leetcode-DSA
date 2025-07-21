class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = helper(i);
            result.add(item);
        }

        return result;
    }

    public List<Integer> helper(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(combination(n, i));
        }
        return result;
    }

    public int combination(int n, int k) {
        if (k > n - k)
            k = n - k;

        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return (int) result;
    }
}