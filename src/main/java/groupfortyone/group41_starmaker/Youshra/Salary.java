package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Salary {
    private String name;
    private String role;
    private String salary;

    public static ArrayList<Salary> salaryList = new ArrayList<Salary>();

    public Salary(String name, String role, String salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public static ArrayList<Salary> getSalaryList() {
        return salaryList;
    }

    public static void setSalaryList(ArrayList<Salary> salaryList) {
        Salary.salaryList = salaryList;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
