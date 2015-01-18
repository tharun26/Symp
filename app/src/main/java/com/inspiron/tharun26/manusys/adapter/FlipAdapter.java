package com.inspiron.tharun26.manusys.adapter;

/**
 * Created by tharun26 on 18/1/15.
 */
import java.util.ArrayList;
import java.util.List;
import com.inspiron.tharun26.manusys.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import con.inspiron.tharun26.manusys.model.EventInformation;

public class FlipAdapter extends BaseAdapter implements OnClickListener {

    public interface Callback{
        public void onPageRequested(int page);
    }

   /* static class Item {
        static long id = 0;

        long mId;

        public Item() {
            mId = id++;
        }

        long getId(){
            return mId;
        }
    }*/

    private LayoutInflater inflater;
    private Callback callback;
    private List<EventInformation> eventInformation ;
    private Context context;

    public FlipAdapter(Context context,ArrayList<EventInformation> eventInformation) {

        this.context=context;
        this.eventInformation=eventInformation;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return eventInformation.size();
    }

    @Override
    public Object getItem(int position) {
        return eventInformation.get(position);
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.page_event_1, null);
        }
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.text_event_1);
            txtTitle.setText(eventInformation.get(position).getEvent_info_title());
            imgIcon.setImageResource(eventInformation.get(position).getIcon());


        return convertView;

       /*
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.page_event_1, parent, false);

            holder.text = (TextView) convertView.findViewById(R.id.text_event_1);
            holder.firstPage = (Button) convertView.findViewById(R.id.first_page_event_1);
            holder.lastPage = (Button) convertView.findViewById(R.id.last_page_event_1);

            holder.firstPage.setOnClickListener(this);
            holder.lastPage.setOnClickListener(this);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //TODO set a text with the id as well
        holder.text.setText(items.get(position).getId()+":"+position);

        return convertView;
        */

    }

    static class ViewHolder{
        TextView text;
        Button firstPage;
        Button lastPage;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.first_page_event_1:
                if(callback != null){
                    callback.onPageRequested(0);
                }
                break;
            case R.id.last_page_event_1:
                if(callback != null){
                    callback.onPageRequested(getCount()-1);
                }
                break;
        }
    }

    /*
    public void addItems(int amount) {
        for(int i = 0 ; i<amount ; i++){
            items.add(new Item());
        }
        notifyDataSetChanged();
    }

    public void addItemsBefore(int amount) {
        for(int i = 0 ; i<amount ; i++){
            items.add(0, new Item());
        }
        notifyDataSetChanged();
    }
    */

}