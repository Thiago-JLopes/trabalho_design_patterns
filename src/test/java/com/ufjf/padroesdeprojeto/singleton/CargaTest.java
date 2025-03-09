package com.ufjf.padroesdeprojeto.singleton;

import com.ufjf.padroesdeprojeto.CargaEspecial;
import com.ufjf.padroesdeprojeto.CargaFragil;
import com.ufjf.padroesdeprojeto.CargaRefrigerada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargaTest {
    @Test
    void deveRetornarDescricaoCargaEspecial() {
        CargaEspecial.getInstance().setProduto("Acido Sulfurico");
        assertEquals("Carga Especial\nProduto: Acido Sulfurico\nTransporte com requisitos específicos.", CargaEspecial.getInstance().getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaFragil() {
        CargaFragil.getInstance().setProduto("Eletronicos");
        assertEquals("Carga Fragil\nProduto: Eletronicos\nNecessita manuseio cuidadoso.", CargaFragil.getInstance().getDescricao());
    }

    @Test
    void deveRetornarDescricaoCargaRefrigerada() {
        CargaRefrigerada.getInstance().setProduto("Leite");
        CargaRefrigerada.getInstance().setTemperaturaRecomendada(3);
        assertEquals("Carga Refrigerada\nProduto: Leite\nMantida a 3.0°C.", CargaRefrigerada.getInstance().getDescricao());
    }
}