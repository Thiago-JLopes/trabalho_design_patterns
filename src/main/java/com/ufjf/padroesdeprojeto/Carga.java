package com.ufjf.padroesdeprojeto;

public interface Carga {
    float getCustoTransporte();
    void setPeso(float peso);
    float getPeso();
    String getDescricao();
    String getProduto();
    void setProduto(String produto);
}
