package com.example.churchapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.churchapp.CardData;
import com.example.churchapp.MyAdapter;
import com.example.churchapp.R;

public class DashboardFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        CardData[] myData = new CardData[]{
                new CardData("account balance", R.drawable.ic_home_black_24dp),
                new CardData("photo", R.drawable.ic_home_black_24dp),
                new CardData("alert", R.drawable.ic_home_black_24dp),
                new CardData("box", R.drawable.ic_home_black_24dp),
                new CardData("call", R.drawable.ic_home_black_24dp),
                new CardData("shopping", R.drawable.ic_home_black_24dp),
                new CardData("car", R.drawable.ic_home_black_24dp),
                new CardData("check", R.drawable.ic_home_black_24dp),
                new CardData("translate", R.drawable.ic_home_black_24dp),
        };

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MyAdapter(myData));

        return view;
    }
}