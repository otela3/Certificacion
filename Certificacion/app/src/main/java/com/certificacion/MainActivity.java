package com.certificacion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certificacion.adapter.MansionesAdapter;
import com.certificacion.databinding.ActivityMainBinding;
import com.certificacion.model.Mansion;
import com.certificacion.viewmodel.MansionViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MansionViewModel viewModel;
    private MansionesAdapter adapter;
    private ArrayList<Mansion> mansionList = new ArrayList<>();
    private ActivityMainBinding binding;




    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MansionViewModel.class);
        initRecyclerView();
        viewModel.getMansiones();


    }

    private void initRecyclerView(){
        binding.mansionRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MansionesAdapter(getApplicationContext(),mansionList);
        binding.mansionRecycler.setAdapter(adapter);
    }
}