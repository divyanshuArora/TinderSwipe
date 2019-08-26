package com.example.tinderswipe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MainActivity extends AppCompatActivity
{

    SwipePlaceHolderView swipePlaceHolderView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        swipePlaceHolderView = findViewById(R.id.swipeView);
        context =getApplicationContext();



        swipePlaceHolderView.getBuilder().setDisplayViewCount(3).setSwipeDecor(new SwipeDecor().setPaddingLeft(20)
                .setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.swipe_in_msg_view)
                .setSwipeOutMsgLayoutId(R.layout.swipte_out_msg_view));




        for(TinderModel profile : Utils.loadProfile(this.getApplicationContext())){
            swipePlaceHolderView.addView(new TinderCardAdapter(context, profile, swipePlaceHolderView));
        }

//        findViewById(R.id.).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(false);
//            }
//        });
//
//        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(true);
//            }
//        });



    }







}
