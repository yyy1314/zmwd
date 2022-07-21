package com.hua.huade001android;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.Toast;
// AppCompatActivity是一种向下兼容的Activity
// 可以将Activity在各个系统版本中增加的特性和功能最低兼容到Android 2.1系统

public class MainActivity extends BaseActivity {

    // 打开右上角的menu事件
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Log.i("main", "menu");
        return super.onMenuOpened(featureId, menu);
    }

    // 点击菜单的事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.i("main", "open setings");
            return true;
        }
        if (id == R.id.action_add) {
            Log.i("main", "open add");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("main", "created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // findViewById()方法获取到在布局文件中定义的元素
        FloatingActionButton fab = findViewById(R.id.fab);

        // 按钮注册一个监听
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 3个参数是，上下文，内容，时长
                Toast.makeText(MainActivity.this, "you click this", Toast.LENGTH_LONG).show();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // 显式Intent 跳转活动 ，第一个参数Context要求提供一个启动活动的上下文，第二个参数Class则是指定想要启动的目标活动
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                // intent 传参
                intent.putExtra("name", "intent-data1");
                // startActivity(intent);

                // 接收返回结果
                startActivityForResult(intent, 1);

            }
        });

    }

    // 活动在回收之前，一定会执行的方法
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String name = "saved from gc";
        outState.putString("name1", name);
    }

    @Override
    protected void onRestart() {
        Log.i("main", "restart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("main", "onResume");
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        Log.i("main", "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String returnData = data.getStringExtra("data-return");
                Log.i("main", returnData);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
