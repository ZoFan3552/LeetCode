package hot100.Stack;

import java.util.LinkedList;
import java.util.List;

public class LargestRectangleinHistogram {
    /*
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

    求在该柱状图中，能够勾勒出来的矩形的最大面积。

     */
    public int largestRectangleArea(int[] heights) {
       LinkedList<Integer> stack = new LinkedList<>();//记录柱子下标，栈是单调递增的
       LinkedList<Integer> zeroStack = new LinkedList<>();//记录柱子下标，栈是单调递增的
        int maxArea = 0;
        int zeroIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0){//遇到0,说明遇到断层，将当前栈里面的最大面积算出来
                zeroIndex = i + 1;
                if (zeroStack.isEmpty()){
                    zeroStack.add(zeroIndex);
                }
                if (!stack.isEmpty()){
                    int last = stack.peek();
                    while (!stack.isEmpty()){
                        Integer topHeight = stack.pop();
                        if (stack.isEmpty()){
                            maxArea = Math.max(maxArea, heights[topHeight] * (topHeight + 1 - zeroStack.pop()));
                        }else {
                            maxArea = Math.max(maxArea, heights[topHeight] * (last - topHeight + 1 - zeroStack.pop()));
                        }
                    }
                }
                zeroStack.add(zeroIndex);
            }else {
                if(stack.isEmpty() || heights[stack.peek()] < heights[i]){//每次将当前栈的最小高度构成的矩形面积算出
                    stack.push(i);
                    maxArea = Math.max(maxArea, heights[stack.getLast()] * (i + 1 - zeroIndex));
                }else {
                    int last = stack.peek();
                    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                        Integer topHeight = stack.pop();
                        if (stack.isEmpty()){
                            maxArea = Math.max(maxArea, heights[topHeight] * (topHeight + 1 - zeroIndex));
                        }else {
                            maxArea = Math.max(maxArea, heights[topHeight] * (last - topHeight + 1 - zeroIndex));
                        }
                    }
                    stack.push(i);
                    maxArea = Math.max(maxArea, heights[i] * (i + 1 - zeroIndex));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int res = new LargestRectangleinHistogram().largestRectangleArea(new int[]{1,2,2});
        System.out.println(res);
    }
}
