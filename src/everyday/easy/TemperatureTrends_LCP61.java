package everyday.easy;

public class TemperatureTrends_LCP61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] trendsA = new int[temperatureA.length - 1];
        int[] trendsB = new int[temperatureB.length - 1];
        for (int i = 0; i < temperatureA.length - 1; i++) {
            if (temperatureA[i + 1] > temperatureA[i]){
                trendsA[i] = 1;
            }else if (temperatureA[i + 1] < temperatureA[i]){
                trendsA[i] = -1;
            }else {
                trendsA[i] = 0;
            }
        }

        for (int i = 0; i < temperatureB.length - 1; i++) {
            if (temperatureB[i + 1] > temperatureB[i]){
                trendsB[i] = 1;
            }else if (temperatureB[i + 1] < temperatureB[i]){
                trendsB[i] = -1;
            }else {
                trendsB[i] = 0;
            }
        }
        int maxDay = 0 , temp = 0;
        int index = 0;
        while (index < trendsA.length && index < trendsB.length){
            if (trendsA[index] != trendsB[index]){
                maxDay = Math.max(maxDay , temp);
                temp = 0;
            }else {
                temp++;
            }
            index++;
        }
        maxDay = Math.max(maxDay , temp);
        return maxDay;
    }

    public static void main(String[] args) {
        int res = new TemperatureTrends_LCP61().temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17});
    }
}
