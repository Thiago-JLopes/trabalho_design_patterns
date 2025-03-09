package com.ufjf.padroesdeprojeto;

public class Expresso extends Transporte {

    public Expresso(String origem, String destino) {
        super(origem, destino);
    }

    @Override
    public float custoTotalTransporte() {
        if (carga == null) {
            throw new IllegalStateException("Nenhuma carga definida para transporte.");
        }
        return carga.getCustoTransporte() * 1.8f;
    }

    @Override
    public String toString() {
        return "Transporte Expresso de " + getOrigem() + " para " + getDestino() +
                " com custo total: R$ " + custoTotalTransporte();
    }
}
