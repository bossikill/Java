package 集合;

import java.util.HashMap;
import java.util.Map;

//Map集合
public class MapClass {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");
        //"李四"值重复
        map.put(111, "李四");
        //109键已经存在,替换原来值"王五"
        map.put(109, "刘备");

        //打印集合元素个数
        System.out.println("集合size=" + map.size());
        //打印集合
        System.out.println(map);

        //通过键取值
        System.out.println("109 - " + map.get(109));
        System.out.println("108 - " + map.get(108));

        //删除键值对
        map.remove(109);
        //判断键集合中是否包含109
        System.out.println("键集合中是否包含109:" + map.containsKey(109));
        //判断值集合是否包含"李四"
        System.out.println("值集合中是否包含:" + map.containsValue("李四"));

        //判断集合是否为空
        System.out.println("集合是空的:" + map.isEmpty());

        //清空集合
        map.clear();
        System.out.println(map);
    }
}
