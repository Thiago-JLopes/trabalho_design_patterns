package com.ufjf.padroesdeprojeto;

public class TransporteEstadoCargaColetada extends TransporteEstado{

    private TransporteEstadoCargaColetada(){}
    private static TransporteEstadoCargaColetada instance = new TransporteEstadoCargaColetada();
    public static TransporteEstadoCargaColetada getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Carga Coletada";
    }

    @Override
    public boolean transportarCarga(Transporte transporte) {
        transporte.setEstado(TransporteEstadoEmTransito.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Transporte transporte) {
        transporte.setEstado(TransporteEstadoCancelado.getInstance());
        return true;
    }
}
