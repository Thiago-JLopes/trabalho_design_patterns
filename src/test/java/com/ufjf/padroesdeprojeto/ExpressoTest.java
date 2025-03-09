package com.ufjf.padroesdeprojeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressoTest {
    Transporte transporte;
    @BeforeEach
    void setUp() {
        transporte = TrasporteFactory.obterTransporte("Expresso", "CidadeA", "CidadeB");
        CargaFragil.getInstance().setPeso(20000.0f);
        CargaRefrigerada.getInstance().setPeso(20000.0f);
        CargaEspecial.getInstance().setPeso(200000.0f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaFragil() {
        transporte.setCarga(CargaFragil.getInstance());
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(72000.0f, custoTotal, 0.01f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaRefrigerada() {
        transporte.setCarga(CargaRefrigerada.getInstance());
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(90000.0f, custoTotal, 0.01f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaEspecial() {
        transporte.setCarga(CargaEspecial.getInstance());
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(540000.0f, custoTotal, 0.01f);
    }
}