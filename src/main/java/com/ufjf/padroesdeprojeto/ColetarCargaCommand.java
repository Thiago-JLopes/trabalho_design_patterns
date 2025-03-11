package com.ufjf.padroesdeprojeto;

public class ColetarCargaCommand implements TransporteCommand {
    private Transporte transporte;
    private TransporteEstado estadoAnterior;

    public ColetarCargaCommand(Transporte transporte) {
        this.transporte = transporte;
        this.estadoAnterior = transporte.getEstado();
    }

    @Override
    public void executar() {
        if (!transporte.coletarCarga()) {
            throw new IllegalStateException("Não é possível coletar carga no estado atual: " + transporte.getNomeEstado());
        }
    }

    @Override
    public void desfazer() {
        transporte.setEstado(estadoAnterior);
    }
}