package com.example.busterminalshipment.Interface;


import com.example.retroapilusgson.Model.Post;
import com.example.retroapilusgson.Model.Shipment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JasonPlaceHolder {
    // API jsonplaceholder.com   example of GET  info from FAKE API
    /**@GET("posts")
    Call<List<Post>> getPosts();*/


    @GET("api/BusTerminal/getShipmentInfo?p_string_DatabaseName=OWDATABASE_BUSTERMINAL_1G&p_string_TrackingNumber=4026844342")
    Call <Shipment> getShipmentInfo();
    // http://api.busterminal.octword.net/api/BusTerminal/getShipmentInfo?p_string_DatabaseName=OWDATABASE_BUSTERMINAL_1G&p_string_TrackingNumber=4026844342

}
