package org.xutils.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static Gson gson;

    static {
        gson = new GsonBuilder().disableHtmlEscaping().create();
    }

    public static <T> String obj2Json(T t) {
        return gson.toJson(t);
    }

    public static <T> T json2Obj(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getString(JSONObject json, String key) {
        String value = "";
        try {
            value = json.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static int getInt(JSONObject json, String key) {
        int value = -1;
        try {
            value = json.getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static List<String> parseJsonToList(String jsonstr, String key) {
        JSONObject userJson = null;
        JSONArray arrayjson = null;
        List<String> list = null;
        if (jsonstr != null) {
            try {
                userJson = new JSONObject(jsonstr);
                String newStr = userJson.getString(key);
                arrayjson = new JSONArray(newStr);
                list = new ArrayList<String>();
                for (int i = 0; i < arrayjson.length(); i++) {
                    list.add(arrayjson.get(i).toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static <T> List<?> parseJsonToList(String jsonstr, Class<T> calss) {
        JSONArray arrayjson = null;
        List<T> list = null;
        if (jsonstr != null) {
            try {
                arrayjson = new JSONArray(jsonstr);
                list = new ArrayList<T>();
                for (int i = 0; i < arrayjson.length(); i++) {
                    list.add(json2Obj(arrayjson.get(i).toString(), calss));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
