import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\f");

        int L = 0;
        int d = 0;
        int x = 0;

        int[] rallyStops;
        List<Integer> choosenStopPoints;

        long startTime;
        long endTime;
        long totalExecutionTime = 0;
        long meanExecutionTime;
        int numberOfTests = 5;
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nCaso de Teste " + i);
            
            L = i * 100;
            d = i * 10;
            x = i * 20;
    
            System.out.println("L = " + L);
            System.out.println("d = " + d);
            System.out.println("x = " + x);
            
            rallyStops = generateRallyStopPoints(L, d, x);
            
            System.out.print("\nPontos de Parada Criados: ");
            for (int stop : rallyStops) {
                System.out.print(stop + " ");
            }

            choosenStopPoints = null;
            totalExecutionTime = 0;

            for (int j = 0; j < numberOfTests; j++) {
                DakarRally.getOperationsCounter();
                startTime = System.nanoTime();
                choosenStopPoints = DakarRally.calculateMininumStops(L, d, rallyStops);
                endTime = System.nanoTime();
                totalExecutionTime += (endTime - startTime);
            }

            meanExecutionTime = totalExecutionTime / numberOfTests;
            
            if (choosenStopPoints != null) {
                System.out.println("\nPontos de Parada Escolhidos: " + choosenStopPoints);
            } else {
                System.out.println("\nNão é possível completar o rally com os pontos de parada fornecidos.");
            }
    
            System.out.println("Tempo Médio de execução: " + meanExecutionTime + " ns");
            System.out.println("Número de operações: " + DakarRally.getOperationsCounter());
        }
    }

    public static int[] generateRallyStopPoints(int L, int d, int x) {
        if (L <= 0 || d <= 0 || x <= 0)
            throw new IndexOutOfBoundsException();

        int[] rallyStopPoints = new int[x];
        
        int interval = L / x;
        int rand;
        
        for (int i = 0; i < x - 1; i++) {
            rand = (int) (Math.random() * interval) + 1;
            rallyStopPoints[i] = (interval * i) + rand;
        }

        rallyStopPoints[x - 1] = rallyStopPoints[x - 2] + 1;

        return rallyStopPoints;
    }
}
