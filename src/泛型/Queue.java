package 泛型;

import java.util.List;
import java.util.ArrayList;

//自定义泛型类
public class Queue<T> {
    private List<T> items;

    public Queue() {
        this.items = new ArrayList<T>();
    }

    /**
     * 入队方法
     *
     * @param item 参数需要入队的元素
     */
    public void queue(T item) {
        this.items.add(item);
    }

    /**
     * 出队方法
     *
     * @return 返回出队元素
     */
    public T dequeue() {
        if (items.isEmpty()) {
            return null;
        } else {
            return this.items.remove(0);
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }

    public static void main(String[] args) {
        Queue<String> genericQueue = new Queue<String>();
        genericQueue.queue("A");
        genericQueue.queue("C");
        genericQueue.queue("B");
        genericQueue.queue("D");
        //genericQueue.queue(1);//编译错误

        System.out.println(genericQueue);
        genericQueue.dequeue();
        System.out.println(genericQueue);
    }
}
