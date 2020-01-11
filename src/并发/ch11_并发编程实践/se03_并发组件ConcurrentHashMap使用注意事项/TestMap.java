package 并发.ch11_并发编程实践.se03_并发组件ConcurrentHashMap使用注意事项;

import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//put(k,v)方法判断如果key存在,则value覆盖原来的值并返回,
//如果不存在则把value放入并返回null
public class TestMap {
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

                map.put("topic1", list1);
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

                map.put("topic1", list1);
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

                map.put("topic2", list1);
                System.out.println(JSON.toJSONString(map));
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
