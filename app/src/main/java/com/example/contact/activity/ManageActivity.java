package com.example.contact.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.contact.R;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;

public class ManageActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        // 设置Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.manage);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // 设置ActionBarDrawerToggle，以实现汉堡图标与抽屉的同步
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // 设置NavigationView点击监听器
        navigationView.setNavigationItemSelectedListener(item -> {
            String itemId = item.getTitle().toString();
            switch (itemId) {
                case "个人信息":
                    // 处理个人信息
                    break;
                case "修改密码":
                    // 跳转到修改密码界面
                    Intent intent = new Intent(ManageActivity.this, ChangePasswordActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                case "没想好啥功能":
                    // 处理没想好啥功能
                    break;
                case "注销":
                    // 处理注销
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
