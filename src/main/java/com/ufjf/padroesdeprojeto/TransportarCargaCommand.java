package com.ufjf.padroesdeprojeto;

public class TransportarCargaCommand implements TransporteCommand {
    private Transporte transporte;
    private TransporteEstado estadoAnterior;

    public TransportarCargaCommand(Transporte transporte) {
        this.transporte = transporte;
        this.estadoAnterior = transporte.getEstado();
    }

    @Override
    public void executar() {
        if (!transporte.transportarCarga()) {
            throw new IllegalStateException("Não é possível transportar carga no estado atual: " + transporte.getNomeEstado());
        }
    }

    @Override
    public void desfazer() {
        transporte.setEstado(estadoAnterior);
    }
}