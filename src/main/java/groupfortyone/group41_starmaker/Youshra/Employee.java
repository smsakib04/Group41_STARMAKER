package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Employee {
    private String name;
    private String role;
    private int id;
    private String type;
    private String department;

    public static ArrayList<Employee> EmployeeList = new ArrayList<Employee>();

    public Employee(String name, int id, String role, String department, String type) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.department = department;
        this.type = type;
    }

    public Employee() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }

    public static void setEmployeeList(ArrayList<Employee> employeeList) {
        EmployeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}