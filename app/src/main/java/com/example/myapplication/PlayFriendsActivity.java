package com.example.myapplication;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlayFriendsActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_friends);

        models =new ArrayList<>();
        description =new ArrayList<>();
        description.add("we might play different kind of games.");
        description.add("Sometines i see my friends playing , I want to play tool");
        description.add("If i want to join in my friends game I need to smile and use my words for asking.");
        description.add("I can say \"Hello! What are u doing ?\".");
        description.add("I can say \"can i play too?\"");
        description.add("Then my friends might invite me to play their game.");
        description.add("Sometimes, even when I use my words, my friends say \"No\".This is ok.");
        description.add("If my friends say \"No\", I can find something else to do.");
        description.add("I can play on my own or ask someone else to  play.");
        description.add("When I use my words and ask my friends to play. I feel really happy, and my friends do too.");
        description.add("It's great to play with my friends at school.");

        Integer[] imgId={R.drawable.pg1,R.drawable.pg2,R.drawable.pg3,R.drawable.pg4,
                R.drawable.pg6,R.drawable.pg7,R.drawable.pg8,R.drawable.pg9,
                R.drawable.pg10,R.drawable.pg11,R.drawable.pg12,R.drawable.pg13};
        for (int i=0;i<imgId.length;i++){
            models.add(new Model(imgId[i],"",""));
        }
//        models.add(new Model(R.drawable.birthday, "Brochure", "qqqqqqqqqqqqq"));
//        models.add(new Model(R.drawable.friends, "Sticker", "qqqqqqqqqqqq"));
//        models.add(new Model(R.drawable.school1, "Poster", "qqqqqqqq"));
//        models.add(new Model(R.drawable.toothbrush, "Namecard", "qqqqqqqqqq"));

        adapter = new Adapter(models,this);
        viewPager= findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),

        };

        colors =colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,
                            colors[position],colors[position +1]));
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
