package everyday;

public class ApplyDiscountToPrices_2288 {
    public String discountPrices(String sentence, int discount) {
        String[] strings = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String str = updatePrice(strings, i, discount);
            if (i == strings.length - 1){
                res.append(str);
            }else {
                res.append(str).append(" ");
            }
        }
        return res.toString();
    }

    public String updatePrice(String[] strings , int index , int discount){
        String priceStr = strings[index];
        if (priceStr.length() <= 1 || priceStr.charAt(0) != '$'){
            return priceStr;
        }
        char[] priceStrCharArray = priceStr.toCharArray();
        StringBuilder priceBuilder = new StringBuilder();
        for (int i = 1; i < priceStrCharArray.length; i++) {
            if (!Character.isDigit(priceStrCharArray[i])){
                return priceStr;
            }
            priceBuilder.append(priceStrCharArray[i]);
        }
        long price = Long.parseLong(priceBuilder.toString());
        double newPrice = (double) (price * (100 - discount)) / 100;
        return "$" + String.format("%.2f" ,newPrice);
    }
}
