package com.example.childrenslibrayapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.structures.*;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, autor, genero, codigo;

        private ImageView caratula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            autor = (TextView) itemView.findViewById(R.id.tv_autor);
            genero = (TextView) itemView.findViewById(R.id.tv_genero);
            codigo = (TextView) itemView.findViewById(R.id.tv_codigo);
            caratula = (ImageView) itemView.findViewById(R.id.im_caratula);
        }


    }

    public DynamicArray<Book> libroEnListas;

    public RecyclerViewAdaptador(DynamicArray<Book> libroEnListas) {
        this.libroEnListas = libroEnListas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            holder.titulo.setText(libroEnListas.getVal(position).getTitle());
            holder.autor.setText(libroEnListas.getVal(position).getAuthorName());
            holder.genero.setText(libroEnListas.getVal(position).getGenre());
            holder.codigo.setText(libroEnListas.getVal(position).getCode());
            holder.caratula.setImageResource(libroEnListas.getVal(position).getImgLibro());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return libroEnListas.getSize();
    }
}
