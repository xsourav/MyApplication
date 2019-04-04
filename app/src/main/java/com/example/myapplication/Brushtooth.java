package com.example.myapplication;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Brushtooth extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brushtooth);

        models =new ArrayList<>();
        description = new ArrayList<>();
        description.add("Get your toothbrush wet");
        description.add("Put a little bit of toothpaste on your toothbrush");
        description.add("Brush your teeth where the teeth and gums come together.Brush each tooth front and back.");
        description.add(" Keep brushing your teeth for two minutes. An adult can keep a timer for you.");
        description.add("Spit the toothpaste in the sink.Then rinse your mouth with water.");
        description.add("Rinse all the toothpaste off your toothbrush and put it away.");

        Integer[] imgId={R.drawable.bt1,R.drawable.bt2,R.drawable.bt3,R.drawable.bt4,R.drawable.bt5,R.drawable.bt6};
        for (int i=0;i<imgId.length;i++){
            models.add(new Model(imgId[i],"",description.get(i)));
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
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color4)
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
