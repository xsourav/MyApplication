package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialStoryCategory extends AppCompatActivity {
    ArrayList<String> als;
    ArrayAdapter<String> adapter;
    ListView listView;
    TextView categoryText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_story_category);
        categoryText=findViewById(R.id.categoryText1);
        als=new ArrayList<>();
        als.add("Birthday Celebration");
        als.add("School");
        als.add("Brushing Tooth");
        als.add("PLay With Friends");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,als);
        listView=findViewById(R.id.socialStoryListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(SocialStoryCategory.this,BirthdayActivity.class));
                }
                else if(position==1){
                    startActivity(new Intent(SocialStoryCategory.this,MainActivity.class));
                }
                else if(position==2){
                    startActivity(new Intent(SocialStoryCategory.this,Brushtooth.class));
                }
                else if(position==3){
                    startActivity(new Intent(SocialStoryCategory.this,PlayFriendsActivity.class));
                }
            }
        });

    }
}
