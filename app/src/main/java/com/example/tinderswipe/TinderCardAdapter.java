package com.example.tinderswipe;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
@Layout(R.layout.tinder_card_item)
public class TinderCardAdapter {

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    private TinderModel tinderModel;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;


    public  TinderCardAdapter(Context context,TinderModel tinderModel1,SwipePlaceHolderView swipePlaceHolderView)
    {
        mContext = context;
        tinderModel = tinderModel1;
        mSwipeView = swipePlaceHolderView;
    }



    @Resolve
    private void onResolved(){
        Glide.with(mContext).load(tinderModel.getUrl()).error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background).into(profileImageView);
        nameAgeTxt.setText(tinderModel.getName() + ", " + tinderModel.getAge());
        locationNameTxt.setText(tinderModel.getLocation());
    }


    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }



    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }


}
