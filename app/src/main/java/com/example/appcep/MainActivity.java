
package com.example.appcep;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText txtCep;
    private Button btnCep;
    private TextView lblReposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtCep =  findViewById(R.id.txtCep);
        btnCep =  findViewById(R.id.btnCep);
        lblReposta =  findViewById(R.id.lblRetorno);

        buscarCep();




    }

    public void openLinkedInProfile(View view) {
        String linkedInUrl = "https://www.linkedin.com/in/hanri-santiago-1568a9146";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
        startActivity(intent);
    }


    private void buscarCep() {
        btnCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApIIterface apiIterface = APIClientSingleton.getClient().create(ApIIterface.class);

                Call<CepPojo> callCep = apiIterface.getCep(String.valueOf(txtCep.getText()));

                callCep.enqueue(
                        new Callback<CepPojo>() {
                            @Override
                            public void onResponse(Call<CepPojo> call, Response<CepPojo> response) {
                                if (response.isSuccessful()) {
                                    // Trate a resposta bem-sucedida
                                    CepPojo data = response.body();
                                    StringBuffer stringBuffer = new StringBuffer();

                                    stringBuffer.append("CEP: ");
                                    stringBuffer.append(data.getCep());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("Logradouro: ");
                                    stringBuffer.append(data.getLogradouro());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("Complemento: ");
                                    stringBuffer.append(data.getComplemento());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("Bairro: ");
                                    stringBuffer.append(data.getBairro());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("Cidade: ");
                                    stringBuffer.append(data.getCidade());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("Estado: ");
                                    stringBuffer.append(data.getEstado());
                                    stringBuffer.append("\n");
                                    stringBuffer.append("DD: ");
                                    stringBuffer.append(data.getDdd());
                                    lblReposta.setText(stringBuffer.toString());
                                } else {
                                    Toast.makeText(getApplicationContext(), "Erro ao buscar o CEP", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<CepPojo> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Erro interno no APP", Toast.LENGTH_LONG).show();
                                System.out.println(t);
                            }
                        }
                );
            }
        });
    }
}