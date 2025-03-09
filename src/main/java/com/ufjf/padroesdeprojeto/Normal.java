package com.ufjf.padroesdeprojeto;

public class Normal extends Transporte {

    public Normal(String origem, String destino) {
        super(origem, destino);
    }

    @Override
    public float custoTotalTransporte() {
        if (carga == null) {
            throw new IllegalStateException("Nenhuma carga definida para transporte.");
        }
        return carga.getCustoTransporte() * 1.2f;
    }

    @Override
    public String toString() {
        return "Transporte Normal de " + getOrigem() + " para " + getDestino() +
                " com custo total: R$ " + custoTotalTransporte();
    }
}
