package com.ufjf.padroesdeprojeto;

public abstract class CargaDecorator implements Carga {
    private Carga carga;

    public CargaDecorator(Carga carga) {
        this.carga = carga;
    }

    @Override
    public float getCustoTransporte() {
        return carga.getCustoTransporte();
    }

    @Override
    public void setPeso(float peso) {
        carga.setPeso(peso);
    }

    @Override
    public float getPeso() {
        return carga.getPeso();
    }

    @Override
    public String getDescricao() {
        return carga.getDescricao();
    }

    @Override
    public String getProduto() {
        return carga.getProduto();
    }

    @Override
    public void setProduto(String produto) {
        carga.setProduto(produto);
    }

    @Override
    public Veiculo getVeiculo() {
        return carga.getVeiculo();
    }

    @Override
    public Motorista getMotorista() {
        return carga.getMotorista();
    }
}