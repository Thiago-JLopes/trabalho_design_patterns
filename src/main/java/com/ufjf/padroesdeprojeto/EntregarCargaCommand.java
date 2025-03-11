package com.ufjf.padroesdeprojeto;

public class EntregarCargaCommand implements TransporteCommand {
    private Transporte transporte;
    private TransporteEstado estadoAnterior;

    public EntregarCargaCommand(Transporte transporte) {
        this.transporte = transporte;
        this.estadoAnterior = transporte.getEstado();
    }

    @Override
    public void executar() {
        if (!transporte.entregarCarga()) {
            throw new IllegalStateException("Não é possível entregar carga no estado atual: " + transporte.getNomeEstado());
        }
    }

    @Override
    public void desfazer() {
        transporte.setEstado(estadoAnterior);
    }
}