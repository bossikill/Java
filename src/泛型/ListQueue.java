package 泛型;

import java.util.ArrayList;
import java.util.List;

//自定义泛型接口
public class ListQueue<T> implements IQueue<T> {
    private List<T> items;

    public ListQueue() {
        this.items = new ArrayList<T>();
    }

    @Override
    public void queue(T item) {
        this.items.add(item);
    }

    @Override
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
}
