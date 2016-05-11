package com.iespino.pets;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private TextView txtbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar ActionBar= (Toolbar)findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);

        getSupportActionBar().setIcon(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        txtbar = (TextView) findViewById(R.id.txtbar);
        txtbar.setText("MIS MASCOTAS");

        // Inicializar Animes
        List<Pets> items = new ArrayList<>();

        items.add(new Pets(R.drawable.pet1, "Speedy", 0));
        items.add(new Pets(R.drawable.pet2, "Pluto", 0));
        items.add(new Pets(R.drawable.pet3, "Doggy", 0));
        items.add(new Pets(R.drawable.pet4, "Hamsty", 0));
        items.add(new Pets(R.drawable.pet5, "Leoni", 0));
        items.add(new Pets(R.drawable.pet6, "TumTum", 0));
        items.add(new Pets(R.drawable.pet7, "Doberto", 0));

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

    public void verDetalle(View v)
    {
        Intent abrir= new Intent(this,Detalle.class);
        startActivity(abrir);
    }
}