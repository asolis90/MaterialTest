package com.materialtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.materialtest.MainActivity;
import com.materialtest.R;

/**
 * Created by angel on 8/25/2015.
 */
public class FragmentPage3 extends Fragment {

    View view;
    AppCompatActivity act;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_page3, container,
                false);
        act = MainActivity.act;
        return view;
    }
}
