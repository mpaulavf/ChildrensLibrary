package com.example.lista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView acti, descripcion;
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            acti=(TextView)itemView.findViewById(R.id.tv_actividad);
            descripcion=(TextView)itemView.findViewById(R.id.tv_descripcion);
            foto=(ImageView) itemView.findViewById(R.id.iv_imagen);
        }
    }

    public List<actividad_elegible> fotolista;

    public RecyclerViewAdaptador(List<actividad_elegible> fotolista) {
        this.fotolista = fotolista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cantante,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.acti.setText(fotolista.get(position).getActi());
        holder.descripcion.setText(fotolista.get(position).getDescricion());
        holder.foto.setImageResource(fotolista.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return fotolista.size();
    }
}

