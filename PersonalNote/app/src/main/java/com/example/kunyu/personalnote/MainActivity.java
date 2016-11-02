package com.example.kunyu.personalnote;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kunyu.personalnote.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding mActivityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                mActivityMainBinding.noteItem.text1.setText(formattedDate);
                mActivityMainBinding.noteItem.text2.setText(mActivityMainBinding.button1.getText());
                String string = mActivityMainBinding.editText.getText().toString();
                mActivityMainBinding.noteItem.text3.setText(string);
            }
        });

        mActivityMainBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mActivityMainBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}

