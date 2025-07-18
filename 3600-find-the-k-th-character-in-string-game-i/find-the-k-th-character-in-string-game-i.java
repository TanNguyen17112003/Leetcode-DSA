class Solution {
    public char kthCharacter(int k) {
        // Tìm độ sâu nhỏ nhất n sao cho 2^n >= k
        int depth = 0;
        while ((1 << depth) < k) {
            depth++;
        }
        return findChar(depth, k);
    }

    private char findChar(int level, int k) {
        if (level == 0) return 'a';  // S_0 = "a"
        
        int half = 1 << (level - 1); // 2^(level - 1)

        if (k <= half) {
            return findChar(level - 1, k);
        } else {
            char prev = findChar(level - 1, k - half);
            return nextChar(prev);
        }
    }

    private char nextChar(char c) {
        return (c == 'z') ? 'a' : (char)(c + 1);
    }
}
