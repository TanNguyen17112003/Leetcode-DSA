class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n]; // đã tính rồi

        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}