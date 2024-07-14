package interview150.Stack;

import java.util.LinkedList;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        String[] splitPath = path.split("/+");
        for (String str : splitPath) {
            if (!str.isEmpty()){
                if (str.equals(".")){
                    continue;
                }
                if (str.equals("..")){
                    if (!stack.isEmpty()){
                        stack.poll();
                    }
                }else {
                    stack.push(str);
                }
            }
        }
        while (!stack.isEmpty()){
            stringBuilder.append("/");
            stringBuilder.append(stack.removeLast());
        }
        if (stringBuilder.isEmpty()) return "/";
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = new SimplifyPath_71().simplifyPath("/home/user/Documents/../Pictures");
        System.out.println(string);
    }
}
