package com.ufjf.padroesdeprojeto.singleton;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargaTest {
    @Test
    void deveRetornarDescricaoCargaEspecial() {
        CargaEspecial cargaEspecial = new CargaEspecial(new FabricaTransporteEspecial());
        cargaEspecial.setProduto("Acido Sulfurico");
        assertEquals("Carga Especial\nProduto: Acido Sulfurico\nTransporte com requisitos específicos.", cargaEspecial.getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaFragil() {
        CargaFragil cargaFragil = new CargaFragil(new FabricaTransporteSensivel());
        cargaFragil.setProduto("Eletronicos");
        assertEquals("Carga Fragil\nProduto: Eletronicos\nNecessita manuseio cuidadoso.", cargaFragil.getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaRefrigerada() {
        CargaRefrigerada cargaRefrigerada = new CargaRefrigerada(new FabricaTransporteRefrigerado());
        cargaRefrigerada.setProduto("Leite");
        cargaRefrigerada.setTemperaturaRecomendada(3);
        assertEquals("Carga Refrigerada\nProduto: Leite\nMantida a 3.0°C.", cargaRefrigerada.getDescricao());
    }
}
