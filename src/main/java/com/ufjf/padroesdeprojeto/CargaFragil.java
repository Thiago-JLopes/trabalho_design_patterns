package com.ufjf.padroesdeprojeto;

public class CargaFragil implements Carga {
    private float peso;
    private String produto;
    private Veiculo veiculo;
    private Motorista motorista;

    public CargaFragil(FabricaAbstrata fabrica) {
        this.veiculo = fabrica.gerarVeiculo();
        this.motorista = fabrica.gerarMotorista();
    }

    @Override
    public float getCustoTransporte() {
        return peso * 2.0f;
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
    public String getProduto() {
        return this.produto;
    }

    @Override
    public String getDescricao() {
        return "Carga Fragil\nProduto: " + getProduto() + "\nNecessita manuseio cuidadoso.";
    }
}
