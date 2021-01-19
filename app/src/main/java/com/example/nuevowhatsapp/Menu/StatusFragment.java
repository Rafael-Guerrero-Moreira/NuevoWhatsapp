package com.example.nuevowhatsapp.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuevowhatsapp.R;
import com.example.nuevowhatsapp.adapter.StatusListAdapter;
import com.example.nuevowhatsapp.model.StatusList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatusFragment newInstance(String param1, String param2) {
        StatusFragment fragment = new StatusFragment();
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

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status,container,false);

        recyclerView = view.findViewById(R.id.recyclerViewStatus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<StatusList> list = new ArrayList<>();
        list.add(new StatusList("1","Miguel","Hoy 16:37","https://ruizhealytimes.com/wp-content/uploads/2017/11/silvestre-piolin-abuelita-1280x720.jpg"));
        list.add(new StatusList("3","Madre","Hoy 09:21","https://i.pinimg.com/564x/98/f9/16/98f91666fa791d95e1391d221dccce10.jpg"));
        list.add(new StatusList("2","Bryan","Hoy 16:37","https://i.pinimg.com/originals/70/12/41/7012415ba71307251e6f97b060f8c471.jpg"));

        recyclerView.setAdapter(new StatusListAdapter(list,getContext()));

        return view;
    }
}