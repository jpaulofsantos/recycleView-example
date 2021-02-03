package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Filmes;

import java.util.List;

//após inserir o Adapter.MyViewHolder implementar os métodos e configura-los
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filmes> listaFilmes;
    public Adapter(List<Filmes> lista) {
        this.listaFilmes = lista;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //chamado para criar as visualizações

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);

        //cria o itemLista baseado no arquivo xml adapter_lista
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { //exibição dos itens

        Filmes filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    //criar esta classe primeiro, depois usar na linha 13 <>
    public class MyViewHolder extends RecyclerView.ViewHolder { //guardar os dados antes de exibi-los

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textViewTitulo);
            ano = itemView.findViewById(R.id.textViewAno);
            genero = itemView.findViewById(R.id.textViewGenero);
        }
    }
}
