package com.ufjf.padroesdeprojeto.factorymethod;

import com.ufjf.padroesdeprojeto.Transporte;
import com.ufjf.padroesdeprojeto.TrasporteFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrasporteFactoryTest {

    @Test
    void deveRetornarExcecaoTipoEntregaInexistente(){
        try {
            Transporte transporte = TrasporteFactory.obterTransporte("Urgente", "CidadeA", "CidadeB");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de transporte inexistente", e.getMessage());
        }
    }

    @Test
    void deveObterOrigemEntrega(){
        Transporte transporte = TrasporteFactory.obterTransporte("Expresso", "CidadeA", "CidadeB");
        assertEquals("CidadeA", transporte.getOrigem());
    }

}