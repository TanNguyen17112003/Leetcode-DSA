class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int len = words.length;

        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (i==j) continue;
                if (words[i].length() > words[j].length()) continue;
                if (words[j].indexOf(words[i]) != -1 && !result.contains(words[i])) result.add(words[i]);
            }
        }

        return result;
    }
}