package EvaluacionesPracticas.EvaluacionPractica3.EjercicioIp.rede;

import java.util.Arrays;
import java.util.Objects;

public class Rede {

    public static boolean validarIP(String ip) {
        String ipCorrecta = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
        return ip.matches(ipCorrecta);
    }

    public static boolean validarMascara(String mascara) {
        boolean mask = false;
        String oct1 = "(128)?(192)?(224)?(240)?(248)?(252)?(254)?(255)?\\.0\\.0\\.0";
        String oct2 = "255\\.(128)?(192)?(224)?(240)?(248)?(252)?(254)?(255)?\\.0\\.0";
        String oct3 = "255\\.255\\.(128)?(192)?(224)?(240)?(248)?(252)?(254)?(255)?\\.0";
        String oct4 = "255\\.255\\.255\\.(128)?(192)?(224)?(240)?(248)?(252)?(254)?(255)?";
        if (mascara.matches(oct1)) {
            mask = true;
        } else if (mascara.matches(oct2)) {
            mask = true;
        } else if (mascara.matches(oct3)) {
            mask = true;
        } else if (mascara.matches(oct4)) {
            mask = true;
        }
        return mask;
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

    /* public static boolean validarIP(String ip) {
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
        }*/

    /*public static boolean validarMascara(String mascara) {
        boolean ipOk = validarIP(mascara);
        boolean mascaraOk = false;
        String[] aux = mascara.split("\\.");
        String[] valores = {"128", "192", "224", "240", "248", "252", "254", "255"};

        if (ipOk) {
            mascaraOk = octeto1Ok(mascara);
            if (aux[0].equals("255") && !Objects.equals(aux[1], "0")) {
                mascaraOk = octeto2Ok(mascara);

            }

            if (aux[0].equals("255") && aux[1].equals("255") && !Objects.equals(aux[2], "0")) {
                mascaraOk = octeto3Ok(mascara);

            }

            if (aux[0].equals("255") && aux[1].equals("255") && aux[2].equals("255") && !Objects.equals(aux[3], "0")) {
                mascaraOk = octeto4Ok(mascara);
            }
        }

        return mascaraOk;

    }

    public static boolean octeto1Ok(String mascara) {
        boolean octetoOk = false;
        String[] aux = mascara.split("\\.");
        String[] valores = {"128", "192", "224", "240", "248", "252", "254", "255"};
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (aux[0].contains(valores[j])) {
                    octetoOk = true;
                }
            }
        }

        if (octetoOk && Objects.equals(aux[1], "0") && Objects.equals(aux[2], "0")
                     && Objects.equals(aux[3], "0")) {
            octetoOk = true;

        }
        return octetoOk;
    }

    public static boolean octeto2Ok(String mascara) {
        boolean octetoOk = false;
        String[] aux = mascara.split("\\.");
        String[] valores = {"128", "192", "224", "240", "248", "252", "254", "255"};
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (aux[1].contains(valores[j])) {
                    octetoOk = true;
                }
            }
        }
        if (Objects.equals(aux[0], "255") && octetoOk &&
                Objects.equals(aux[2], "0") && Objects.equals(aux[3], "0")) {
            octetoOk = true;

        }
        return octetoOk;
    }

    public static boolean octeto3Ok(String mascara) {
        boolean octetoOk = false;
        String[] aux = mascara.split("\\.");
        String[] valores = {"128", "192", "224", "240", "248", "252", "254", "255"};
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (aux[2].contains(valores[j])) {
                    octetoOk = true;
                }
            }
        }
        if (Objects.equals(aux[0], "255") && Objects.equals(aux[1], "255") &&
                octetoOk && Objects.equals(aux[3], "0")) {
            octetoOk = true;

        }
        return octetoOk;
    }

    public static boolean octeto4Ok(String mascara) {
        boolean octetoOk = false;
        String[] aux = mascara.split("\\.");
        String[] valores = {"128", "192", "224", "240", "248", "252", "254", "255"};
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (aux[3].contains(valores[j])) {
                    octetoOk = true;
                }
            }
        }
        if (Objects.equals(aux[0], "255") && Objects.equals(aux[1], "255") &&
                Objects.equals(aux[3], "255") && octetoOk) {
            octetoOk = true;

        }
        return octetoOk;
    }*/

    static boolean cerosIzquierda(String aux) {
        boolean octCorrecto = true;
        for (int i = 0; i < aux.length() - 1; i++) {
            if (aux.charAt(0) == '0') {
                octCorrecto = false;
            }
        }
        return octCorrecto;
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
