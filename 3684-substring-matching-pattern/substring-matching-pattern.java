class Solution {
    public boolean hasMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        int specialIndex = p.indexOf('*');
        String p1 = p.substring(0, specialIndex);                       
        String p2 = p.substring(specialIndex+1);
        
        int firstIndex = s.indexOf(p1);
        int secondIndex = s.lastIndexOf(p2);

        if ((firstIndex == -1 && p1 != "") || (secondIndex == -1 && p2 != "")) return false;
        if (firstIndex >= secondIndex && (p1 != "" && p2 != "")) return false;
        if (secondIndex - firstIndex < p1.length() && (p1 != "" && p2 != "")) return false;
        return true;
    }
}