package com.example.nuevowhatsapp.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuevowhatsapp.R;
import com.example.nuevowhatsapp.adapter.CallListAdapter;
import com.example.nuevowhatsapp.model.CallList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CallsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CallsFragment newInstance(String param1, String param2) {
        CallsFragment fragment = new CallsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_calls, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CallList> lists = new ArrayList<>();
        lists.add(new CallList("1","Miguel","12/01/2021 20:30","https://mobimg.b-cdn.net/pic/v2/gallery/preview/arren_riss_darren_criss-kino-lyudi-41370.jpg","voice","in","accepted"));
        lists.add(new CallList("1","Miguel","12/01/2021 18:40","https://mobimg.b-cdn.net/pic/v2/gallery/preview/arren_riss_darren_criss-kino-lyudi-41370.jpg","voice","in","declined"));
        lists.add(new CallList("3","Madre","12/01/2021 15:00","https://www.freejpg.com.ar/asset/400/9c/9cbc/F100012424.jpg","video","out","accepted"));
        lists.add(new CallList("3","Madre","12/01/2021 14:50","https://www.freejpg.com.ar/asset/400/9c/9cbc/F100012424.jpg","video","in","declined"));
        lists.add(new CallList("2","Bryan","08/01/2021 17:50","https://www.ejezeta.cl/wp-content/uploads/2013/12/0004_CMan0018HD2O01P05S-1024x1024.jpg","voice","out","accepted"));


        recyclerView.setAdapter(new CallListAdapter(lists,getContext()));
        return view;
    }
}