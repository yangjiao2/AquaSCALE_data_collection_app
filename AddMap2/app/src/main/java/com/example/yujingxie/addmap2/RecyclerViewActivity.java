package com.example.yujingxie.addmap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Report> reports;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        reports = new ArrayList<>();
        reports.add(new Report("DBH", "Front Door","3:33AM"));
        reports.add(new Report("Langson", "Restroom", "15:20PM"));
        reports.add(new Report("MSTB", "2 floor", "2:10PM"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(reports);
        rv.setAdapter(adapter);
    }
}
