package com.example.okgodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.io.FileReader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String URL = "http://mobsec-dianhua.baidu.com/dianhua_api/open/location?tel=";
    //   绑定控件
    private TextView tvShow;
    private Button btnGet;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = findViewById(R.id.tv_show);
        btnGet = findViewById(R.id.btn_get);
        editText = findViewById(R.id.edit_tel);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //把文本框获取到的数据放在get（）
                OkGo.get(URL + editText.getText().toString())
                        .tag(this)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
//                        Toast.makeText(MainActivity.this,s.toString(),Toast.LENGTH_SHORT).show();//弹窗显示
//                        tvShow.setText(s.toString());
                                JsontoJava(s,editText.getText().toString());
                            }
                        });
            }
        });
    }

    //Gson 解析
    private void JsontoJava(String jsonData,String tel) {
        //借助java类
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(String.class, new StringNullAdapter());
//        Gson gson = gsonBuilder.create();
//        Bean bean = gson.fromJson(jsonData,Bean.class);
//        String province = bean.getResponse().get_$13208927286().getLocation();
//        tvShow.setText(province);
        //Map
//        Type mapType = new TypeToken<Map<String,Map<String,Map<String,String>>>>() {}.getType();
//        Map<String,Map<String,Map<String,String>>> map = gson.fromJson(jsonData,mapType);
//        String i = map.get("response").get(tel).get("location");
//        tvShow.setText(i);
        //不借助java类
        // json解析器，解析json数据
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonData);
        //json属于对象类型时
        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject(); // 转化为对象

            JsonObject response = object.getAsJsonObject("response");
            JsonObject Tel = response.getAsJsonObject(tel);
            String location = Tel.get("location").getAsString();
            tvShow.setText(location);
//            int status = responseHeader.get("status").getAsInt();
//            long time = responseHeader.get("time").getAsLong();
//            String version = responseHeader.get("version").getAsString();
//            tvShow.append(status + "");
//            tvShow.append(time + "");
//            tvShow.append(version + "");
        }
    }
}
