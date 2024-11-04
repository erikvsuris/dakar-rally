import java.util.List;

public class Main {

    public static void main(String[] args) {
        int L;
        int d;
        int x;
        int[] stops;
        int currStop;
        // int L = 300;
        // int d = 20;

        //int[] x = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215, 220, 225, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 290, 295};
        // int[] x = {5, 10, 15, 18, 20, 25, 30, 32, 37, 41, 47, 50, 55, 58, 61, 70, 72, 78, 80, 85, 93, 95, 100, 103,
        //     105, 115, 118, 122, 125, 130, 138, 140, 143, 148, 151, 160, 163, 169, 170, 175, 184, 185,
        //     190, 193, 198, 205, 208, 215, 215, 220, 229, 230, 235, 238, 246, 250, 253, 260, 262, 265,
        //     275, 277, 280, 283, 291};

        for (int i = 1; i <= 10; i++) {
            System.out.println("\f\n\nCaso de Teste " + i);

            L = i * 100;
            d = i * 5;
            x = i * 10;
            stops = new int[x];
            currStop = 0;

            System.out.printf("L = %d\nd = %d\nx = %d\n", L, d, x);

            System.out.println();
            for (int j = 0; j < x; j++) {
                int rand = (int) (Math.random() * d) + 1;
                currStop += rand;
                if (currStop >= L) break;

                stops[j] = currStop;
                System.out.print(currStop + " ");
            }
    
            long startTime = System.nanoTime();
            List<Integer> choosenStops = DakarRally.calculateMininumStops(L, d, stops);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            
            if (choosenStops != null) {
                System.out.println("\nChoosen Stops: \n" + choosenStops);
            } else {
                System.out.println("Não é possível completar o rally com as condições dadas.");
            }
    
            System.out.println("Tempo de execução: " + executionTime + " nanosegundos");
            System.out.println("Número de operações: " + DakarRally.getOperationsCounter());
        }
    }
}
