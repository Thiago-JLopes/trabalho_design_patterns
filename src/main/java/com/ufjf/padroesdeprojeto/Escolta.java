package com.ufjf.padroesdeprojeto;

public class Escolta extends CargaDecorator {

    public Escolta(Carga carga) {
        super(carga);
    }

    @Override
    public float getCustoTransporte() {
        return super.getCustoTransporte() * 1.15f;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + "\nEscolta Armada: Ativa";
    }
}