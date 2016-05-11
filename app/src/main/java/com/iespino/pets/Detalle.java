package com.iespino.pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Detalle extends AppCompatActivity
{
    private TextView txtbar;
    private ImageView imgtop;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar ActionBar= (Toolbar)findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);

        txtbar = (TextView) findViewById(R.id.txtbar);
        txtbar.setText("TOP MASCOTAS");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);

        // Inicializar Animes
        List<Pets> items = new ArrayList<>();

        items.add(new Pets(R.drawable.pet4, "Hamsty", 5));
        items.add(new Pets(R.drawable.pet5, "Leoni", 10));
        items.add(new Pets(R.drawable.pet3, "Doggy", 15));
        items.add(new Pets(R.drawable.pet1, "Speedy", 20));
        items.add(new Pets(R.drawable.pet2, "Pluto", 25));


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new Adapter(items);
        recycler.setAdapter(adapter);
    }
}
