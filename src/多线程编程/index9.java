package 多线程编程;

//线程安全,临界资源问题,synchronized语句
public class index9 {
    public static void main(String[] args) {
        TicketDB db = new TicketDB();

        //创建线程t1
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (db) {
                    int currTicketCount = db.getTicketCount();
                    //查询是否邮票
                    if (currTicketCount > 0) {
                        db.sellTicket();
                    } else {
                        //无票推出
                        break;
                    }
                }
            }
        });
        t1.start();

        //创建线程t1
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (db) {
                    int currTicketCount = db.getTicketCount();
                    //查询是否邮票
                    if (currTicketCount > 0) {
                        db.sellTicket();
                    } else {
                        //无票推出
                        break;
                    }
                }
            }
        });
        t2.start();
    }
}
