package com.ufjf.padroesdeprojeto;

public class Seguro extends CargaDecorator {

    public Seguro(Carga carga) {
        super(carga);
    }

    @Override
    public float getCustoTransporte() {
        return super.getCustoTransporte() * 1.10f;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + "\nSeguro: Ativo";
    }
}