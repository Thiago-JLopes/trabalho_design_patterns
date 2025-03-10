package com.ufjf.padroesdeprojeto;

public class TransporteEstadoConfirmado extends TransporteEstado {

    public TransporteEstadoConfirmado() {}
    private static TransporteEstadoConfirmado instance = new TransporteEstadoConfirmado();
    public static TransporteEstadoConfirmado getInstance() {
        return instance;
    }

    @Override
    public boolean aguardarColetaCarga(Transporte transporte) {
        transporte.setEstado(TransporteEstadoAguardando.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Transporte transporte) {
        transporte.setEstado(TransporteEstadoCancelado.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Confirmado";
    }
}
