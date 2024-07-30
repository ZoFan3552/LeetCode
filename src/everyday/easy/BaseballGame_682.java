package everyday.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/29 下午12:36
 */
public class BaseballGame_682 {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        for (String operation : operations) {
            int currentScore;
            switch (operation) {
                case "+" -> {
                    currentScore = scores.get(scores.size() - 1) + scores.get(scores.size() - 2);
                    scores.add(currentScore);
                }
                case "D" -> {
                    currentScore = scores.get(scores.size() - 1) * 2;
                    scores.add(currentScore);
                }
                case "C" -> scores.remove(scores.size() - 1);
                default -> scores.add(Integer.parseInt(operation));
            }
        }
        int totalScore = 0;
        for (Integer score : scores) {
            totalScore += score;
        }
        return totalScore;
    }
}
