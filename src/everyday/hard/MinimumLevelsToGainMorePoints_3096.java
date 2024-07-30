package everyday.hard;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/19 上午9:59
 */
public class MinimumLevelsToGainMorePoints_3096 {
    public int minimumLevels(int[] possible) {
        int  totalScores = 0;
        int[] preScores = new int[possible.length];
        for (int i = 0; i < possible.length; i++) {
            if (possible[i] == 0) {
                totalScores--;
            }else {
                totalScores++;
            }
            preScores[i] = totalScores;
        }
        for (int i = 0; i < possible.length - 1; i++) {
            int Alice = preScores[i];
            int Bob = preScores[possible.length - 1] - preScores[i];
            if (Alice > Bob) {
                return i + 1;
            }
        }
        return -1;
    }
}
