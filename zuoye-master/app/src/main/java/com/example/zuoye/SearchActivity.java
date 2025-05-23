package com.example.zuoye;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private EditText editQuery;
    private Button btnSearch;
    private ListView listView;
    private MySQLiteOpenHelper dbHelper;
    private List<SearchResult> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editQuery = findViewById(R.id.edit_query);
        btnSearch = findViewById(R.id.btn_search);
        listView = findViewById(R.id.list_result);
        dbHelper = new MySQLiteOpenHelper(this);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editQuery.getText().toString().trim();
                performSearch(query);
            }
        });
    }

    private void performSearch(String query) {
        results.clear();

        // 查询 goods 表
        Cursor cursorGoods = dbHelper.getReadableDatabase().rawQuery(
                "SELECT name, price, introduction FROM goods WHERE name LIKE ?", new String[]{"%" + query + "%"});
        while (cursorGoods.moveToNext()) {
            String name = cursorGoods.getString(0);
            String price = cursorGoods.getString(1);
            String intro = cursorGoods.getString(2);
            results.add(new SearchResult("商品", name, price, intro));
        }
        cursorGoods.close();

        // 查询 news 表
        Cursor cursorNews = dbHelper.getReadableDatabase().rawQuery(
                "SELECT title, context FROM news WHERE title LIKE ?", new String[]{"%" + query + "%"});
        while (cursorNews.moveToNext()) {
            String title = cursorNews.getString(0);
            String context = cursorNews.getString(1);
            results.add(new SearchResult("新闻", title, context, ""));
        }
        cursorNews.close();

        // 查询 score 表
        Cursor cursorScore = dbHelper.getReadableDatabase().rawQuery(
                "SELECT name, subject, score FROM score WHERE name LIKE ?", new String[]{"%" + query + "%"});
        while (cursorScore.moveToNext()) {
            String name = cursorScore.getString(0);
            String subject = cursorScore.getString(1);
            String score = cursorScore.getString(2);
            results.add(new SearchResult("成绩", name, subject, score));
        }
        cursorScore.close();

        showResults(results);
    }

    private void showResults(List<SearchResult> results) {
        List<Map<String, String>> data = new ArrayList<>();
        for (SearchResult item : results) {
            Map<String, String> map = new HashMap<>();
            map.put("type", item.getType());
            map.put("field1", item.getField1());
            map.put("field2", item.getField2());
            if (!item.getField3().isEmpty()) {
                map.put("field3", item.getField3());
            } else {
                map.put("field3", "");
            }
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                R.layout.search_result_item,
                new String[]{"type", "field1", "field2", "field3"},
                new int[]{R.id.text_type, R.id.text_field1, R.id.text_field2, R.id.text_field3});

        listView.setAdapter(adapter);
    }
}