package com.ufjf.padroesdeprojeto;

public class FabricaTransporteEspecial implements FabricaAbstrata{
    @Override
    public Veiculo gerarVeiculo() {
        return new VeiculoCargaEspecial();
    }

    @Override
    public Motorista gerarMotorista() {
        return new MotoristaCargaEspecial();
    }
}
