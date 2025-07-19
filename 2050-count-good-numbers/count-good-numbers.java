class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPower = powMod(5, evenCount, MOD);
        long oddPower = powMod(4, oddCount, MOD);

        return (int)(evenPower * oddPower % MOD);
    }

    // Hàm tính (base^exp) % mod một cách nhanh chóng (O(log exp))
    private long powMod(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
}
