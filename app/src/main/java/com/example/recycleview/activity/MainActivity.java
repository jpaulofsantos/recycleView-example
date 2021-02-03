package com.example.recycleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycleview.R;
import com.example.recycleview.RecyclerItemClickListener;
import com.example.recycleview.adapter.Adapter;
import com.example.recycleview.model.Filmes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filmes> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();


        //configurar Adapter *recebe os dados e formata o layout

        Adapter adapter = new Adapter(listaFilmes);

        //configurar Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); //criando o gerenciador de layout
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); //otimiza o Recycler informando que tem um tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener( //esta classe RecyclerItemClickListener foi copiada da aula (disp. pelo Google)
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filmes filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo",
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )

        );

    }
    


    public void criarFilmes() {
        Filmes filme = new Filmes("Homem Aranha", "2010", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filmes("Titanic", "2012", "Drama");
        listaFilmes.add(filme);

        filme = new Filmes("Pokemon", "2017", "Desenho");
        listaFilmes.add(filme);

        filme = new Filmes("Mosul", "2020", "Ação");
        listaFilmes.add(filme);
    }
}