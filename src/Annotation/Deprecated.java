package Annotation;

//@Deprecated API已过时,可以用来注解类,接口,成员方法,成员变量
@java.lang.Deprecated
public class Deprecated {
    @java.lang.Deprecated
    protected String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @java.lang.Deprecated
    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
