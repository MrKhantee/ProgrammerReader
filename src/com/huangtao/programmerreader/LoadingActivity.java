package com.huangtao.programmerreader;

import java.util.List;

import com.huangtao.programmerreader.domain.ArticleItem;
import com.huangtao.programmerreader.service.ArticleService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class LoadingActivity extends Activity {

    private SlideShowView slideShowView;

    private ListView articleListView;

    ArticleService articleService;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_loading);

        articleListView = (ListView) this.findViewById(R.id.articleList);

        articleService = ArticleService.getInstance(this);

        List<ArticleItem> articleItems = articleService.getAllItem();

        articleListView.setAdapter(new ArticleListAdapter(this, articleItems));

        articleListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.putExtra("url", "http://www.baidu.com");
                intent.setClass(LoadingActivity.this, WebViewActivity.class);
                startActivity(intent);
            }

        });
    }
}
