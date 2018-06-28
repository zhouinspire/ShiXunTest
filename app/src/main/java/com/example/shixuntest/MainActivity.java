package com.example.shixuntest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.FruitAdapter;
import bean.Fruit;
import dialog.MyDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Fruit> fruitList = new ArrayList<>();

    private ProgressDialog progressDialog;

//    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    //自定义dialog
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_test);

        //dialog 练习
/*        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        initMyDialog();
        initProgressDialog();
        initAlertDialog();*/


        //触摸练习
/*

        TextView textViewBottom = (TextView) findViewById(R.id.text_bottom);
        textViewBottom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Log.d("touch:", "onTouch: textViewBottom");
                return false;
            }
        });

        TextView textViewMiddle = (TextView) findViewById(R.id.text_Middle);

        textViewMiddle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("touch:", "onTouch: middle");
                return false;
            }
        });

        TextView textViewTop = (TextView) findViewById(R.id.text_Top);

        textViewTop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("touch:", "onTouch: top");
                return false;
            }
        });
*/

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button1:
            progressDialog.show();
            break;

            case R.id.button2:
            builder.show();
            break;

            case R.id.button3:
            myDialog.show();
            break;
        }
    }
    /**
     * 初始化ProgressDialog
     */
    private void initProgressDialog() {
        // 实例化ProgressDialog对象
        progressDialog = new ProgressDialog(this);
        // 设置标题
        progressDialog.setTitle("ProgressDialog");
        // 设置显示信息
        progressDialog.setMessage("这是一个用于显示等待的控件，可以让用户知道程序正在加载中，而不是卡死了。");
        // 设置图标
        progressDialog.setIcon(R.mipmap.ic_launcher);
    }


    /**
     * 初始化AlertDialog
     */
    private void initAlertDialog() {
        // 实例化静态内部类，参数为上下文
        builder = new AlertDialog.Builder(this);
        // 设置标题
        builder.setTitle("AlertDialog");
        // 设置显示信息
        builder.setMessage("这个控件是ProgressDialog的父类，是Dialog的子类，通常用于正常的标准化Dialog显示.");
        // 设置图标
        builder.setIcon(R.mipmap.ic_launcher);
        // 设置取消的Button
        // 第一个参数：按钮上要显示的文字
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置确定的按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private  void  initMyDialog(){
        myDialog = new MyDialog(this);

    }



    private void initFruits(){
        for (int i = 0;i < 2;i++)
        {
            Fruit apple = new Fruit("apple");
            fruitList.add(apple);
            Fruit orange = new Fruit("orange");
            fruitList.add(orange);
            Fruit banana = new Fruit("banana");
            fruitList.add(banana);
            Fruit strawberry = new Fruit("strawberry");
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("watermelon");
            fruitList.add(watermelon);
            Fruit mango = new Fruit("mango");
            fruitList.add(mango);
            Fruit pear = new Fruit("pear");
            fruitList.add(pear);
            Fruit grape = new Fruit("grape");
            fruitList.add(grape);
            Fruit cherry = new Fruit("cherry");
            fruitList.add(cherry);
        }
    }
}
