package groupfortyone.group41_starmaker.Raghib;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profile {
    private String name;
    private String email;
    private int age;
    private LocalDate dob;
    private String bloodgroup;
    private String maritalstatus;

    public static ArrayList<Profile>profileList=new ArrayList<>();

    public Profile(String name, String email, int age, LocalDate dob, String bloodgroup, String maritalstatus) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.bloodgroup = bloodgroup;
        this.maritalstatus = maritalstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", maritalstatus='" + maritalstatus + '\'' +
                '}';
    }
}
