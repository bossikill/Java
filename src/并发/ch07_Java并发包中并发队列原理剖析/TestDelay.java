package 并发.ch07_Java并发包中并发队列原理剖析;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//DelayQueue延迟队列
public class TestDelay {
    static class DelayedEle implements Delayed {

        private final long delayTime;//延迟时间
        private final long expire;//到期时间
        private String taskName;//任务名称

        public DelayedEle(long delay, String taskName) {
            delayTime = delay;
            this.taskName = taskName;
            expire = System.currentTimeMillis() + delay;
        }

        /**
         * 剩余时间=到期时间-当前时间
         *
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 优先级队列里面的优先级规则
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DelayedEle{");
            sb.append("delay=").append(delayTime);
            sb.append(",expire=").append(expire);
            sb.append(",taskName='").append(taskName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        //1 创建delay队列
        DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();

        //2 创建延迟任务
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            DelayedEle element = new DelayedEle(random.nextInt(500), "task:" + i);
            delayQueue.offer(element);
        }

        //3 依次取出任务并打印
        DelayedEle ele = null;
        try {
            //3.1   循环,如果想避免虚假唤醒,则不能把全部元素都打印出来
            for (; ; ) {
                //3.2   获取过期任务并打印
                while ((ele = delayQueue.take()) != null) {
                    System.out.println(ele.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
