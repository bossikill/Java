package 网络编程;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//JSON编码
public class index {
    public static void main(String[] args) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "tony");
            jsonObject.put("age", 30);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(1).put(3);
            jsonObject.put("a", jsonArray);
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
