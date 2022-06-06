import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {

    public void knapsackDP(int[] W, int[] V, int M, int n) {
        int[][] B = new int[n + 1][M + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= M; j++) {
                B[i][j] = 0;
            }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                B[i][j] = B[i - 1][j];

                if ((j >= W[i - 1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) {
                    B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1];
                }
            }
        }

        while (n != 0) {
            if (B[n][M] != B[n - 1][M]) {
                System.out.println("\tPackage " + n + " with W = " + W[n - 1] + " and Value = " + V[n - 1]);

                M = M - W[n - 1];
            }

            n--;
        }

    }


    public void knapsackGR(int[] W, int[] V, int M, int n) {
        KnapsackPackage[] packs = new KnapsackPackage[n];
        for (int i = 0; i < n; i++) {
            packs[i] = new KnapsackPackage(W[i], V[i], i + 1);
        }

        List<KnapsackPackage> knapsacks = Arrays.stream(packs).sorted(Comparator.comparing(KnapsackPackage::getCost).reversed()).collect(Collectors.toList());
        List<KnapsackPackage> result = new ArrayList<>();
        int max = 0;
        int i = 0;
        while (max < M && knapsacks.size() > i) {
            if (max + knapsacks.get(i).getWeight() <= M) {
                max += knapsacks.get(i).getWeight();
                result.add(knapsacks.get(i));
            }
            i++;
        }
        System.out.println("Greedy");
        result.forEach(s -> System.out.println("\tPackage " + s.getId() + " with W = " + s.getWeight() + " and Value = " + s.getValue() + " and Cost = " + s.getCost()));

    }

    int knapsackFA(int[] w, int[] v, int n, int W) {
        if (n <= 0) {
            return 0;
        } else if (w[n - 1] > W) {
            return knapsackFA(w, v, n - 1, W);
        } else {
            return Math.max(knapsackFA(w, v, n - 1, W), v[n - 1]
                    + knapsackFA(w, v, n - 1, W - w[n - 1]));
        }
    }

}

