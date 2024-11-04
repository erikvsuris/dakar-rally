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
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nCaso de Teste " + i);
            
            L = i * 100;
            d = i * 5;
            x = i * 10;
    
            System.out.println("L = " + L);
            System.out.println("d = " + d);
            System.out.println("x = " + x);
            
            rallyStops = generateRallyStopPoints(L, d, x);

            for (int stop : rallyStops) {
                System.out.print(stop + " ");
            }

            choosenStopPoints = null;
            totalExecutionTime = 0;
            
            for (int j = 0; j < 10; j++) {
                startTime = System.nanoTime();
                choosenStopPoints = DakarRally.calculateMininumStops(L, d, rallyStops);
                endTime = System.nanoTime();
                totalExecutionTime += (endTime - startTime);
            }

            meanExecutionTime = totalExecutionTime / 10;
            
            if (choosenStopPoints != null) {
                System.out.println("\nChoosen Stops: " + choosenStopPoints);
            } else {
                System.out.println("\nNão é possível completar o rally com as condições dadas.");
            }
    
            System.out.println("Tempo Médio de execução: " + meanExecutionTime + " ms");
            System.out.println("Número de operações: " + DakarRally.getOperationsCounter());
        }
    }

    public static int[] generateRallyStopPoints(int L, int d, int x) {
        int[] rallyStopPoints = new int[x];
        
        int interval = L / x;
        int rand;
        
        for (int i = 0; i < x; i++) {
            rand = (int) (Math.random() * interval) + 1;
            System.out.print(rand + " ");
            rallyStopPoints[i] = (interval * i) + rand;
        }

        return rallyStopPoints;
    }
}
