package com.example.tgiot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    Intent dados;
    Thing thing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_monitor);

        dados = getIntent();
        thing = (Thing) dados.getSerializableExtra("Thing");

        setTitle(thing.getNome());
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.removeCallbacks(getResponceAfterInterval);
        handler.post(getResponceAfterInterval);
    }

    private final Handler handler = new Handler();
    private Runnable getResponceAfterInterval = new Runnable() {

        public void run() {

            try
            {
                TextView textFluxo = findViewById(R.id.activity_monitor_text_fluxo);
                TextView textTemperatura = findViewById(R.id.activity_monitor_text_temperatura);
                ThingService service = new ThingRetrofit().getThingService();
                Call<RequestResponseTotal> dadosThingCall = service.buscaDados();
                new BaseAsyncTask2<>(()->{
                    try {
                        Response<RequestResponseTotal> resposta = dadosThingCall.execute();
                        RequestResponseTotal dadosNovos = resposta.body();
                        return dadosNovos;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, dadosNovos ->{
                    if (dadosNovos!=null){
                        DadosThing dadosThing = new DadosThing();
                        dadosThing.setFluxo(dadosNovos.getFlow());
                        dadosThing.setTemperatura(dadosNovos.getTemp());

                        thing.updateDadosThing(dadosThing);
                    }
                }).execute();
                textFluxo.setText(thing.getDadosThing().getFluxo());
                textTemperatura.setText(thing.getDadosThing().getTemperatura());

            } catch (Exception e) {

            }

            handler.postDelayed(this, 1000);

        }
    };
}
