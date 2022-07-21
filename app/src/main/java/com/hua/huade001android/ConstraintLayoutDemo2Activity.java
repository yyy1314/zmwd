package com.hua.huade001android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstraintLayoutDemo2Activity extends AppCompatActivity {

    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_demo2);

        // 将系统自带的标题栏隐藏掉
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ListView listview = (ListView)findViewById(R.id.listview);
        String[] str = {"上海","北京","天津","江苏","河南","西藏","新疆","湖南","湖北","山东"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.list_item,str);//listdata和str均可
        listview.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_demo2);
        ListView listview = findViewById(R.id.listview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,putData(),
                R.layout.list_item2,
                new String[]{"name","age","pic"},new int[]{R.id.tv1,R.id.tv2,R.id.iv1});
        listview.setAdapter(simpleAdapter);

        // 每一项的点击事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                Log.v("main", index + "");
            }
        });
    }

    public List<Map<String,Object>> putData(){

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("name", "张三");
        map1.put("age", "19岁");
        map1.put("pic", R.drawable.dog);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("name", "李四");
        map2.put("age", "17岁");
        map2.put("pic", R.drawable.dog2);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("name", "王五");
        map3.put("age", "17岁");
        map3.put("pic", R.drawable.dog2);

        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }

}
