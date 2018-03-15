package Tarefa2;

/**
 *
 * @author Carlinhos
 */
public class MergeSort {

    public int[] mergeSort(int[] vetor, int indiceInicio, int indiceFim) {
        long tempoInicial, tempoFinal;

        tempoInicial = System.currentTimeMillis();

        this.ordena(vetor, indiceInicio, indiceFim);

        tempoFinal = System.currentTimeMillis();
        System.out.println("MergeSort:\nTempo de Ordenação = " + 
                (tempoFinal - tempoInicial) + " milisegundo(s)");
        return vetor;
    }

    /**
     * Recebe um vetor com informações adicionais de seu início e fim
     *
     * @param vetor
     * @param indiceInicio
     * @param indiceFim
     * @return
     */
    private int[] ordena(int[] vetor, int indiceInicio, int indiceFim) {

        /**
         * Verifica algumas condições inicias do vetor. o vetor não pode ser
         * nulo; o inidceInicio tem que ser menor que o IndiceFim; o
         * indiceInicio tem que ser maior ou igual a zero; o tamanho o vetor tem
         * que ser diferente de 0
         */
        if (vetor != null
                && indiceInicio < indiceFim
                && indiceInicio >= 0
                && indiceFim < vetor.length
                && vetor.length != 0) {

            // calcula o meio do vetor
            int meio = ((indiceFim + indiceInicio) / 2);

            // Divide o vetor ao meio, e para cada parte, chama
            // recursivamente o método ordena
            ordena(vetor, indiceInicio, meio);
            ordena(vetor, meio + 1, indiceFim);

            merge(vetor, indiceInicio, meio, indiceFim);
        }

        return vetor;
    }

    /**
     * O merge consiste na junção de duas listas já ordenadas. Usa um array
     * auxiliar.
     *
     * @param vetor
     * @param indiceInicio
     * @param meio
     * @param indiceFim
     */
    private void merge(int[] vetor, int indiceInicio, int meio, int indiceFim) {
        // cria um vetor auxiliar
        int[] auxiliar = new int[vetor.length];

        //Copiando o trecho da lista que vai ser ordenada
        for (int i = indiceInicio; i <= indiceFim; i++) {
            auxiliar[i] = vetor[i];
        }

        //Índices auxiliares
        int i = indiceInicio;
        int j = meio + 1;
        int k = indiceInicio;

        /**
         * Junção das listas ordenadas compara se o indice i é menor ou igual ao meio e
         * o se o indice j é menor ou igual ao fim; se sim, compara se elemento auxiliar[i]
         * é menor que o elemento auxiliar[j] e atribua o menor valor ao elemento vetor[k],
         * incrementando o k e o i ou o j;
         */
        while (i <= meio && j <= indiceFim) {
            if (auxiliar[i] < auxiliar[j]) {
                vetor[k] = auxiliar[i];
                i++;
            } else {
                vetor[k] = auxiliar[j];
                j++;
            }
            k++;
        }

        //Anexa os itens que não foram usados na Junção
        while (i <= meio) {
            vetor[k] = auxiliar[i];
            i++;
            k++;
        }

        //Anexa de itens que não foram usados na Junção
        while (j <= indiceFim) {
            vetor[k] = auxiliar[j];
            j++;
            k++;
        }
    }
}
