package 反射;

public class Student extends Person {
    protected String school;

    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ",age=" + age + ",school=" + school + "]";
    }
}
