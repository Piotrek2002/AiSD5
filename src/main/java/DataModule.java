import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataModule {
    int size;
    int n;
    int[] weights;
    int[] values;
    int[] id;

    public DataModule(Scanner scanner) {
        n = scanner.nextInt();
        size = scanner.nextInt();
        weights=new int[n];
        values=new int[n];
        id=new int[n];

        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            weights[i]=w;
            values[i]=v;
            id[i]=i+1;

        }
    }
}