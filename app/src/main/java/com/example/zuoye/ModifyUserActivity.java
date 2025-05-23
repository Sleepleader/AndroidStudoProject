package com.example.zuoye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyUserActivity extends AppCompatActivity {

    private EditText etOldZhanghao, etNewZhanghao, etNewMima;
    private Button btnModify;
    private MySQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);

        etOldZhanghao = findViewById(R.id.et_old_zhanghao);
        etNewZhanghao = findViewById(R.id.et_new_zhanghao);
        etNewMima = findViewById(R.id.et_new_mima);
        btnModify = findViewById(R.id.btn_modify_user);
        dbHelper = new MySQLiteOpenHelper(this);
        Button btnDelete = findViewById(R.id.btn_delete_user);

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldZhanghao = etOldZhanghao.getText().toString().trim();
                String newZhanghao = etNewZhanghao.getText().toString().trim();
                String newMima = etNewMima.getText().toString().trim();

                if (oldZhanghao.isEmpty() || newZhanghao.isEmpty() || newMima.isEmpty()) {
                    Toast.makeText(ModifyUserActivity.this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean success = dbHelper.updateUserInfo(oldZhanghao, newZhanghao, newMima);
                if (success) {
                    Toast.makeText(ModifyUserActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    finish(); // 返回上一页
                } else {
                    Toast.makeText(ModifyUserActivity.this, "修改失败，请检查原账号是否存在", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 删除用户逻辑
        btnDelete.setOnClickListener(v -> {
            String oldZhanghao = etOldZhanghao.getText().toString().trim();

            if (oldZhanghao.isEmpty()) {
                Toast.makeText(ModifyUserActivity.this, "请输入要删除的账号名", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean success = dbHelper.deleteUserInfo(oldZhanghao);
            if (success) {
                Toast.makeText(ModifyUserActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                finish(); // 删除后返回上一页
            } else {
                Toast.makeText(ModifyUserActivity.this, "删除失败，账号不存在", Toast.LENGTH_SHORT).show();
            }
        });

    }
}