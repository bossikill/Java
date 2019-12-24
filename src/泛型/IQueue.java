package 泛型;

//自定义泛型接口
public interface IQueue<T> {
    //入队方式
    public void queue(T item);

    //出队方式
    public T dequeue();
}
