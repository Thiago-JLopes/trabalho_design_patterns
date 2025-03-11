package com.ufjf.padroesdeprojeto;

public class CargaEspecial implements Carga {
    private float peso;
    private String produto;
    private Veiculo veiculo;
    private Motorista motorista;

    public CargaEspecial(FabricaAbstrata fabrica) {
        this.veiculo = fabrica.gerarVeiculo();
        this.motorista = fabrica.gerarMotorista();
    }

    @Override
    public float getCustoTransporte() {
        return peso * 1.5f;
    }

    @Override
    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public float getPeso() {
        return this.peso;
    }

    @Override
    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    @Override
    public Motorista getMotorista() {
        return this.motorista;
    }

    @Override
    public String getProduto() {
        return this.produto;
    }

    @Override
    public String getDescricao() {
        return "Carga Especial\nProduto: " + getProduto() + "\nTransporte com requisitos específicos.";
    }
}
