package com.ufjf.padroesdeprojeto.command;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransporteCommandTest {

    private Transporte transporte;
    private TransporteInvoker invoker;

    @BeforeEach
    void setUp() {
        transporte = TransporteFactory.obterTransporte("Expresso", "CidadeA", "CidadeB");
        invoker = new TransporteInvoker();
    }

    @Test
    void deveExecutarEdesfazerColetarCarga() {
        transporte.aguardarColetaCarga();
        ColetarCargaCommand coletarCarga = new ColetarCargaCommand(transporte);
        invoker.executarComando(coletarCarga);
        assertEquals("Carga Coletada", transporte.getNomeEstado());

        invoker.desfazerUltimoComando();
        assertEquals("Aguardando Coletada da Carga", transporte.getNomeEstado());
    }

    @Test
    void deveExecutarEdesfazerTransportarCarga() {
        transporte.aguardarColetaCarga();
        transporte.coletarCarga();

        TransportarCargaCommand transportarCarga = new TransportarCargaCommand(transporte);
        invoker.executarComando(transportarCarga);
        assertEquals("Em Transito", transporte.getNomeEstado());

        invoker.desfazerUltimoComando();
        assertEquals("Carga Coletada", transporte.getNomeEstado());
    }

    @Test
    void deveExecutarEdesfazerEntregarCarga() {
        transporte.aguardarColetaCarga();
        transporte.coletarCarga();
        transporte.transportarCarga();

        EntregarCargaCommand entregarCarga = new EntregarCargaCommand(transporte);
        invoker.executarComando(entregarCarga);
        assertEquals("Entregue", transporte.getNomeEstado());

        invoker.desfazerUltimoComando();
        assertEquals("Em Transito", transporte.getNomeEstado());
    }

}