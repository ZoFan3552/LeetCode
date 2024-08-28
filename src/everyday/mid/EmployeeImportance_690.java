package everyday.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 下午12:00
 */
public class EmployeeImportance_690 {
    int totalImportance = 0;

    public int getImportance(List<Employee> employees, int id) {
        Employee[] employeesArray = new Employee[2000];
        for (Employee employee : employees) {
            employeesArray[employee.id] = employee;
        }
        Employee e = employeesArray[id];
        totalImportance += e.importance;
        DFS(e, employeesArray);
        return totalImportance;
    }

    public void DFS(Employee e, Employee[] employeesArray) {
        if (e.subordinates == null || e.subordinates.isEmpty()) {
            return;
        }
        for (int id : e.subordinates) {
            Employee subordinate = employeesArray[id];
            totalImportance += subordinate.importance;
            DFS(subordinate, employeesArray);
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 5, new ArrayList<>());
        Employee employee2 = new Employee(2, 3, new ArrayList<>());
        Employee employee3 = new Employee(3, 3, new ArrayList<>());
        employee1.subordinates.add(employee2.id);
        employee1.subordinates.add(employee3.id);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        EmployeeImportance_690 employeeImportance_690 = new EmployeeImportance_690();
        System.out.println(employeeImportance_690.getImportance(employees, 1));
    }
}
