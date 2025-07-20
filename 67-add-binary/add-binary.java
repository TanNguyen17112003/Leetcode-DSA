class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        char memory = '0';

        while (indexA >= 0 || indexB >= 0) {
            char digitA = indexA >= 0 ? a.charAt(indexA) : '0';
            char digitB = indexB >= 0 ? b.charAt(indexB) : '0';

            Map<Character, Boolean> step1 = binaryAdd(digitA, digitB);
            Character bit1 = step1.keySet().iterator().next();
            Boolean carry1 = step1.get(bit1);

            Map<Character, Boolean> step2 = binaryAdd(bit1, memory);
            Character finalBit = step2.keySet().iterator().next();
            Boolean finalCarry = step2.get(finalBit);

            memory = (carry1 || finalCarry) ? '1' : '0';
            result.insert(0, finalBit);
            
            indexA--;
            indexB--;
        }

        if (memory == '1') result.insert(0, memory);

        return result.toString();
        
    }

    private Map<Character, Boolean> binaryAdd(char c1, char c2) {
        Map<Character, Boolean> result = new HashMap<>();
        if ((c1=='0' && c2=='1') || (c1=='1' && c2=='0')) result.put('1', false);
        else if (c1=='0' && c2=='0') result.put('0', false);
        else result.put('0', true);
        return result;
    }
}