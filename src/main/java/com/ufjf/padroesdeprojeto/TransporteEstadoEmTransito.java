package com.ufjf.padroesdeprojeto;

public class TransporteEstadoEmTransito extends TransporteEstado{

    private TransporteEstadoEmTransito(){}
    private static TransporteEstadoEmTransito instance = new TransporteEstadoEmTransito();
    public static TransporteEstadoEmTransito getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Transito";
    }

    @Override
    public boolean entregarCarga(Transporte transporte) {
        transporte.setEstado(TransporteEstadoEntregue.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Transporte transporte) {
        transporte.setEstado(TransporteEstadoCancelado.getInstance());
        return true;
    }
}
