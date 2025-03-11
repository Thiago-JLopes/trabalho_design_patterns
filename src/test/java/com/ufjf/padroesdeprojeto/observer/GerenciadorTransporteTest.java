package com.ufjf.padroesdeprojeto.observer;

import com.ufjf.padroesdeprojeto.CargaEspecial;
import com.ufjf.padroesdeprojeto.GerenciadorTransporte;
import com.ufjf.padroesdeprojeto.Transporte;
import com.ufjf.padroesdeprojeto.TransporteFactory;
import com.ufjf.padroesdeprojeto.FabricaTransporteEspecial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTransporteTest {
    @Test
    void deveNotificarGerenciadorTransporte() {
        CargaEspecial cargaEspecial = new CargaEspecial(new FabricaTransporteEspecial());
        cargaEspecial.setPeso(2000.0f);

        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciador = new GerenciadorTransporte("GerenciadorTransporteA");
        transporte.setCarga(cargaEspecial);

        gerenciador.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Gerenciador GerenciadorTransporteA: Rastreamento da carga - " + transporte.toString(), gerenciador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGerenciadorTransportes() {
        CargaEspecial cargaEspecial = new CargaEspecial(new FabricaTransporteEspecial());
        cargaEspecial.setPeso(2000.0f);

        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciadorA = new GerenciadorTransporte("GerenciadorTransporteA");
        GerenciadorTransporte gerenciadorB = new GerenciadorTransporte("GerenciadorTransporteB");
        transporte.setCarga(cargaEspecial);

        gerenciadorA.iniciarRastreamento(transporte);
        gerenciadorB.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Gerenciador GerenciadorTransporteA: Rastreamento da carga - " + transporte.toString(), gerenciadorA.getUltimaNotificacao());
        assertEquals("Gerenciador GerenciadorTransporteB: Rastreamento da carga - " + transporte.toString(), gerenciadorB.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarGerenciadorTransporte() {
        CargaEspecial cargaEspecial = new CargaEspecial(new FabricaTransporteEspecial());
        cargaEspecial.setPeso(2000.0f);

        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        GerenciadorTransporte gerenciador = new GerenciadorTransporte("GerenciadorTransporteA");
        transporte.setCarga(cargaEspecial);

        transporte.aguardarColetaCarga();

        assertNull(gerenciador.getUltimaNotificacao());
    }
}
