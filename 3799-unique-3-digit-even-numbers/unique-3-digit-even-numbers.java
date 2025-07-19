
class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        generateNumbers(digits, 0, 0, used, result);
        return result.size();
    }

    private void generateNumbers(int[] digits, int depth, int number, boolean[] used, Set<Integer> result) {
        if (depth == 3) {
            if (number % 2 == 0 && number >= 100) { // số chẵn và có 3 chữ số
                result.add(number);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            if (depth == 0 && digits[i] == 0) continue; // không cho số bắt đầu bằng 0

            used[i] = true;
            generateNumbers(digits, depth + 1, number * 10 + digits[i], used, result);
            used[i] = false; // backtrack
        }
    }
}
