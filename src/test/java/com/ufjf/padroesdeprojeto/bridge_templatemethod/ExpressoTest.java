package com.ufjf.padroesdeprojeto.bridge_templatemethod;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressoTest {
    Transporte transporte;
    Carga cargaFragil;
    Carga cargaRefrigerada;
    Carga cargaEspecial;

    @BeforeEach
    void setUp() {
        transporte = TransporteFactory.obterTransporte("Expresso", "CidadeA", "CidadeB");

        cargaFragil = new CargaFragil(new FabricaTransporteSensivel());
        cargaRefrigerada = new CargaRefrigerada(new FabricaTransporteRefrigerado());
        cargaEspecial = new CargaEspecial(new FabricaTransporteEspecial());

        cargaFragil.setPeso(20000.0f);
        cargaRefrigerada.setPeso(20000.0f);
        cargaEspecial.setPeso(200000.0f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaFragil() {
        transporte.setCarga(cargaFragil);
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(72000.0f, custoTotal, 0.01f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaRefrigerada() {
        transporte.setCarga(cargaRefrigerada);
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(90000.0f, custoTotal, 0.01f);
    }

    @Test
    void deveRetornarCustoTotalTransporteCargaEspecial() {
        transporte.setCarga(cargaEspecial);
        float custoTotal = transporte.custoTotalTransporte();
        assertEquals(540000.0f, custoTotal, 0.01f);
    }
}
