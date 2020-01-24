package com.example.nestedrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<General> mlist=new ArrayList<>();
    private List<General> mchildlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mlist=new ArrayList<>();
        for(int i=0;i<200;i++){
            if(i%2==0){
                mlist.add(new General("Dhoni","keeper"));
            }
            else {
                mlist.add(new General("Kohli","batsman"));
            }
        }
        RecyclerView recyclerView=findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GeneralAdapter adapter=new GeneralAdapter(this,mlist);
        recyclerView.setAdapter(adapter);

        /* Child recycler view */

        for(int i=0;i<50;i++){
            mchildlist.add(new General(R.drawable.ic_launcher_background));
        }

        RecyclerView childRecyclerView=findViewById(R.id.child_rec);
        childRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChildAdapter childAdapter=new ChildAdapter(this,mchildlist);
        childRecyclerView.setAdapter(childAdapter);

    }
}
