package com.example.shixuntest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Day3Activity extends AppCompatActivity {

    // 定义此Activity的请求码
    public static final int TEST_REQUEST = 1;
    public static final int CAPTURE = 2;
    private Button mBtn1, mBtn2;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);


        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Day3Activity.this, Day3_2Activity.class);
                // 使用的方法变了
                // 第一个参数：intent对象
                // 第二个参数：请求码
                startActivityForResult(intent, TEST_REQUEST);
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // 使用隐式跳转，跨App跳转
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAPTURE);

            }
        });
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"requestCode--> "+requestCode,Toast.LENGTH_SHORT).show();

        if (requestCode==CAPTURE)
        {
            if (resultCode==RESULT_OK)
            {
                //
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Log.d("MainActivity","Bitmap"+bitmap);
                imageView.setImageBitmap(bitmap);
            }
            else {
                Toast.makeText(this, "拍照失败或没有没有拍照！", Toast.LENGTH_LONG).show();
            }
        }
    }
}
