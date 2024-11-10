package com.example.appcep;

import com.squareup.moshi.Json;

public class CepPojo {
    @Json(name = "cep")
    String cep;
    @Json(name ="logradouro")
    String logradouro;
    @Json(name ="complemento")
    String complemento;
    @Json(name ="bairro")
    String bairro;
    @Json(name ="estado")
    String estado;
    @Json(name ="ddd")
    String ddd;
    @Json(name ="localidade")
    String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "CepPojo{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
