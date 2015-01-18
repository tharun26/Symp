package com.inspiron.tharun26.manusys;


import com.inspiron.tharun26.manusys.adapter.FlipAdapter;
import com.inspiron.tharun26.manusys.adapter.FlipAdapter.Callback;

import con.inspiron.tharun26.manusys.model.EventInformation;
import se.emilsjolander.flipview.FlipView;
import se.emilsjolander.flipview.FlipView.OnFlipListener;
import se.emilsjolander.flipview.FlipView.OnOverFlipListener;
import se.emilsjolander.flipview.OverFlipMode;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class Event1Activity extends Activity  implements Callback, OnFlipListener, OnOverFlipListener {


    private FlipView mFlipView;
    private FlipAdapter mAdapter;

    private String[] event_titles;
    private TypedArray event_icons;
    private ArrayList<EventInformation> eventInformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        event_titles = getResources().getStringArray(R.array.events_info);
        event_icons = getResources().obtainTypedArray(R.array.events_info_images);

        eventInformations = new ArrayList<EventInformation>();

        eventInformations.add(new EventInformation(event_titles[0], event_icons.getResourceId(0, -1)));
        eventInformations.add(new EventInformation(event_titles[1], event_icons.getResourceId(1, -1)));
        eventInformations.add(new EventInformation(event_titles[2], event_icons.getResourceId(2, -1)));
        eventInformations.add(new EventInformation(event_titles[3], event_icons.getResourceId(3, -1)));
        eventInformations.add(new EventInformation(event_titles[4], event_icons.getResourceId(4, -1)));

       // Log.i("DEbug"," "+event_titles[0]+event_titles[1]+event_titles[2]+event_titles[3]+event_titles[4]);
        event_icons.recycle();

        mFlipView = (FlipView) findViewById(R.id.flip_view);
        mAdapter = new FlipAdapter(this,eventInformations);
        mAdapter.setCallback(this);
        mFlipView.setAdapter(mAdapter);

        mFlipView.setOnFlipListener(this);
        mFlipView.peakNext(false);
        mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
        mFlipView.setEmptyView(findViewById(R.id.empty_view));
        mFlipView.setOnOverFlipListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageRequested(int page) {
        mFlipView.smoothFlipTo(page);
    }

    @Override
    public void onFlippedToPage(FlipView flipView, int position, long l) {

        Log.i("pageflip", "Page: " + position);
        if (position>0) {

            mFlipView.peakPrevious(false);
            //  mAdapter.addItems(5);


       /* @Override
        public void onOverFlip(FlipView v,OverFlipMode mode, boolean overFlippingPrevious, float overFlipDistance,float flipDistancePerPage)
        {
            Log.i("overflip", "overFlipDistance = " + overFlipDistance);
        }
        */
        }
    }

    @Override
    public void onOverFlip(FlipView flipView, OverFlipMode overFlipMode, boolean b, float v, float v2) {

        Log.i("overflip", "overFlipDistance = "+v);
    }
}