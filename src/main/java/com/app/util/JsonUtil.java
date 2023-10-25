package com.app.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashSet;

public class JsonUtil {
    private static final LinkedHashSet<String> linkedSet = new LinkedHashSet<>();

    public static void jsonToXpathRecur(JSONObject jsonObj, String xpath) {
        jsonObj.keySet().forEach(keyStr -> {
            Object keyvalue = jsonObj.get(keyStr);
            linkedSet.add(xpath + "/" + keyStr);

            //for nested objects iteration if required
            if (keyvalue instanceof JSONObject) {
                jsonToXpathRecur((JSONObject) keyvalue, xpath + "/" + keyStr);
            } else if (keyvalue instanceof JSONArray) {
                JSONArray c = jsonObj.getJSONArray(keyStr);
                for (int i = 0; i < c.length(); i++) {
                    JSONObject obj = c.getJSONObject(i);
                    jsonToXpathRecur(obj, xpath + "/" + keyStr);
                }
            }
        });
    }

    public static String jsonToXpath(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonToXpathRecur(jsonObject, "");
        String joined = String.join("\n", linkedSet);
        linkedSet.clear();
        return joined;
    }
}
