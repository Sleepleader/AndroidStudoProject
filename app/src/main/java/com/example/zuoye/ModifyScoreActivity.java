package com.example.zuoye;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zuoye.MySQLiteOpenHelper;

public class ModifyScoreActivity extends AppCompatActivity {

    private EditText etName, etSubject, etNewScore;
    private MySQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_score);

        etName = findViewById(R.id.et_name);
        etSubject = findViewById(R.id.et_subject);
        etNewScore = findViewById(R.id.et_new_score);
        Button btnUpdate = findViewById(R.id.btn_update_score);
        dbHelper = new MySQLiteOpenHelper(this);

        btnUpdate.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String subject = etSubject.getText().toString().trim();
            String scoreStr = etNewScore.getText().toString().trim();

            if (name.isEmpty() || subject.isEmpty() || scoreStr.isEmpty()) {
                Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                return;
            }

            int newScore = Integer.parseInt(scoreStr);
            int rows = dbHelper.updateScore(name, subject, newScore);

            if (rows > 0) {
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "未找到对应成绩记录", Toast.LENGTH_SHORT).show();
            }
        });
    }
}