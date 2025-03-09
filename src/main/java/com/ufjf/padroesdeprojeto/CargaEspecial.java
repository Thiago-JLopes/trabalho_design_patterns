package com.ufjf.padroesdeprojeto;

public class CargaEspecial implements Carga {
    private float peso;
    private String produto;
    private static final CargaEspecial instance = new CargaEspecial();

    private CargaEspecial() {}

    public static CargaEspecial getInstance() {
        return instance;
    }

    @Override
    public float getCustoTransporte() {
        return peso * 1.5f;
    }

    @Override
    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public float getPeso() {
        return this.peso;
    }

    @Override
    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public String getProduto() {
        return this.produto;
    }

    @Override
    public String getDescricao() {
        return "Carga Especial\nProduto: " + getProduto() + "\nTransporte com requisitos específicos.";
    }
}
