package Tarefa2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlinhos
 */
public class tarefa2Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        String path = "src/Tarefa2/vetor.txt";

        int[] vetor = lerDados(path);

        System.out.println("Vetor original com " + vetor.length + " posições.");
        imprimir(vetor);

        System.out.println("\n-------------------------------\n");

        vetor = lerDados(path);
        imprimir(quickSort.sort(vetor));

        System.out.println("\n-------------------------------\n");

        vetor = lerDados(path);
        imprimir(mergeSort.mergeSort(vetor, 0, vetor.length - 1));

        System.out.println("\n-------------------------------\n");
    }

    public static void imprimir(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
//            System.out.print(vetor[i] + ", ");
            if ((i + 1) % 20 == 0) {
//                System.out.println("");
            }
        }

    }

    public static int[] lerDados(String path) {
        ArrayList<Integer> lista = null;

        // ler a entrada de dados do aquivo Dados.txt
        try {
            Scanner input = new Scanner(new File(path));
            int aux2;
            lista = new ArrayList<>();

            while (input.hasNextLine()) {
                aux2 = input.nextInt();
                lista.add(aux2);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("1 - Erro ao ler o arquivo.");
        }

        // transformando um arrayList em um vetor de inteiros
        int[] vetor = new int[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i);
        }

        return vetor;
    }

}
