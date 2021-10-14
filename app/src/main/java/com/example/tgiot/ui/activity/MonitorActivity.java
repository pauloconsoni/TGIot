package com.example.tgiot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tgiot.model.DeviceData;
import com.example.tgiot.R;
import com.example.tgiot.asynctask.BaseAsyncTask2;
import com.example.tgiot.model.DadosThing;
import com.example.tgiot.model.RequestResponseTotal;
import com.example.tgiot.model.Thing;
import com.example.tgiot.retrofit.ThingRetrofit;
import com.example.tgiot.service.ThingService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_monitor);

        Intent dados = getIntent();
        Thing thing = (Thing) dados.getSerializableExtra("Thing");

        setTitle(thing.getNome());

        TextView textFluxo = findViewById(R.id.activity_monitor_text_fluxo);
        TextView textTemperatura = findViewById(R.id.activity_monitor_text_temperatura);

        ThingService service = new ThingRetrofit().getThingService();
        Call<List<RequestResponseTotal>> dadosThingCall = service.buscaDados();

        new BaseAsyncTask2<>(()->{
            try {
                Response<List<RequestResponseTotal>> resposta = dadosThingCall.execute();
                DeviceData dadosNovos = resposta.body().get(0).getDeviceData();
                String teste = resposta.body().toString();
                return dadosNovos;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }, dadosNovos ->{
            if (dadosNovos!=null){
                DeviceData response = (DeviceData) dadosNovos;
                DadosThing dadosThing = new DadosThing();
                dadosThing.setFluxo(response.getFlow());
                dadosThing.setTemperatura(response.getTempe());

                thing.updateDadosThing(dadosThing);
            }
        }).execute();

        textFluxo.setText(thing.getDadosThing().getFluxo());
        textTemperatura.setText(thing.getDadosThing().getTemperatura());

    }
}
