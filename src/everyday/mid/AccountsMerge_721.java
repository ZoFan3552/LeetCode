package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/15 上午10:14
 */
public class AccountsMerge_721 {
    private final Map<String , String> emailToAccountName = new HashMap<>();
    private final Map<String , String> parent = new HashMap<>();//并查集的父链接数组

    public String find(String s){
        if (!parent.containsKey(s)) parent.put(s, s);
        if (!s.equals(parent.get(s))){
            // 路径压缩：递归地将s的所有祖先节点直接连接到根节点
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    private void union(String x , String y){
        parent.put(find(x), find(y));
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //初始化并查集
        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToAccountName.put(email, accountName);
                union(firstEmail, email);
            }
        }
        //根据根节点合并邮箱
        Map<String ,TreeSet<String>> mergedAccount = new HashMap<>();
        for (String email : emailToAccountName.keySet()) {
            String root = find(email);
            mergedAccount.computeIfAbsent(root , k -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (TreeSet<String> emails : mergedAccount.values()) {
            List<String> newAccount = new ArrayList<>();
            newAccount.add(emailToAccountName.get(emails.first()));
            newAccount.addAll(emails);
            result.add(newAccount);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
