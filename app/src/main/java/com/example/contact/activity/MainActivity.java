package com.example.contact.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contact.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button registerButton = findViewById(R.id.button_register);  // 确保这是在setContentView之后调用

        // 设置点击事件监听器
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 创建意图启动 RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}