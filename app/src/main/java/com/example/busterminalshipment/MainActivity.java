package com.example.busterminalshipment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.health.ServiceHealthStats;
import android.util.Log;
import android.widget.TextView;

import com.example.busterminalshipment.Interface.jsonPlaceHolder;
import com.example.busterminalshipment.Model.Shipment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView mJsoTxtView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsoTxtView = findViewById(R.id.jsonText);


        getInfoShipment();


    }


    private void getInfoShipment() {
        // Registro del LocalDateTime Converter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {


                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDateTime.parse(json.getAsString());
                    }
                }).create();

        // creacion de Instacia RETROFIT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.busterminal.octword.net")  // OCTWORD AP
                .addConverterFactory(GsonConverterFactory.create(gson))         //    GSON CONVERRTER
                .build();        // Llama a la  clase INTERFAZ
        jsonPlaceHolder jsonPlaceHolder = retrofit.create(jsonPlaceHolder.class);


        Call<Shipment> call = jsonPlaceHolder.getShipmentInfo();
        call.enqueue(new Callback<Shipment>() {
            @Override
            public void onResponse(Call<Shipment> call, Response<Shipment> response) {
                if (!response.isSuccessful()) {
                    mJsoTxtView.setText("Codigo:   " + response.code());
                    return;
                }
                // <Shipment>  infoTrack = response.body(); // respuesta del servidor

                String content = "";

                content = "XKey:" + response.body().getXKey() +
                        "\n SenderCustomerXKey:" + response.body().getSenderCustomerXKey() +
                        "\n ReceiverFullName:" + response.body().getReceiverFullName() +
                        "\n ReceiverMobilPhone:" + response.body().getReceiverMobilPhone() +
                        "\n ReceiverEmail:" + response.body().getReceiverEmail() +
                        "\n XPassword:" + response.body().getXPassword() +
                        "\n TrackingNumber:" + response.body().getTrackingNumber() +
                        "\n XDate:" + response.body().getXDate() +
                        "\n XFrom:" + response.body().getXFrom() +
                        "\n XTo:" + response.body().getXTo() +
                        "\n XContent:" + response.body().getXContent() +
                        "\n DeclaredAmount:" + response.body().getDeclaredAmount() +
                        "\n Fee:" + response.body().getFee() +
                        "\n PayWhenReceived:" + response.body().getPayWhenReceived() +
                        "\n PaymentStatus:" + response.body().getPaymentStatus() +
                        "\n InvoiceXValue:" + response.body().getInvoiceXValue() +
                        "\n ShipmentStatus:" + response.body().getShipmentStatus() +
                        "\n BusXKey:" + response.body().getBusXKey() +
                        "\n BusDriverXKey:" + response.body().getBusDriverXKey();


                mJsoTxtView.append(content);


            }

            @Override
            public void onFailure(Call<Shipment> call, Throwable t) {
                mJsoTxtView.setText(t.getMessage());
            }
        });
        {

        }

    }


}



/**public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/