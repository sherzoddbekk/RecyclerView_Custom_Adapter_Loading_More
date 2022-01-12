package com.example.recyclerviewcustomadapterloadingmore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerviewcustomadapterloadingmore.CustomAdapter.CustomAdapter;
import com.example.recyclerviewcustomadapterloadingmore.R;
import com.example.recyclerviewcustomadapterloadingmore.listener.OnButtomReachedListener;
import com.example.recyclerviewcustomadapterloadingmore.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        List<Member> members = prepareMemberList();
        reflashAdapter(members);
    }
    void initView(){

        recyclerView = findViewById(R.id.recyclerViewMean);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void reflashAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context, members, new OnButtomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                Log.d("@@@", "onBottomReached: " + position);
                Toast.makeText(MainActivity.this, "Reached to the BOTTOM", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList(){

        List<Member> members = new ArrayList<>();
        members.add(new Member());
        for (int i = 0; i < 40; i++) {
            if (i == 0 || i == 5 || i== 16 || i ==25 || i == 30){
                members.add(new Member("Sherzod" + i, "Jurabekov" + i,false));
            }else{
                members.add(new Member("Sherzod" + i,"Jurabekov" +i,true));
            }
        }
        members.add(new Member());
        return members;

    }
}