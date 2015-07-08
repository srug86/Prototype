package com.example.ulabsrg.prototype.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ulabsrg.prototype.R;
import com.example.ulabsrg.prototype.adapter.AdapterDrawer;
import com.example.ulabsrg.prototype.domain.session.Session;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class FragmentDrawer extends Fragment {

    private RecyclerView mRecyclerDrawer;
    private AdapterDrawer mAdapter;

    public FragmentDrawer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mRecyclerDrawer = (RecyclerView) view.findViewById(R.id.drawerList);
        mAdapter = new AdapterDrawer(getActivity(), new Session());
        mRecyclerDrawer.setAdapter(mAdapter);
        mRecyclerDrawer.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
