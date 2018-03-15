/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefa2;

/**
 *
 * @author Carlinhos
 */
public class QuickSort {

    private int[] vetor;
    private int numero;

    public int[] sort(int[] vetor) {

        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();

        // Verifica se o vetor é nulo ou está vazio
        if (vetor == null || vetor.length == 0) {
            return null;
        }
        this.vetor = vetor;
        numero = vetor.length;
        quicksort(0, numero - 1);

        tempoFinal = System.currentTimeMillis();
        System.out.println("QuickSort:\nTempo de Ordenação = " + 
                (tempoFinal - tempoInicial) + " milisegundo(s)");
        return vetor;
    }

    private void quicksort(int inicio, int fim) {
        int pivo, i = inicio, j = fim;

        // Escolhendo um elemento como pivo (existe várias formas de escolha)
        pivo = vetor[inicio + (fim - inicio) / 2]; // no caso o pivo é o meio da lista
//        pivo = vetor[inicio]; // neste caso, o pivo é o primeiro da lista

        // Dividindo o vetor em dois
        while (i <= j) {
            // se o elemento da esquerda for menor que o pivo, 
            // incremente o índice que percorre o vetor da esquerda
            while (vetor[i] < pivo) {
                i++;
            }
            // se o elemento da direita for maior que o pivo, 
            // decremente o índice que percorre o vetor da direita
            while (vetor[j] > pivo) {
                j--;
            }

            // Se encontrarmos um valor na lista à esquerda que é maior que o 
            // elemento pivô e se encontrarmos um valor na lista certa que é 
            // menor do que o elemento pivô, então troque os valores de posição.
            // Depois incremente o índice da esquerda e decremente o da direira
            if (i <= j) {
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                i++;
                j--;
            }
        }
        // Chama o método recursivamente, para o vetor da esquerda
        if (inicio < j) {
            quicksort(inicio, j);
        }

        // Chama o método recursivamente, para o vetor da direita
        if (i < fim) {
            quicksort(i, fim);
        }
    }

//    private void exchange(int i, int j) {
//        int temp = vetor[i];
//        vetor[i] = vetor[j];
//        vetor[j] = temp;
//    }
}
