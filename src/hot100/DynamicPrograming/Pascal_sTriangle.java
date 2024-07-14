package hot100.DynamicPrograming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pascal_sTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0){
            return res;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        res.add(new ArrayList<>(dp));
        if (numRows == 1){
            return res;
        }
        dp.add(1);
        res.add(new ArrayList<>(dp));
        if (numRows == 2){
            return res;
        }
        for (int i = 3; i <= numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < dp.size(); j++){
                temp.add(dp.get(j - 1) + dp.get(j));
            }
            temp.add(1);
            res.add(new ArrayList<>(temp));
            dp = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Pascal_sTriangle().generate(5);
        System.out.println(res);
    }
}
