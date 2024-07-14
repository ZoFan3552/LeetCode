package hot100.BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]

 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        backtrack(res , "" , n , n);
        return res;
    }

    public void backtrack(List<String> res, String temp , int  left , int right) {
        //左括号数量必须严格大于右括号数量
        if(right > left){
            return;
        }
        if(left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if(left > 0) {
            backtrack(res, temp + ")", left - 1, right);
        }
        if(right > 0) {
            backtrack(res, temp + "(", left, right - 1);
        }

    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(strings);
    }
}
