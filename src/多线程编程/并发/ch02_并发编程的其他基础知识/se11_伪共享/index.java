package 多线程编程.并发.ch02_并发编程的其他基础知识.se11_伪共享;

//@sun.misc.Contended注解 解决伪共享
public class index {
    @sun.misc.Contended
    public final static class FilledLog {
        public volatile long value = 0L;

        @sun.misc.Contended
        int threadLocalRandomSeed;
    }
}
