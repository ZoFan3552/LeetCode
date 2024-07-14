package interview150.ArrayAndString;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        String numStr = String.valueOf(num);
        int unitCol = 0;
        int tenCol = 0;
        int hundredCOl = 0;
        int thousandCol = 0;
        int count = 0;
        for (int i = numStr.length() - 1; i >= 0; i--) {
            final int unitCol1 = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            switch (count) {
                case 0 -> unitCol = unitCol1;
                case 1 -> tenCol = unitCol1 * 10;
                case 2 -> hundredCOl = unitCol1 * 100;
                case 3 -> thousandCol = unitCol1 * 1000;
            }
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String thou =   convert(thousandCol, 1000);
        String hun =   convert(hundredCOl, 100);
        String ten =   convert(tenCol, 10);
        String unit =   convert(unitCol, 1);
        return stringBuilder.append(thou).append(hun).append(ten).append(unit).toString();
    }

    public String convert(int num , int digits){
        if (num == 0) return "";
        switch (digits){
            case 1 -> {
                if (num < 4){
                    return "I".repeat(num);
                }
                if (num == 4){
                    return "IV";
                }
                if (num < 9){
                    return "V" + "I".repeat(num - 5);
                }
                if (num == 9){
                    return "IX";
                }

            }
            case 10 -> {
                int letterNum = num / 10;
                if (letterNum < 4){
                    return "X".repeat(letterNum);
                }
                if (letterNum == 4){
                    return "XL";
                }
                if (letterNum < 9){
                    return "L" + "X".repeat(letterNum - 5);
                }
                if (letterNum == 9){
                    return "XC";
                }
            }
            case 100 -> {
                int letterNum = num / 100;
                if (letterNum < 4){
                    return "C".repeat(letterNum);
                }
                if (letterNum == 4){
                    return "CD";
                }
                if (letterNum < 9){
                    return "D" + "C".repeat(letterNum - 5);
                }
                if (letterNum == 9){
                    return "CM";
                }
            }
            case 1000 -> {
                int letterNum = num / 1000;
                return "M".repeat(letterNum);
            }
        }
        return "";
    }


}
