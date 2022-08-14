class Solution {
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        return getBillions(num).trim();
    }
    
    public String getBillions(int num) {
        int billions = num / 1000000000;
        int millions = num % 1000000000;
        String billStr = getHundreds(billions);
        if(!billStr.equals("")) billStr += " Billion";
        return billStr + getMillions(millions);
    }
    
    public String getMillions(int num) {
        int millions = num / 1000000;
        int thousands = num % 1000000;
        String millStr = getHundreds(millions);
        if(!millStr.equals("")) millStr += " Million";
        return millStr + getThousands(thousands);
    }
    
    public String getThousands(int num) {
        int thousands = num / 1000;
        int hundreds = num % 1000;
        String thouStr = getHundreds(thousands);
        if(!thouStr.equals("")) thouStr += " Thousand";
        return thouStr + getHundreds(hundreds);
    }
    
    public String getHundreds(int num) {
        int hundredCount = num / 100;
        String hundredCntStr = getOnes(hundredCount);
        if(!hundredCntStr.equals("")) hundredCntStr += " Hundred";
        return hundredCntStr + getOnesTens(num % 100);
    }
    
    public String getOnesTens(int num) {
        if(num < 10) return getOnes(num);
        else if(num < 20) return getTeens(num);
        else {
            return getTens(num) + getOnes(num % 10);
        }
    }
    
    
    public String getOnes(int num) {
        switch(num) {
            case 0: return "";
            case 1: return " One";
            case 2: return " Two";
            case 3: return " Three";
            case 4: return " Four";
            case 5: return " Five";
            case 6: return " Six";
            case 7: return " Seven";
            case 8: return " Eight";
            case 9: return " Nine";
            default: return "";
        }
    }
    
    public String getTeens(int num) {
        switch(num) {
            case 10: return " Ten";
            case 11: return " Eleven";
            case 12: return " Twelve";
            case 13: return " Thirteen";
            case 14: return " Fourteen";
            case 15: return " Fifteen";
            case 16: return " Sixteen";
            case 17: return " Seventeen";
            case 18: return " Eighteen";
            case 19: return " Nineteen";
            default: return "";
        }
    }
    
    public String getTens(int num) {
        num = num / 10;
        switch(num) {
            case 2: return " Twenty";
            case 3: return " Thirty";
            case 4: return " Forty";
            case 5: return " Fifty";
            case 6: return " Sixty";
            case 7: return " Seventy";
            case 8: return " Eighty";
            case 9: return " Ninety";
            default: return "";
        }
    }
    

    

}