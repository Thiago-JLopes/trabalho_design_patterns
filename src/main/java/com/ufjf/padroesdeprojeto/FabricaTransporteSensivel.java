package com.ufjf.padroesdeprojeto;

public class FabricaTransporteSensivel implements FabricaAbstrata{
    @Override
    public Veiculo gerarVeiculo() {
        return new VeiculoCargaSensivel();
    }

    @Override
    public Motorista gerarMotorista() {
        return new MotoristaCargaSensivel();
    }
}
