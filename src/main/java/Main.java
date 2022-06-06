import java.util.Scanner;

public class Main {

    public static final DataModule dataModule = new DataModule(new Scanner(System.in));
    public static Knapsack knapsack = new Knapsack();

    public static void main(String[] args) {

        System.out.println("Dynamic: ");
        knapsack.knapsackDP(dataModule.weights, dataModule.values, dataModule.size, dataModule.n);
        knapsack.knapsackGR(dataModule.weights, dataModule.values, dataModule.size, dataModule.n);
        knapsack.knapsackFA(dataModule.weights, dataModule.values, dataModule.n, dataModule.size);
        System.out.println("Brutal Force: ");
        knapsack.knapsackDP(dataModule.weights, dataModule.values, dataModule.size, dataModule.n);


    }
}
