package com.example.kunyu.inputoutput;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kunyu.inputoutput.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mActivityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = mActivityMainBinding.editText.getText().toString();
//                if(string.equals("你好麼")){
//                    mActivityMainBinding.text.setText("我很好啦吃大便啦");
//                }
//                else if(string.contains("搞屁"))
//                {
//                    mActivityMainBinding.text.setText("可以不要罵髒話麼");
//                }
//                else
//                {
//                    mActivityMainBinding.text.setText(string);
//                }
                mActivityMainBinding.text.append("\n" + string);
                mActivityMainBinding.editText.setText("");
            }
        });
    }
}
