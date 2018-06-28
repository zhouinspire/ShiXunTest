package dialog;

import android.app.Dialog;

import android.content.Context;

import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import com.example.shixuntest.R;


public class MyDialog extends Dialog{

    private Context mcontext;

    public MyDialog(Context context)
    {
        super(context);
        setContentView(R.layout.mydialog);
        Button button = (Button) findViewById(R.id.mydialog_btn);
        //存储上下文
        mcontext = context;
        //在自定义dialog
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "doooo",Toast.LENGTH_SHORT).show();
                //关闭dialog
                dismiss();
            }
        });
    }

}
