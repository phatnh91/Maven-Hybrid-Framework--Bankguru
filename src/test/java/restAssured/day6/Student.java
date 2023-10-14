package restAssured.day6;

import java.util.Arrays;

public class Student {

    String name;
    String location;
    String phone;
    String[] courses;

    public Student(){

    }
    public Student(String name, String location, String phone, String[] courses){
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.courses = courses;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void showStudentInfo(){
        System.out.println("Student Name: " + getName());
        System.out.println("Student Location: " + getLocation());
        System.out.println("Student Phone: " + getPhone());
        System.out.println("Student Courses: " + Arrays.toString(getCourses()));
    }

}
