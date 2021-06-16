package com.example.derevyanko;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class recipesAPI {

    public static interface CallBack{
        public void Run(ArrayList<JSONObject> list);
    }

    public static void gerResipes(RequestQueue queue, String q, String diet, CallBack response){
        ArrayList<JSONObject> list = new ArrayList<>();
        String url = "https://api.edamam.com/search?q=" + q + "&app_id=4da5a427&app_key=6dd6f99730da1737e964379d886e607d&diet=" + diet;
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, jsonObject -> {
            try {
                JSONArray recipes = jsonObject.getJSONArray("hits");
                for (int i = 0; i < recipes.length(); i++) {
                    JSONObject recipe = ((JSONObject)recipes.get(i)).getJSONObject("recipe");
                    list.add(recipe);
                }
                response.Run(list);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();
        });
        queue.add(req);
    }
}
