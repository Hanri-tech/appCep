package com.example.appcep;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApIIterface {
    @GET("{cep}/json")
    Call<CepPojo> getCep(@Path("cep") String cep);
}
