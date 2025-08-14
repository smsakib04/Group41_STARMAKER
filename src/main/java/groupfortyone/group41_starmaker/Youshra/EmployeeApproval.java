package groupfortyone.group41_starmaker.Youshra;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EmployeeApproval {
    private String name;
    private int id;
    private String role;
    private String department;

    public static ArrayList<EmployeeApproval> employee = new ArrayList<EmployeeApproval>();
    @javafx.fxml.FXML
    private TextField AmountTextField;
    @javafx.fxml.FXML
    private TextField SuccessfulTextField;
    @javafx.fxml.FXML
    private DatePicker DatePicker;
    @javafx.fxml.FXML
    private TextField ExpenseTypeTextField;

    public EmployeeApproval(String name, int id, String role, String department) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.department = department;
    }

    public EmployeeApproval() {
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

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @javafx.fxml.FXML
    public void handlePreviousButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSenDRequestButton(ActionEvent actionEvent) {
    }
}
