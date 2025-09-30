//Sarah dos Santos Oliveira
import java.util.*;

public class trabalhoAEDsII {

    public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

    // Quicksort para utilizar o primeiro elemento do array como pivo
    static void QuicksortFirstPivot(int[] array, int left, int right) {

        int i = left, j = right;
        int pivo = array[left];

        while (i <= j) 
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) 
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j)  QuicksortFirstPivot(array, left, j);
        if (i < right)  QuicksortFirstPivot(array, i, right);
    }

    // Quicksort para utilizar o ultimo elemento do array como pivo
    static void QuicksortLastPivot(int[] array, int left, int right) {

        int i = left, j = right;
        int pivo = array[right];

        while (i <= j) 
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) 
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j) QuicksortLastPivot(array, left, j);
        if (i < right) QuicksortLastPivot(array, i, right);
    }

    // Quicksort para utilizar um elemento aleatorio do array como pivo
    static void QuicksortRandomPivot(int[] array, int left, int right) {

        Random gerador = new Random();

        int i = left, j = right;
        int posRandomica = left + gerador.nextInt(right - left + 1);
        int pivo = array[posRandomica];

        while (i <= j) 
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) 
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j) QuicksortRandomPivot(array, left, j);
        if (i < right) QuicksortRandomPivot(array, i, right);
    }

    // Quicksort para utilizar a media de tres elementos do array como pivo
    static void QuicksortMedianOfThree(int[] array, int left, int right) {

        int i = left, j = right;
        int val1 = array [(right + left)/2];
        int val2 = array[left];
        int val3 = array[right];
        int pivo;

        if(val1 >= val2 && val1 <= val3) 
            pivo = val1;

        else if(val2 >= val1 && val2 <= val3) 
            pivo = val2;

        else 
            pivo = val3;

        while (i <= j) 
        {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) 
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j) QuicksortMedianOfThree(array, left, j);
        if (i < right) QuicksortMedianOfThree(array, i, right);
    }

    public static void main(String[] args) {

       // Random aleatorio = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long tempoInicio = System.currentTimeMillis();

        QuicksortMedianOfThree(array, 0, array.length - 1);

        long tempoFim = System.currentTimeMillis();

        double duracao = (tempoFim - tempoInicio) / 1000.0;

        System.out.println("\nDuracao para ordenar: " + duracao + "s");
    }
}
