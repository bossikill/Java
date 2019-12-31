package 并发.ch03_Java并发包中ThreadLocalRandom类原理剖析;


import java.util.concurrent.ThreadLocalRandom;

//ThreadLocalRandom使用方法
public class RandomTest2 {
    public static void main(String[] args) {
        //创建一个默认种子的随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        //输出10个在0~5(包含0,不包含5)之间的随机数
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}
