package com.ufjf.padroesdeprojeto;

public abstract class Transporte {
    protected Carga carga;
    private String origem;
    private String destino;

    public Transporte(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public abstract float custoTotalTransporte();

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }
}
