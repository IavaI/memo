package com.example.contact.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contact.R;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);

        Button backButton = findViewById(R.id.button_back);
        Button confirmButton = findViewById(R.id.button_confirm_modify);

        if (confirmButton != null) {
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 创建意图返回 MainActivity
                    Intent intent = new Intent(ChangePasswordActivity.this, ManageActivity.class);
                    startActivity(intent);
                    finish(); // 结束当前活动（RegisterActivity）
                }
            });
        }

        if (backButton != null) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 创建意图返回 MainActivity
                    Intent intent = new Intent(ChangePasswordActivity.this, ManageActivity.class);
                    startActivity(intent);
                    finish(); // 结束当前活动（RegisterActivity）
                }
            });
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.change_pwd), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}