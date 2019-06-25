package com.wiselteach.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiselteach.recyclerviewdemo.utils.Cheeses;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //recyclerView.addItemDecoration(new LeftDividerItemDecorator(this));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);

                ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                layoutParams.height = (int) (getResources().getDisplayMetrics().scaledDensity * 56);
                inflate.setLayoutParams(layoutParams);

                return new RecyclerViewViewHolder(inflate);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                ((TextView) viewHolder.itemView.findViewById(android.R.id.text1)).setText(Cheeses.CHEESES[i]);
            }

            @Override
            public int getItemCount() {
                return Cheeses.CHEESES.length;
            }
        });
    }

    private class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
