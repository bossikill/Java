package 异常处理;

//自定义异常类
public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }
}

