package com.example.shixuntest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Day3_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_3);

        //此页面完成上个页面的某种请求
        //完成之后需要一个结果
        setResult(4678);

    }
}
