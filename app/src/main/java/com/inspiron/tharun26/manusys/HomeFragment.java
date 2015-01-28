package com.inspiron.tharun26.manusys;

/**
 * Created by tharun26 on 17/1/15.
 */




import com.flaviofaria.kenburnsview.KenBurnsView;
import android.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;
import com.flaviofaria.kenburnsview.Transition;

import static com.flaviofaria.kenburnsview.KenBurnsView.TransitionListener;

public class HomeFragment extends Fragment implements TransitionListener {


    private static final int TRANSITIONS_TO_SWITCH = 1;

    private ViewFlipper mViewSwitcher;

    private int mTransitionsCount = 0;


    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
/*
        mViewSwitcher = (ViewSwitcher) getActivity().findViewById(R.id.viewSwitcher);

        KenBurnsView img1 = (KenBurnsView) getActivity(). findViewById(R.id.img1);
         img1.setTransitionListener(this);

        KenBurnsView img2 = (KenBurnsView) getActivity(). findViewById(R.id.img2);
        img2.setTransitionListener(this);
*/



        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        //TextView tv = (TextView)getActivity().findViewById(R.id.mywidget);
       // tv.setSelected(true);
        mViewSwitcher = (ViewFlipper) getActivity().findViewById(R.id.viewSwitcher);

        KenBurnsView img1 = (KenBurnsView) getActivity(). findViewById(R.id.img1);
        img1.setTransitionListener(this);

        KenBurnsView img2 = (KenBurnsView) getActivity(). findViewById(R.id.img2);
        img2.setTransitionListener(this);

        KenBurnsView img3 = (KenBurnsView) getActivity(). findViewById(R.id.img3);
        img3.setTransitionListener(this);

        KenBurnsView img4 = (KenBurnsView) getActivity(). findViewById(R.id.img4);
        img4.setTransitionListener(this);





    }

    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        mTransitionsCount++;
        if (mTransitionsCount == TRANSITIONS_TO_SWITCH) {
            mViewSwitcher.showNext();
            mTransitionsCount = 0;
        }

    }
}
