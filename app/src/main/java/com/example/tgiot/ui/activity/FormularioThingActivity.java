package com.example.tgiot.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tgiot.R;
import com.example.tgiot.dao.ThingDAO;
import com.example.tgiot.model.Thing;

public class FormularioThingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_thing);

        final ThingDAO dao = new ThingDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_thing_nome);
        final EditText campoUrl = findViewById(R.id.activity_formulario_thing_URL);

        Button botaoSalvar = findViewById(R.id.activity_formulario_thing_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String url = campoUrl.getText().toString();

                Thing thing = new Thing(nome,url);

                dao.salva(thing);

                startActivity(new Intent(FormularioThingActivity.this,ListaThingsActivity.class));

                finish();
            }
        });
    }
}