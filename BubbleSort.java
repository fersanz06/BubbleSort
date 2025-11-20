import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        String rutaEntrada = "numeros.txt";
        String rutaSalida = "numerosBS.txt";

        try {
            int[] numeros = readNumbersFromFile(rutaEntrada);

            System.out.println("Datos originales:");
            System.out.println(Arrays.toString(numeros));

            burbuja(numeros);

            System.out.println("\nArreglo ordenado:");
            System.out.println(Arrays.toString(numeros));

            saveNumbersToFile(numeros, rutaSalida);

            System.out.println("\nArchivo generado en:");
            System.out.println(rutaSalida);

        } catch (IOException e) {
            System.out.println("Error al procesar archivo: " + e.getMessage());
        }
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

    private static int[] readNumbersFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> numbers = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.replace(",", " ");
            String[] parts = line.trim().split("\\s+");

            for (String p : parts) {
                if (!p.isEmpty()) numbers.add(Integer.parseInt(p));
            }
        }

        br.close();

        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) arr[i] = numbers.get(i);

        return arr;
    }

    private static void saveNumbersToFile(int[] arr, String path) throws IOException {
        FileWriter fw = new FileWriter(path);

        for (int num : arr) {
            fw.write(num + " ");
        }

        fw.close();
    }
}