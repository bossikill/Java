package 多线程编程;

//线程安全
//机票数据库
public class TicketDB1 {
    //机票数量
    private int ticketCount = 5;

    //获得当前机票数量
    public synchronized int getTicketCount() {
        return ticketCount;
    }

    //销售机票
    public synchronized void sellTicket() {
        try {
            //等于用户付款
            //线程休眠,阻塞当前线程,模拟等待用户付款
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.printf("第%d号票,已经售出\n", ticketCount);
        ticketCount--;
    }
}
