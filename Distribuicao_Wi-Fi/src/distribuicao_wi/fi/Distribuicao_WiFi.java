package distribuicao_wi.fi;

import java.util.Random;

/**
 * @author Eduardo Sales e-mail eduardosallis30@gmail.com
 *
 */
public class Distribuicao_WiFi {

    int numero_Pontos = 500;

    int[] eixoX = new int[numero_Pontos];
    int[] eixoY = new int[numero_Pontos];
    double[] resultado = new double[numero_Pontos];

    int[] roteador = {60, 50};
    int alcance_Roteador = 50;

    int soma = 0;
    int result;
    int alcance;
    double raiz;

    public static void main(String[] args) {

        new Distribuicao_WiFi().valores_Aleatorio();

    }

    void valores_Aleatorio() {

        Random Aleatorio = new Random();

        for (int i = 0; i < eixoX.length; i++) {

            eixoX[i] = Aleatorio.nextInt(500);
            eixoY[i] = Aleatorio.nextInt(500);
            //System.out.println(eixoX[i]+"   " + eixoY[i]);
        }
        calculo_Distancia();
    }

    public void calculo_Distancia() {

        for (int i = 0; i < eixoX.length; i++) {

            result = (int) ((int) Math.pow(eixoX[i] - roteador[0], 2) + Math.pow(eixoY[i] - roteador[1], 2));

            raiz = Math.sqrt(result);
            resultado[i] = raiz;

        }

        valor();

    }

    public void valor() {
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i] < alcance_Roteador) {
                alcance += 1;
            }

        }

        System.out.println("Numero de pontos: " + numero_Pontos);
        System.out.println("Numero de pontos alcançados: " + alcance);

    }
}
