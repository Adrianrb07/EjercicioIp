package EvaluacionesPracticas.EvaluacionPractica3.EjercicioIp.rede;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedeTest {
    @Test
    public void validarIP() {
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

    @Test
    public void buscarIP() {
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

    @Test
    public void validarMascara() {
        //Pruebas en el primer octeto
        assertTrue(Rede.validarMascara("255.0.0.0"));
        assertTrue(Rede.validarMascara("254.0.0.0"));
        assertTrue(Rede.validarMascara("252.0.0.0"));
        assertTrue(Rede.validarMascara("192.0.0.0"));
        assertFalse(Rede.validarMascara("256.0.0.0"));
        assertFalse(Rede.validarMascara("194.0.0.0"));
        assertFalse(Rede.validarMascara("10.0.0.0"));
        assertFalse(Rede.validarMascara("20.0.0.0"));
        assertFalse(Rede.validarMascara("0.0.0.0"));

        //Pruebas en el segundo octeto
        assertTrue(Rede.validarMascara("255.255.0.0"));
        assertTrue(Rede.validarMascara("255.254.0.0"));
        assertTrue(Rede.validarMascara("255.252.0.0"));
        assertTrue(Rede.validarMascara("255.192.0.0"));
        assertFalse(Rede.validarMascara("255.256.0.0"));
        assertFalse(Rede.validarMascara("255.194.0.0"));
        assertFalse(Rede.validarMascara("255.10.0.0"));
        assertFalse(Rede.validarMascara("255.20.0.0"));

        //Pruebas en el tercer octeto
        assertTrue(Rede.validarMascara("255.255.255.0"));
        assertTrue(Rede.validarMascara("255.255.254.0"));
        assertTrue(Rede.validarMascara("255.255.252.0"));
        assertTrue(Rede.validarMascara("255.255.128.0"));
        assertFalse(Rede.validarMascara("255.255.197.0"));
        assertFalse(Rede.validarMascara("255.255.8.0"));
        assertFalse(Rede.validarMascara("255.255.25.0"));
        assertFalse(Rede.validarMascara("255.255.250.0"));

        //Pruebas en el cuarto octeto
        assertTrue(Rede.validarMascara("255.255.255.255"));
        assertTrue(Rede.validarMascara("255.255.255.254"));
        assertTrue(Rede.validarMascara("255.255.255.192"));
        assertTrue(Rede.validarMascara("255.255.255.128"));
        assertFalse(Rede.validarMascara("255.255.255.127"));
        assertFalse(Rede.validarMascara("255.255.255.257"));
        assertFalse(Rede.validarMascara("255.255.255.194"));
    }
}