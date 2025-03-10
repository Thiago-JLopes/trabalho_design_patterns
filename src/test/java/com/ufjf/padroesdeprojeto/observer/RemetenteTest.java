package com.ufjf.padroesdeprojeto.observer;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemetenteTest {
    @Test
    void deveNotificarRemetente() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Remetente remetente = new Remetente("RemetenteA");
        transporte.setCarga(CargaEspecial.getInstance());

        remetente.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Remetente RemetenteA: Rastreamento da carga - " + transporte.toString(), remetente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarRemetentes() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Remetente remetenteA = new Remetente("RemetenteA");
        Remetente remetenteB = new Remetente("RemetenteB");
        transporte.setCarga(CargaEspecial.getInstance());

        remetenteA.iniciarRastreamento(transporte);
        remetenteB.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Remetente RemetenteA: Rastreamento da carga - " + transporte.toString(), remetenteA.getUltimaNotificacao());
        assertEquals("Remetente RemetenteB: Rastreamento da carga - " + transporte.toString(), remetenteB.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarRemetente() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Remetente remetente = new Remetente("RemetenteA");
        transporte.setCarga(CargaEspecial.getInstance());

        transporte.aguardarColetaCarga();

        assertNull(remetente.getUltimaNotificacao());
    }
}