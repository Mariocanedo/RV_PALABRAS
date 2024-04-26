package com.example.rv_palabras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rv_palabras.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    // CREAMOS UN LIST QUE ME REPRESENTA LO DATOS para hacer dinamico el RV
    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // instancia el Adapter le pasamos los datos a la clase WORDADAPTER
        WordAdapter adapter = new WordAdapter(setData());
        // LE PASAMOS EL ADAPTER AL RV
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.add("PALABRA" + dataList.size());
                // notificar al adapter que insertamos datos

                binding.recyclerView.getAdapter().notifyItemInserted(dataList.size());
                // Scroll al final de la lista
                binding.recyclerView.smoothScrollToPosition(dataList.size());
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // METODO PARA GENERAR DATOS

    private List<String> setData() {
        for (int i = 0; i < 99; i++) {
            dataList.add("PALABRA:" + i);
        }
        return dataList;
    }







}