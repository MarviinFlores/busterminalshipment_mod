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

                content = "Clave:  " + response.body().getXKey() +
                        "\n Numero Cliente:  " + response.body().getSenderCustomerXKey() +
                        "\n Destinatario:  " + response.body().getReceiverFullName() +
                        "\n Celular:  " + response.body().getReceiverMobilPhone() +
                        "\n E-mail:  " + response.body().getReceiverEmail() +
                        "\n Contrasena:  " + response.body().getXPassword() +
                        "\n TrackingNumber:  " + response.body().getTrackingNumber() +
                        "\n Fecha:  " + response.body().getXDate() +
                        "\n Origen:  " + response.body().getXFrom() +
                        "\n Destino:  " + response.body().getXTo() +
                        "\n Contenido:  " + response.body().getXContent() +
                        "\n Valor Declarado:  " + response.body().getDeclaredAmount() +
                        "\n Costo de Envio:  " + response.body().getFee() +
                        "\n Al Cobro:  " + response.body().getPayWhenReceived() +
                        "\n Estado de Pago:  " + response.body().getPaymentStatus() +
                        "\n Valor:  " + response.body().getInvoiceXValue() +
                        "\n Estado de Encomienda:  " + response.body().getShipmentStatus() +
                        "\n Entregada por  :  "+response.body().getLastModificationAuthor()+
                        "\n Fecha de Entrega :  "+response.body().getLastModificationDateTime()+
                        "\n Bus #:  " + response.body().getBusXKey() +
                        "\n Conductor #:  " + response.body().getBusDriverXKey()+
                        "\n Creada por:  " + response.body().getCreationAuthor();


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