package com.example.tgiot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tgiot.R;
import com.example.tgiot.dao.ThingDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListaThingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "TG IoT - Monitoração",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_lista_things);

        setTitle("Lista de Things - Monitoração IoT");

        FloatingActionButton botaoNovoThing = findViewById(R.id.activity_lista_things_fab_novo_thing);

        botaoNovoThing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaThingsActivity.this,FormularioThingActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ThingDAO dao = new ThingDAO();

        ListView listaThings = findViewById(R.id.activity_lista_things_listview);
        listaThings.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dao.todos()));
    }
}
