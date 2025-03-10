package com.ufjf.padroesdeprojeto;

public abstract class TransporteEstado {
    public abstract String getEstado();

    public boolean confirmarPedidoTransporteCarga(Transporte transporte) {
        return false;
    }

    public boolean aguardarColetaCarga(Transporte transporte) {
        return false;
    }

    public boolean coletarCarga(Transporte transporte) {
        return false;
    }

    public boolean transportarCarga(Transporte transporte) {
        return false;
    }

    public boolean entregarCarga(Transporte transporte) {
        return false;
    }

    public boolean cancelar(Transporte transporte) {
        return false;
    }
}
