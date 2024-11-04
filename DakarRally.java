import java.util.ArrayList;
import java.util.List;

public class DakarRally {
    private static int operationsCounter = 0;

    public static List<Integer> calculateMininumStops(int L, int d, int[] x) {
        if (L <= 0 || d <= 0 || x == null || x.length == 0) 
            throw new IndexOutOfBoundsException();

        int n = x.length;
        int[] pontos = new int[n + 2];
        pontos[0] = 0;
        System.arraycopy(x, 0, pontos, 1, n);
        pontos[n + 1] = L;
        n = pontos.length;

        List<Integer> paradas = new ArrayList<>();

        for (int i = 0; i < n - 1; ) {
            int nextStop = i;

            while (nextStop + 1 < n && pontos[nextStop + 1] - pontos[i] <= d) {
                nextStop++;
                operationsCounter++;
            }

            if (nextStop == i) {
                return null;
            }

            if (nextStop < n - 1) {
                paradas.add(pontos[nextStop]);
            }

            i = nextStop;
        }

        return paradas;
    }

    public static int getOperationsCounter() {
        int aux = operationsCounter;
        operationsCounter = 0;
        return aux;
    }
}