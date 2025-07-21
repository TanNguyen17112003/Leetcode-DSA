class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); // nếu đã có, cộng thêm 1
            } else {
                map.put(num, 1); // nếu chưa có, gán = 1
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0; // fallback (không nên xảy ra với đề bài đúng)
    }
}
