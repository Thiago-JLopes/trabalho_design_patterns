package com.ufjf.padroesdeprojeto;

public class TransporteEstadoAguardando extends TransporteEstado{

    private TransporteEstadoAguardando(){}
    private static TransporteEstadoAguardando instance = new TransporteEstadoAguardando();
    public static TransporteEstadoAguardando getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aguardando Coletada da Carga";
    }

    @Override
    public boolean coletarCarga(Transporte transporte) {
        transporte.setEstado(TransporteEstadoCargaColetada.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Transporte transporte) {
        transporte.setEstado(TransporteEstadoCancelado.getInstance());
        return true;
    }
}
