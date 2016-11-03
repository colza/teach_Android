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
                if(string.contains("hello")){
                    mActivityMainBinding.text.setText("我很好啦不用煩惱");
                }
                else
                {
                    mActivityMainBinding.text.setText(string);
                }

                mActivityMainBinding.editText.setText("");
            }
        });
    }
}
