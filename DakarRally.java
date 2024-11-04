import java.util.ArrayList;
import java.util.List;

public class DakarRally {
    private static int operationsCounter = 0;

    public static List<Integer> calculateMininumStops(int L, int d, int[] x) {
        int n = x.length;
        int[] stops = new int[n + 2];
        stops[0] = 0;
        System.arraycopy(x, 0, stops, 1, n);
        stops[n + 1] = L;
        n = stops.length;

        List<Integer> paradas = new ArrayList<>();

        System.out.println("\n\nPontos escolhidos:");
        for (int i = 0; i < n - 1; ) {
            int nextStop = i;

            while (nextStop + 1 < n && stops[nextStop + 1] - stops[i] <= d) {
                nextStop++;
                operationsCounter++;
            }

            if (nextStop == i) {
                return null;
            }

            if (nextStop < n - 1) {
                paradas.add(stops[nextStop]);
                System.out.print(stops[nextStop] + " ");
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