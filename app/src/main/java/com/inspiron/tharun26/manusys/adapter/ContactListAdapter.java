package com.inspiron.tharun26.manusys.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inspiron.tharun26.manusys.Contact;
import com.inspiron.tharun26.manusys.R;
import com.inspiron.tharun26.manusys.ContactsFragment;

import java.util.ArrayList;
import java.util.Random;

import con.inspiron.tharun26.manusys.model.ContactItem;

/**
 * Created by tharun26 on 20/1/15.
 */
public class ContactListAdapter extends BaseAdapter{


    private Context context;
    private ArrayList<ContactItem> contactItems;

    private Random mRandomizer = new Random();

    public ContactListAdapter(Context context, ArrayList<ContactItem> contactItems) {
        this.context = context;
        this.contactItems = contactItems;
    }



    @Override
    public int getCount() {
        return contactItems.size();
    }

    @Override
    public Object getItem(int position) {
        return contactItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.contact_item_color_orange, null);
            /*
          if(position==0||position>3) {
               LayoutInflater mInflater = (LayoutInflater)
                       context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
               convertView = mInflater.inflate(R.layout.contact_item_color_orange, null);
           }
            else if(position==1)
           {
               LayoutInflater mInflater = (LayoutInflater)
                       context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
               convertView = mInflater.inflate(R.layout.contact_item_color_blue, null);
           }
           else if(position==2)
           {
               LayoutInflater mInflater = (LayoutInflater)
                       context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
               convertView = mInflater.inflate(R.layout.contact_item_color_red, null);
           }
           else if(position==3)
           {
               LayoutInflater mInflater = (LayoutInflater)
                       context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
               convertView = mInflater.inflate(R.layout.contact_item_color_yellow, null);
           }
         */


        }


        TextView title = (TextView) convertView.findViewById(R.id.designation_name);
        TextView contact1 = (TextView) convertView.findViewById(R.id.contact1);
        TextView contact2 = (TextView) convertView.findViewById(R.id.contact2);

        ImageView contact1_img = (ImageView) convertView.findViewById(R.id.img1_Btn);
        ImageView contact2_img = (ImageView) convertView.findViewById(R.id.img2_Btn);

        contact2_img.setImageResource(contactItems.get(position).getIcon1());
        contact1_img.setImageResource(contactItems.get(position).getIcon2());
        title.setText(contactItems.get(position).getDesignation());
        contact1.setText(contactItems.get(position).getDesignation());
        contact2.setText(contactItems.get(position).getDesignation());



          contact1_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:8056097997"));
                context.startActivity(callIntent);


                Toast.makeText(context, "Image1 from row " + position + " was pressed", Toast.LENGTH_LONG).show();

            }
        });

        contact2_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:8056097997"));
                context.startActivity(callIntent);

                Toast.makeText(context, "Image2 from row " + position + " was pressed", Toast.LENGTH_LONG).show();
            }
        });


        if(position%2==0) {
            Animation animationX = new TranslateAnimation(parent.getWidth() / 8, 0, 0, 0);

            animationX.setDuration(500);
            convertView.startAnimation(animationX);
            animationX = null;
        }

        else {
            Animation animationX = new TranslateAnimation(-parent.getHeight() / 8, 0, 0, 0);

            animationX.setDuration(500);
            convertView.startAnimation(animationX);
            animationX = null;

        }






        return convertView;

       // return null;
    }
}
