package com.inspiron.tharun26.manusys;

/**
 * Created by tharun26 on 19/1/15.
 */
import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.inspiron.tharun26.manusys.adapter.ContactListAdapter;
import com.inspiron.tharun26.manusys.adapter.EventListAdapter;

import java.util.ArrayList;

import con.inspiron.tharun26.manusys.model.ContactItem;

public class ContactsFragment extends Fragment {


    private ListView contacts_list;
    private String[] contacts_title;
    private TypedArray contact_icons;
    private ArrayList<ContactItem> contact_Items;
    private ContactListAdapter adapter;

    public ContactsFragment(){}



    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);



        contacts_title = getResources().getStringArray(R.array.designation);

        // nav drawer icons from resources
        contact_icons = getResources()
                .obtainTypedArray(R.array.contact_images);


        // mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        contact_Items = new ArrayList<ContactItem>();


        contact_Items.add(new ContactItem(contacts_title[0],contacts_title[0],contacts_title[0],contact_icons.getResourceId(0,-1),contact_icons.getResourceId(0,-1)));
        contact_Items.add(new ContactItem(contacts_title[0],contacts_title[0],contacts_title[0],contact_icons.getResourceId(0,-1),contact_icons.getResourceId(0,-1)));
        contact_Items.add(new ContactItem(contacts_title[0],contacts_title[0],contacts_title[0],contact_icons.getResourceId(0,-1),contact_icons.getResourceId(0,-1)));
        contact_Items.add(new ContactItem(contacts_title[0],contacts_title[0],contacts_title[0],contact_icons.getResourceId(0,-1),contact_icons.getResourceId(0,-1)));
        contact_Items.add(new ContactItem(contacts_title[0],contacts_title[0],contacts_title[0],contact_icons.getResourceId(0,-1),contact_icons.getResourceId(0,-1)));



        /*
        // adding nav drawer items to array
        // Home
        event_Items.add(new EventItem(event_titles[0], event_icons.getResourceId(0, -1)));
        // Find People
        event_Items.add(new EventItem(event_titles[1], event_icons.getResourceId(1, -1)));
        // Photos
        event_Items.add(new EventItem(event_titles[2],  event_icons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        event_Items.add(new EventItem(event_titles[3],  event_icons.getResourceId(3, -1)));
        // Pages
        event_Items.add(new EventItem(event_titles[4],  event_icons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
      /*
        event_Items.add(new EventItem(event_titles[5],  event_icons.getResourceId(5, -1)));

        event_Items.add(new  EventItem(event_titles[6],  event_icons.getResourceId(6, -1)));

        event_Items.add(new EventItem(event_titles[7],  event_icons.getResourceId(7, -1)));
    */



        // Recycle the typed array
        contact_icons.recycle();

        // setting the nav drawer list adapter

        adapter = new ContactListAdapter(getActivity(),contact_Items);
       contacts_list= (ListView) getActivity().findViewById(R.id.list);
        contacts_list.setAdapter(adapter);

        /*adapter = new ContactListAdapter(getActivity(),contact_Items);
        setListAdapter(adapter);
        */




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragments_contacts, container, false);

        return rootView;
    }
}