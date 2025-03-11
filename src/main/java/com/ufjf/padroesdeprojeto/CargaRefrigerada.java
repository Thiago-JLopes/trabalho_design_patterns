package com.ufjf.padroesdeprojeto;

public class CargaRefrigerada implements Carga {
    private float peso;
    private String produto;
    private float temperaturaRecomendada;
    private Veiculo veiculo;
    private Motorista motorista;

    public CargaRefrigerada(FabricaAbstrata fabrica) {
        this.veiculo = fabrica.gerarVeiculo();
        this.motorista = fabrica.gerarMotorista();
    }

    public void setTemperaturaRecomendada(float temperatura) {
        this.temperaturaRecomendada = temperatura;
    }

    public float getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    @Override
    public float getCustoTransporte() {
        return peso * 2.5f;
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
        return "Carga Refrigerada\nProduto: "+getProduto()+"\nMantida a " + temperaturaRecomendada + "°C.";
    }
}
