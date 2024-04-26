package com.example.rv_palabras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rv_palabras.databinding.WordItemListBinding;

import java.util.List;

public class WordAdapter extends  RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    //PASO 1 AÑADIR REPRESENTACIÓN DATOD
    private List<String> mWordlist;


    // metodo que recibe una lista  DESDE  desde el fragmento / PUNTO DE ENTRADA
    public  WordAdapter(List<String>mWordlist){
        this.mWordlist= mWordlist;
    }

    // MÉTODO ENCARGADO DE LA INFLAR LA VISTA
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),
            parent, false);
            return new WordViewHolder(mBinding);
    }


    // Encargado de recibir los datos del diseño del el metodo y setea los valores al texview
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        String element = mWordlist.get(position);
        holder.textView.setText(element);
    }

    @Override
    public int getItemCount() {
      return mWordlist.size();
    }


    // PASO 2 CLASE INTERNA QUE REPRESENTA LA VISTA WORD_ITEM_LIST.XML
    // INICIALIZAMO TEXVIEW QUE ES DENTRO DEL XML  Y LLAMAMOS MBINDING QUE ES DE LA CLASE XML QUE CONTIENE TEXVIEW
    public class WordViewHolder extends RecyclerView.ViewHolder{
  private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView= mBinding.textView;
        }
    }

}
