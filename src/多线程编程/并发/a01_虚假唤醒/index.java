package 多线程编程.并发.a01_虚假唤醒;

import java.util.concurrent.ArrayBlockingQueue;

//notifyAll后理论上只有得到了offer的队列才会被notify 应该只返回一个Hello 但是这里返回了好多null 与预期不符
//这就是虚假唤醒
public class index {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        waitFor(queue);
                    }
                    System.out.println(queue.poll());
                }
            }).start();
        }
        threadSleep();
        synchronized (queue) {
            queue.offer("Hello");
            queue.notifyAll();
        }
    }

    private static void threadSleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitFor(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}