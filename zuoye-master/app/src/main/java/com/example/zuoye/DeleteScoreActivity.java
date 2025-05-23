package com.example.zuoye;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class DeleteScoreActivity extends AppCompatActivity {

    private EditText etName, etSubject;
    private MySQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_score);

        etName = findViewById(R.id.et_name);
        etSubject = findViewById(R.id.et_subject);
        Button btnDelete = findViewById(R.id.btn_delete_score);
        dbHelper = new MySQLiteOpenHelper(this);

        btnDelete.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String subject = etSubject.getText().toString().trim();

            if (name.isEmpty() || subject.isEmpty()) {
                Toast.makeText(this, "请输入姓名和科目", Toast.LENGTH_SHORT).show();
                return;
            }

            int rows = dbHelper.deleteScore(name, subject);

            if (rows > 0) {
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "未找到对应成绩记录", Toast.LENGTH_SHORT).show();
            }
        });
    }
}