package com.hua.huade001android;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText input = findViewById(R.id.e1);
        Button btn = findViewById(R.id.btn4);
        final ImageView img = findViewById(R.id.img1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v("main", input.getText().toString());
                img.setImageResource(R.drawable.dog2);

                AlertDialog.Builder dialog = new AlertDialog.Builder(Main3Activity.this);
                dialog.setTitle("this is a title");
                dialog.setMessage("confirm delete ?");

                // 确定按钮
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v("main", "OK");
                    }
                });

                // 取消按钮
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v("main", "cancel");
                    }
                });

                // 是否可以点击遮罩 隐藏弹窗
                dialog.setCancelable(true);
                dialog.show();

            }
        });

        // loading
        ProgressBar p = findViewById(R.id.pro1);
        p.setVisibility(View.GONE);

        // 进度条
        ProgressBar p2= findViewById(R.id.pro2);
        p2.setProgress(50);


        // ProgressDialog 已废弃
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

}
