package Annotation;

//用于接口注解,声明接口是函数式接口,该注解知识提醒编译器去检查该接口是否仅包含一个抽象方法
@java.lang.FunctionalInterface
interface FunctionalInterface {
    void say();

    //void doSth();//编译错误
}
