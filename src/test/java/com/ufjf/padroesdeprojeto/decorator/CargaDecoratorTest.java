package com.ufjf.padroesdeprojeto.decorator;

import com.ufjf.padroesdeprojeto.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CargaDecoratorTest {
    @Test
    void deveRetornarCustoBaseDaCarga() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setPeso(500.0f);

        assertEquals(750.0f, carga.getCustoTransporte());
    }

    @Test
    void deveRetornarCustoComEscolta() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setPeso(500.0f);
        carga = new Escolta(carga);

        assertEquals(862.5f, carga.getCustoTransporte());
    }

    @Test
    void deveRetornarCustoComSeguro() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setPeso(500.0f);
        carga = new Seguro(carga);

        assertEquals(825.0f, carga.getCustoTransporte());
    }

    @Test
    void deveRetornarCustoComEscoltaESeguro() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setPeso(500.0f);
        carga = new Escolta(carga);
        carga = new Seguro(carga);

        assertEquals(948.75f, carga.getCustoTransporte());
    }

    @Test
    void deveRetornarDescricaoComEscolta() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setProduto("Produtos Químicos");
        carga = new Escolta(carga);

        assertEquals("Carga Especial\nProduto: Produtos Químicos\nTransporte com requisitos específicos.\nEscolta Armada: Ativa", carga.getDescricao());
    }

    @Test
    void deveRetornarDescricaoComSeguro() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setProduto("Produtos Químicos");
        carga = new Seguro(carga);

        assertEquals("Carga Especial\nProduto: Produtos Químicos\nTransporte com requisitos específicos.\nSeguro: Ativo", carga.getDescricao());
    }

    @Test
    void deveRetornarDescricaoComEscoltaESeguro() {
        FabricaAbstrata fabrica = new FabricaTransporteEspecial();
        Carga carga = new CargaEspecial(fabrica);
        carga.setProduto("Produtos Químicos");
        carga = new Escolta(carga);
        carga = new Seguro(carga);

        assertEquals("Carga Especial\nProduto: Produtos Químicos\nTransporte com requisitos específicos.\nEscolta Armada: Ativa\nSeguro: Ativo", carga.getDescricao());
    }
}