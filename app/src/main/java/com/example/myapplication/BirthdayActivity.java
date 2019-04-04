package com.example.myapplication;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BirthdayActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        models =new ArrayList<>();
        description = new ArrayList<>();
        description.add("I like to play with my friends at school.");
        description.add("Sometimes my friends wll invite me to go to a party for their birthday.");
        description.add("The party could be at a house, or a play center, or somewhere else.");
        description.add("When i arrive at the birthday party. I usaully give my friend a present.");
        description.add("Then I will say \"Happy Birthday\" to my friend.");
        description.add("At the party, there will be other children and Mums and Dads");
        description.add("Sometimes there will be games to play.We might play pass the parcel.");
        description.add("we might play musical chairs, or something else.");
        description.add("When its time to eat, we will usually sit together at the table.");
        description.add("Then we can have something to eat.There will be lots of different food to choose from.");
        description.add("After we have eaten, its usually time to sing Happy Birthday. Then my friend will blow out the candles of the cake.");
        description.add("When the party is finished, my friend may give me a ballon, or a gift bag or something else to take home.");
        description.add("Then it will be time to say \"goodbye\".");
        description.add("It is a good to say thank you to my friend for asking me to the party.");
        description.add("Birthday Parties are a lot of fun.");

        Integer[] imgId={R.drawable.bd1,R.drawable.bd2,R.drawable.bd3,R.drawable.bd4,
                R.drawable.bd5,R.drawable.bd6,R.drawable.bd7,R.drawable.bd8,R.drawable.bd9,R.drawable.bd10,R.drawable.bd11,
                R.drawable.bd12,R.drawable.bd13,R.drawable.bd14,R.drawable.bd15};
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
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),getResources().getColor(R.color.color1),
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
