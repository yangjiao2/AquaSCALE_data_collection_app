package com.example.yujingxie.addmap2;

/**
 * Created by Yang on 2016/6/3.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ReportViewHolder> {

    public static class ReportViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView Name;
        TextView Location;
        TextView Time;

        ReportViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            Name = (TextView)itemView.findViewById(R.id.name);
            Location = (TextView)itemView.findViewById(R.id.location);
            Time = (TextView)itemView.findViewById(R.id.timeText);
        }
    }

    List<Report> reports;

    RVAdapter(List<Report> reports){
        this.reports = reports;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ReportViewHolder pvh = new ReportViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ReportViewHolder reportViewHolder, int i) {
        reportViewHolder.Name.setText(reports.get(i).Name);
        reportViewHolder.Location.setText(reports.get(i).Location);
        reportViewHolder.Time.setText(reports.get(i).Time);
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }
}