//package com.example.tgiot.asynctask;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.example.RequestResponse;
//import com.example.tgiot.model.DadosThing;
//import com.example.tgiot.model.Thing;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//
//import retrofit2.Call;
//import retrofit2.Response;
//
//public class BaseAsyncTask extends AsyncTask<Void,Void,RequestResponse> {
//
//    private Call<RequestResponse> dadosThingCall;
//
//    public Thing getThing() {
//        return thing;
//    }
//
//    private Thing thing;
//
//    public BaseAsyncTask(Call<RequestResponse> dadosThingCall, Thing thing){
//        this.dadosThingCall=dadosThingCall;
//        this.thing=thing;
//    }
//
//    @Override
//    protected RequestResponse doInBackground(Void[] objects) {
//        RequestResponse dadosThing = null;
//        try {
//            Response<RequestResponse> resposta = dadosThingCall.execute();
//            dadosThing = resposta.body();
//            Log.i("TAG", resposta.body().getFlow());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.i("TAG", "oi");
//        return dadosThing;
//    }
//
//    @Override
//    protected void onPostExecute(RequestResponse o) {
//        super.onPostExecute(o);
//        RequestResponse response = (RequestResponse) o;
//        DadosThing dadosThing = new DadosThing();
//        dadosThing.setFluxo(response.getFlow());
//        dadosThing.setTemperatura(response.getTempe());
//
//        thing.updateDadosThing(dadosThing);
//    }
//}
