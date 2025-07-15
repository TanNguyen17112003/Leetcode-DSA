class Solution {
   
    public String convertHelper(int num, int level) {
        String result = "";
        int number = (int) (num * Math.pow(10, level));
        int div = 0;
        if (number >= 1000)  {
            div = number / 1000;
            for (int i = 0; i < div; i++) {
                result += "M";
            }
        }
        else if (number == 900) return "CM";
        else if (number >= 500) {
            div = (number - 500) / 100;
            result += "D";
            for (int i = 0; i < div; i++) {
                result += "C";
            }
        }
        else if (number == 400) return "CD";
        else if (number >= 100) {
            div = number / 100;
            for (int i = 0; i < div; i++) {
                result += "C";
            }
        }
        else if (number == 90) return "XC";
        else if (number >= 50) {
            result += "L";
            div = (number - 50) / 10;
            for (int i = 0; i < div; i++) {
                result += "X";
            }
        }
        else if (number == 40) return "XL";
        else if (number >= 10) {
            div = number / 10;
            for (int i = 0; i < div; i++) {
                result += "X";
            }
        }
        else if (number == 9) return "IX";
        else if (number >= 5) {
            result += "V";
            div = number -5;
            for (int i = 0; i < div; i++) {
                result += "I";
            }
        }
        else if (number == 4) return "IV";
        else {
            div = number;
            for (int i = 0; i < div; i++) {
                result += "I";
            }
        }
        return result;
    }

    public String intToRoman(int num) {
        String result = "";
        int index = 0;
        while (num != 0) {
            int remainer = num % 10;
            String test = convertHelper(remainer, index);
            result = test + result;
            num /= 10;
            index++;
        }
        return result;
    }
}