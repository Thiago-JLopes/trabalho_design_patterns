package com.ufjf.padroesdeprojeto.state;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransporteTest {

    Transporte transporte;

    @BeforeEach
    void setUp() {
        transporte = TransporteFactory.obterTransporte("Normal", "CidadeA", "CidadeB");
        CargaFragil cargaFragil = new CargaFragil(new FabricaTransporteSensivel());
        cargaFragil.setPeso(200000.0f);
        transporte.setCarga(cargaFragil);
    }

    @Test
    void naoDeveConfirmarTransporteCargaJaConfirmado() {
        transporte.setEstado(TransporteEstadoConfirmado.getInstance());
        assertFalse(transporte.confirmarPedidoTransporteCarga());
    }

    @Test
    void naoDeveTransportarSemEstaCarregado() {
        transporte.setEstado(TransporteEstadoConfirmado.getInstance());
        transporte.setEstado(TransporteEstadoEmTransito.getInstance());
        assertFalse(transporte.transportarCarga());
    }

    @Test
    void deveAguardaColeta() {
        transporte.setEstado(TransporteEstadoConfirmado.getInstance());
        assertTrue(transporte.aguardarColetaCarga());
        assertEquals(TransporteEstadoAguardando.getInstance(), transporte.getEstado());
    }

    @Test
    void deveCancelarTransporteEmTransito() {
        transporte.setEstado(TransporteEstadoConfirmado.getInstance());
        transporte.setEstado(TransporteEstadoAguardando.getInstance());
        transporte.setEstado(TransporteEstadoCargaColetada.getInstance());
        transporte.setEstado(TransporteEstadoEmTransito.getInstance());

        assertEquals(TransporteEstadoEmTransito.getInstance(), transporte.getEstado());
        assertTrue(transporte.cancelar());
    }

    @Test
    void naoDeveCancelarTransporteEntregue() {
        transporte.setEstado(TransporteEstadoConfirmado.getInstance());
        transporte.setEstado(TransporteEstadoAguardando.getInstance());
        transporte.setEstado(TransporteEstadoCargaColetada.getInstance());
        transporte.setEstado(TransporteEstadoEmTransito.getInstance());

        transporte.entregarCarga();

        assertEquals(TransporteEstadoEntregue.getInstance(), transporte.getEstado());
        assertFalse(transporte.cancelar());
    }
}