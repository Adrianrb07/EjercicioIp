package EvaluacionesPracticas.EvaluacionPractica3.rede;

import java.util.Objects;

public class Rede {

    public static boolean validarIP(String ip) {
        String[] aux = ip.split("\\.");
        boolean ipCorrecta;

        try {
            //Paso cada string de octetos a enteros
            int octeto1 = Integer.parseInt(aux[0]);
            int octeto2 = Integer.parseInt(aux[1]);
            int octeto3 = Integer.parseInt(aux[2]);
            int octeto4 = Integer.parseInt(aux[3]);

            //Compruebo que los rangos de los octetos de la dirección ip son correctos
            if ((octeto1 >= 0 && octeto1 <= 255) && (octeto2 >= 0 && octeto2 <= 255 &&
                (octeto3 >= 0 && octeto3 <= 255 && (octeto4 >= 0 && octeto4 <= 255)))) {
                ipCorrecta = true;
            } else {
                ipCorrecta = false;
            }

            for (int i = 0; i < 4; i++) {
                if (!cerosIzquierda(aux[i])) {
                    ipCorrecta = false;
                }
            }

            if (!cuentaPuntos(ip)) {
                ipCorrecta = false;
            }

        } catch (Exception e) {
            ipCorrecta = false;
        }

        return ipCorrecta;
    }

    static boolean cerosIzquierda(String aux) {
        boolean octCorrecto = true;
        for (int i = 0; i < aux.length()-1; i++) {
            if (aux.charAt(0) == '0') {
                octCorrecto = false;
            }
        }
        return octCorrecto;
    }

    public static int buscarIP(String ip, String[] ips) {
        int i = 0;
        boolean encontrado = false;

        while (i < ips.length && !encontrado) {
            if (Objects.equals(ips[i], ip)) {
                encontrado = true;
            }
            i++;
        }

        if (encontrado) {
            return i - 1;
        } else {
            return -1;
        }
    }

    public static boolean cuentaPuntos(String cad) {
        boolean puntosOk = true;
        int cuentaPuntos = 0;
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) == '.') {
                cuentaPuntos++;
            }
        }

        if (cuentaPuntos != 3) {
            puntosOk = false;
        }
        return puntosOk;
    }

}
