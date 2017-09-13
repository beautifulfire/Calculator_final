package com.example.hello.application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

/**
 * Created by 龙阳 on 2017/9/10.
 */

public class decimal_conversion extends AppCompatActivity {
    private Button bt49;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decimal_conversion);
        bt49 = (Button) findViewById(R.id.button49);
        // 响应按钮btn事件
        bt49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
