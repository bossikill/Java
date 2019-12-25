package 网络编程;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//JSON解码
public class index2 {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"tony\",\"age\":30,\"a\":[1,3]}";
        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            String name = jsonObject.getString("name");
            System.out.println("name:" + name);

            int age = jsonObject.getInt("age");
            System.out.println("age:" + age);

            JSONArray jsonArray = jsonObject.getJSONArray("a");
            int n1 = jsonArray.getInt(0);
            System.out.println("数组a第一个元素:" + n1);
            int n2 = jsonArray.getInt(1);
            System.out.println("数组a第二个元素:" + n2);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
