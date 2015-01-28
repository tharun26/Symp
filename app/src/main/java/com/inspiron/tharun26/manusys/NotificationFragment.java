package com.inspiron.tharun26.manusys;

/**
 * Created by tharun26 on 26/1/15.
 */



        import android.app.Fragment;
        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;

        import com.inspiron.tharun26.manusys.adapter.NotificationListAdapter;

        import java.util.ArrayList;
        import java.util.List;

        import con.inspiron.tharun26.manusys.model.NotificationItem;

public class NotificationFragment extends Fragment {




    private ListView notification_list;
    public static String[] notification_title=new String[50] ;
    private TypedArray notification_icons;
    private  ArrayList<NotificationItem> notification_Items;
    private NotificationListAdapter notification_adapter;

    public NotificationFragment(){}

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        notification_title = getResources().getStringArray(R.array.designation);

        notification_Items = new ArrayList<NotificationItem>();

        DatabaseHandler db = new DatabaseHandler(getActivity());
        //Log.d("Insert: ", "Inserting ..");
        //db.addNotification(new NotificationDb(newMessage));
        Log.d("Reading: ", "Notification Reading all contacts..");
        List<NotificationDb> notificationDbs = db.getAllContacts();

        int x=0;
        for (NotificationDb cn : notificationDbs) {
            //      db.deleteContact(cn);
           notification_title[x++]=cn.getNotification();
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getNotification()  ;
            //  Writing Contacts to log
            Log.d("Name: ", log+"**"+x);

        }




        int i;
        for(i=0;i<x;i++) {
            notification_Items.add(new NotificationItem(notification_title[i]));
           // notification_Items.add(new NotificationItem("Welcome to Manusys!!"));
        }



        notification_adapter = new NotificationListAdapter(getActivity(),notification_Items);
        notification_list= (ListView) getActivity().findViewById(R.id.list_notification);
        notification_list.setAdapter(notification_adapter);

    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        return rootView;
    }
}
