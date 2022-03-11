package EvaluacionesPracticas.EvaluacionPractica3.rede;

import static org.junit.jupiter.api.Assertions.*;

class RedeTest {
    @org.junit.jupiter.api.Test
    public void validarIP(){
        assertTrue(Rede.validarIP("192.168.0.9"));
        assertTrue(Rede.validarIP("192.168.100.0"));
        assertTrue(Rede.validarIP("255.255.255.255"));
        assertTrue(Rede.validarIP("0.0.0.0"));
        assertTrue(Rede.validarIP("255.0.0.0"));
        assertFalse(Rede.validarIP(""));
        assertFalse(Rede.validarIP("192 .168.0.9"));
        assertFalse(Rede.validarIP("002.168.0.9"));
        assertFalse(Rede.validarIP("192.002.0.9"));
        assertFalse(Rede.validarIP("192.168.00.9"));
        assertFalse(Rede.validarIP("192.168..9"));
        assertFalse(Rede.validarIP("192.168:0.9"));
        assertFalse(Rede.validarIP("192.168.0.009"));
        assertFalse(Rede.validarIP("192.168.0.9."));
        assertFalse(Rede.validarIP("256.0.0.0"));
        assertFalse(Rede.validarIP("192.16x.0.9"));
        assertFalse(Rede.validarIP(".192.168.0.9"));
        assertFalse(Rede.validarIP(""));
        assertFalse(Rede.validarIP("255.256.0.0"));
        assertFalse(Rede.validarIP("..."));

    }

    @org.junit.jupiter.api.Test
    public void buscarIP(){
        String[] ips = {"192.168.0.9", "192.168.100.0", "255.255.255.255", "0.0.0.0"};
        String[] vacio = new String[0];
        assertEquals(Rede.buscarIP("192.168.0.9", ips), 0);
        assertEquals(Rede.buscarIP("192.168.100.0", ips), 1);
        assertEquals(Rede.buscarIP("255.255.255.255", ips), 2);
        assertEquals(Rede.buscarIP("0.0.0.0", ips), 3);
        assertEquals(Rede.buscarIP("192.168.100.9", ips), -1);
        assertEquals(Rede.buscarIP("192.168.0.009", ips), -1);
        assertEquals(Rede.buscarIP("", ips), -1);
        assertEquals(Rede.buscarIP("0.0.0.0", vacio), -1);
    }

}