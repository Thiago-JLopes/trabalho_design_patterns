package com.ufjf.padroesdeprojeto.abstractfactory;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargasTest {
    @Test
    void deveCriarVeiculoParaCargaEspecial() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        assertEquals("Carga Especial", carga.getVeiculo().transportar());
    }

    @Test
    void deveCriarMotoristaParaCargaEspecial() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        assertEquals("Motorista para carga especial", carga.getMotorista().dirigir());
    }

    @Test
    void deveCriarVeiculoParaCargaRefrigerada() {
        FabricaAbstrata fabrica = new FabricaTransporteRefrigerado();
        Carga carga = new CargaRefrigerada(fabrica);
        assertEquals("Carga Refrigerada", carga.getVeiculo().transportar());
    }

    @Test
    void deveCriarMotoristaParaCargaRefrigerada() {
        FabricaAbstrata fabrica = new FabricaTransporteRefrigerado();
        Carga carga = new CargaRefrigerada(fabrica);
        assertEquals("Motorista para cargas frias", carga.getMotorista().dirigir());
    }

    @Test
    void deveCriarVeiculoParaCargaSensivel() {
        FabricaAbstrata fabrica = new FabricaTransporteSensivel();
        Carga carga = new CargaFragil(fabrica);
        assertEquals("Carga Sensivel", carga.getVeiculo().transportar());
    }

    @Test
    void deveCriarMotoristaParaCargaSensivel() {
        FabricaAbstrata fabrica = new FabricaTransporteSensivel();
        Carga carga = new CargaFragil(fabrica);
        assertEquals("Motorista para carga sensivel", carga.getMotorista().dirigir());
    }

    @Test
    void deveRetornarDescricaoCargaEspecial() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setProduto("Acido Sulfurico");
        assertEquals("Carga Especial\nProduto: Acido Sulfurico\nTransporte com requisitos específicos.", carga.getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaFragil() {
        FabricaAbstrata fabrica = new FabricaTransporteSensivel();
        Carga carga = new CargaFragil(fabrica);
        carga.setProduto("Eletronicos");
        assertEquals("Carga Fragil\nProduto: Eletronicos\nNecessita manuseio cuidadoso.", carga.getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaRefrigerada() {
        FabricaAbstrata fabrica = new FabricaTransporteRefrigerado();
        CargaRefrigerada carga = new CargaRefrigerada(fabrica);
        carga.setProduto("Leite");
        carga.setTemperaturaRecomendada(3);
        assertEquals("Carga Refrigerada\nProduto: Leite\nMantida a 3.0°C.", carga.getDescricao());
    }
}