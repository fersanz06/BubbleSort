public class BubbleSort {

    public static void main(String[] args) {
        int[] numeros = {5, 1, 4, 2, 8};

        burbuja(numeros);
    }

    public static void burbuja(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
}
