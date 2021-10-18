package com.example.tgiot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tgiot.R;
import com.example.tgiot.dao.ThingDAO;
import com.example.tgiot.model.Thing;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ListaThingsActivity extends AppCompatActivity {

    ArrayAdapter<Thing> adapter;
    ThingDAO dao = new ThingDAO();

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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Remover");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Thing thingEscolhida = adapter.getItem(menuInfo.position);
        adapter.remove(thingEscolhida);
        dao.remove(thingEscolhida);

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView listaThings = findViewById(R.id.activity_lista_things_listview);
        final List<Thing> things = dao.todos();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, things);
        listaThings.setAdapter((ListAdapter) adapter);
        listaThings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Thing thingEscolhida = things.get(position);
                Toast.makeText(ListaThingsActivity.this,thingEscolhida.toString(),Toast.LENGTH_SHORT).show();
                Intent vaiParaMonitor =  new Intent(ListaThingsActivity.this, MonitorActivity.class);
                vaiParaMonitor.putExtra("Thing",thingEscolhida);
                startActivity(vaiParaMonitor);
            }
        });

//        listaThings.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Thing thingRemovida = (Thing) parent.getItemAtPosition(position);
//                adapter.remove(thingRemovida);
//                dao.remove(thingRemovida);
//                return false;
//            }
//        });

        registerForContextMenu(listaThings);
    }
}
