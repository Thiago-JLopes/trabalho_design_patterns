package com.ufjf.padroesdeprojeto;

public class TransporteEstadoCancelado extends TransporteEstado{

    private TransporteEstadoCancelado(){}
    private static TransporteEstadoCancelado instance = new TransporteEstadoCancelado();
    public static TransporteEstadoCancelado getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
