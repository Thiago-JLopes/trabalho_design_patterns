package com.ufjf.padroesdeprojeto;

public class TransporteEstadoEntregue extends TransporteEstado{

    private TransporteEstadoEntregue(){}
    private static TransporteEstadoEntregue instance = new TransporteEstadoEntregue();
    public static TransporteEstadoEntregue getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
