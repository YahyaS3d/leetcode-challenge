class Solution {
    public int romanToInt(String s) {
        int result = 0; //init the result value 
        int prevValue = 0; //check the previous value
        //max length is 15 as it's assign in the txt instruction 
        for (int i = s.length() - 1; i >= 0; i--) { 
            char currentSymbol = s.charAt(i); 
            int currentValue = romanToValue(currentSymbol);
            //update every character in the string array! 
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
    //change every character to it value
    private int romanToValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
