package com.ufjf.padroesdeprojeto;

public class FabricaTransporteRefrigerado implements FabricaAbstrata{
    @Override
    public Veiculo gerarVeiculo() {
        return new VeiculoCargaRefrigerada();
    }

    @Override
    public Motorista gerarMotorista() {
        return new MotoristaCargaFria();
    }
}
