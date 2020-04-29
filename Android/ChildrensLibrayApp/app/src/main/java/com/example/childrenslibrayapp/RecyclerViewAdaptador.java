package com.example.childrenslibrayapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public List <LibroEnLista> libroEnListas;

    public RecyclerViewAdaptador(List<LibroEnLista> libroEnListas) {
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
        holder.titulo.setText(libroEnListas.get(position).getTitulo());
        holder.autor.setText(libroEnListas.get(position).getAutor());
        holder.genero.setText(libroEnListas.get(position).getGenero());
        holder.codigo.setText(libroEnListas.get(position).getCodigo());
        holder.caratula.setImageResource(libroEnListas.get(position).getImgLibro());
    }

    @Override
    public int getItemCount() {
        return libroEnListas.size();
    }
}
