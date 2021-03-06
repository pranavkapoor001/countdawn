package com.app.pk.HelFit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int watertrack_num;

    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        final Button waterinc = rootView.findViewById(R.id.waterinc);
        final Button waterdec = rootView.findViewById(R.id.waterdec);
        final TextView watertrack =  rootView.findViewById(R.id.watertrack);

        waterinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watertrack_num ++;
                watertrack.setText(String.valueOf(watertrack_num));
            }
        });
        waterdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(watertrack_num>0) {
                    watertrack_num--;
                    watertrack.setText(String.valueOf(watertrack_num));
                }
            }
        });

        /* Link walks cardview to 'step' tracker frag */
        CardView walkCardView = rootView.findViewById(R.id.walkCardview);
        walkCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewpager = getActivity().findViewById(R.id.pager);
                viewpager.setCurrentItem(2);
            }
        });

        /* Link profile cardview to 'profile' frag */
        CardView profileCardview = rootView.findViewById(R.id.profileCardview);
        profileCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewpager = getActivity().findViewById(R.id.pager);
                viewpager.setCurrentItem(0);
            }
        });

        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
