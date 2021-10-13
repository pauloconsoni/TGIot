package com.example.tgiot.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tgiot.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "TG IoT - Monitoração",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        setTitle("Lista de Things");
        List<String> things = new ArrayList<>(Arrays.asList("Raspberry","banana","teste"));
        ListView listaThings = findViewById(R.id.activity_main_lista_things);
        listaThings.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,things));
    }
}
