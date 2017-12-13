package com.example.mgota.aad_final;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;

public class CurrencyListFragment extends Fragment {
    private CurrencyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        RecyclerView list = view.findViewById(R.id.list);
        this.adapter = new CurrencyAdapter();
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new CurrencyTouchHelper(adapter);
        ItemTouchHelper myHelper = new ItemTouchHelper(callback);
        myHelper.attachToRecyclerView(list);

        return view;
    }

    public void onResume()
    {
        super.onResume();

        this.adapter.notifyDataSetChanged();
    }

}
