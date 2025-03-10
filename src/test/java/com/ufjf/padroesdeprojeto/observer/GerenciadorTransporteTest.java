package com.ufjf.padroesdeprojeto.observer;

import com.ufjf.padroesdeprojeto.CargaEspecial;
import com.ufjf.padroesdeprojeto.GerenciadorTransporte;
import com.ufjf.padroesdeprojeto.Transporte;
import com.ufjf.padroesdeprojeto.TransporteFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTransporteTest {
    @Test
    void deveNotificarGerenciadorTransporte() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciador = new GerenciadorTransporte("GerenciadorTransporteA");
        transporte.setCarga(CargaEspecial.getInstance());

        gerenciador.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Gerenciador GerenciadorTransporteA: Rastreamento da carga - " + transporte.toString(), gerenciador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGerenciadorTransportes() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciadorA = new GerenciadorTransporte("GerenciadorTransporteA");
        GerenciadorTransporte gerenciadorB = new GerenciadorTransporte("GerenciadorTransporteB");
        transporte.setCarga(CargaEspecial.getInstance());

        gerenciadorA.iniciarRastreamento(transporte);
        gerenciadorB.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Gerenciador GerenciadorTransporteA: Rastreamento da carga - " + transporte.toString(), gerenciadorA.getUltimaNotificacao());
        assertEquals("Gerenciador GerenciadorTransporteB: Rastreamento da carga - " + transporte.toString(), gerenciadorB.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarGerenciadorTransporte() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciador = new GerenciadorTransporte("GerenciadorTransporteA");
        transporte.setCarga(CargaEspecial.getInstance());

        transporte.aguardarColetaCarga();

        assertNull(gerenciador.getUltimaNotificacao());
    }
}