package com.ufjf.padroesdeprojeto.observer;

import com.ufjf.padroesdeprojeto.CargaEspecial;
import com.ufjf.padroesdeprojeto.Destinatario;
import com.ufjf.padroesdeprojeto.Transporte;
import com.ufjf.padroesdeprojeto.TransporteFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DestinatarioTest {

    @Test
    void deveNotificarDestinatario() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Destinatario destinatario = new Destinatario("DestinatarioA");
        transporte.setCarga(CargaEspecial.getInstance());

        destinatario.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Destinatário DestinatarioA: Rastreamento da carga - " + transporte.toString(), destinatario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDestinatarios() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Destinatario destinatarioA = new Destinatario("DestinatarioA");
        Destinatario destinatarioB = new Destinatario("DestinatarioB");
        transporte.setCarga(CargaEspecial.getInstance());

        destinatarioA.iniciarRastreamento(transporte);
        destinatarioB.iniciarRastreamento(transporte);
        transporte.aguardarColetaCarga();

        assertEquals("Destinatário DestinatarioA: Rastreamento da carga - " + transporte.toString(), destinatarioA.getUltimaNotificacao());
        assertEquals("Destinatário DestinatarioB: Rastreamento da carga - " + transporte.toString(), destinatarioB.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarDestinatario() {
        CargaEspecial.getInstance().setPeso(2000.0f);
        Transporte transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        Destinatario destinatario = new Destinatario("DestinatarioA");
        transporte.setCarga(CargaEspecial.getInstance());

        transporte.aguardarColetaCarga();

        assertNull(destinatario.getUltimaNotificacao());
    }
}