package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Staff {
    private String name;
    private int id;
    private String role;
    public String department;

    public static ArrayList<Staff> staffList = new ArrayList<Staff>();
    public Staff(String name, int id, String role, String department) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.department = department;
    }

    public Staff() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public static ArrayList<Staff> getStaff() {
        return staffList;
    }

    public static void setStaff(ArrayList<Staff> staff) {
        Staff.staffList = staff;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
