package com.ufjf.padroesdeprojeto;

public abstract class Transporte {
    protected Carga carga;
    private String origem;
    private String destino;
    private TransporteEstado estado;

    public Transporte(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.estado = TransporteEstadoConfirmado.getInstance();
    }

    public abstract float custoTotalTransporte();

    public TransporteEstado getEstado() {
        return estado;
    }

    public boolean confirmarPedidoTransporteCarga() {
        return estado.confirmarPedidoTransporteCarga(this);
    }

    public boolean aguardarColetaCarga() {
        return estado.aguardarColetaCarga(this);
    }

    public boolean coletarCarga() {
        return estado.coletarCarga(this);
    }

    public boolean transportarCarga() {
        return estado.transportarCarga(this);
    }

    public boolean entregarCarga() {
        return estado.entregarCarga(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setEstado(TransporteEstado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }
}
