package com.example.shixuntest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Day3_3Activity extends AppCompatActivity {
    // 定义此Activity的请求码
    public static final int TEST_REQUEST = 1;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_3);
        Button mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Day3_3Activity.this, Day3_2Activity.class);
                // 使用的方法变了
                // 第一个参数：intent对象
                // 第二个参数：请求码
                startActivityForResult(intent, TEST_REQUEST);
            }
        });
        
    }

    // 此页面发起请求的页面完成返回时此页面的回调
    // 参数一：请求码
    // 参数二：结果码
    // 参数三：如果上个页面有数据，可以在第三个参数中取出
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "requestCode-->" + requestCode + ",resultCode-->" + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
