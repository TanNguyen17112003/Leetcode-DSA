class Solution {
    public int[] finalPrices(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) { 
                list.add(prices[i]); 
                continue;
            }
            boolean match = false;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    list.add(prices[i]-prices[j]);
                    match = true;
                    break;
                }
            }
            if (match == false) list.add(prices[i]);
        }


        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}