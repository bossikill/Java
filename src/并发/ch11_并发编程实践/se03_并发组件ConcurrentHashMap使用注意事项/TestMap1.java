package 并发.ch11_并发编程实践.se03_并发组件ConcurrentHashMap使用注意事项;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//putIfAbsent(k,v),如果key存在则直接返回原来对应的值并不使用value覆盖,如果key不存在则放入value并返回null
//判断key是否存在和放入是原子性操作
public class TestMap1 {
    //1 创建map,key为topic,value为设备列表
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //  进入直播间topic1,线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device1");
                list1.add("device2");

                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });

        //  进入直播间topic1,线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device11");
                list1.add("device22");

                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });

        //  进入直播间topic2,线程three
        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device111");
                list1.add("device222");

                List<String> oldList = map.putIfAbsent("topic2", list1);
                if (null != oldList) {
                    oldList.addAll(list1);
                }
                System.out.println(JSON.toJSONString(map));
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
