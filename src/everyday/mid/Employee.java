package everyday.mid;

import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 上午11:59
 */
public class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public Employee(){

    }
}
