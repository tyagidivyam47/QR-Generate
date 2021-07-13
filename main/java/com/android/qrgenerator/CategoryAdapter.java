package com.android.qrgenerator;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(FragmentManager fm){

        super(fm);

    }
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            Log.v("Adapter", "Inside the irubfuycavcawwVebcjhawvefvahdcjhaewvfwyevfhcjhh GET ITem");
            return new TextFragment();
        }
        else if(position == 1){
            return new UrlFragment();
        }
        else if(position == 2){
            return new PhoneFragment();
        }
        else if(position == 3){
            return new SMSFragment();
        }
        else if(position == 4){
            return new LocationFragment();
        }
        else if(position == 5){
            return new EmailFragment();
        }
        else if(position == 6){
            return new FBFragment();
        }
        else if(position == 7){
            return new TwitterFragment();
        }
        else if(position == 8){
            return new YTFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 9;
    }
}
