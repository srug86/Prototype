package com.example.ulabsrg.prototype.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ulabsrg.prototype.R;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class FragmentRecord extends Fragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_record, container, true);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs,
                          Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        System.out.println("onInflate");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("onViewCreated");
    }
}
