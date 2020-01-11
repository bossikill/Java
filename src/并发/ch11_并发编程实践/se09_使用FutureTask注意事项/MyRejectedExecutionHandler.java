package 并发.ch11_并发编程实践.se09_使用FutureTask注意事项;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//FutureTask,当拒绝策略为DiscardPolicy和DiscardOldestPolicy时,
//在被拒绝的任务的FutureTask对象上调用get()方法会导致调用线程一直阻塞,
//所以日常开发中尽量使用带超时参数的get方法以避免线程一直阻塞
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runable, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            if (null != runable && runable instanceof FutureTask) {
                ((FutureTask) runable).cancel(true);
            }
        }
    }
}
