package distribuicao_wi.fi;

import java.util.Random;

/**
 * @author Eduardo Sales e-mail eduardosallis30@gmail.com
 */
public class Distribuicao_WiFi {

    int tamanho_Vetor = 1000;

    int alcance;

    int[] eixoX = new int[tamanho_Vetor];
    int[] eixoY = new int[tamanho_Vetor];
    double[] resultado = new double[tamanho_Vetor];

    int[] roteador = {400, 400};
    int alcance_Roteador = 100;

    int valor_Aleatorio = 800;

    int soma = 0;
    int result;

    double raiz;

    public static void main(String[] args) {

        new Distribuicao_WiFi().criar_Populacao();

    }

    void criar_Populacao() {

        Random Aleatorio = new Random();

        for (int i = 0; i < eixoX.length; i++) {

            eixoX[i] = Aleatorio.nextInt(valor_Aleatorio);
            eixoY[i] = Aleatorio.nextInt(valor_Aleatorio);
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

        comparar_distancia();

    }

    public void comparar_distancia() {
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i] < alcance_Roteador) {
                alcance += 1;
            }

        }

        System.out.println("Numero de pontos: " + tamanho_Vetor);
        System.out.println("Numero de pontos alcançados: " + alcance);

    }

}
