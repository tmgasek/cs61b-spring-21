import java.util.Arrays;

public class FillGrid {
    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for( int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
               if (i < j) {
                   S[i][j] = UR[kR];
                   kR++;
               } else if (i > j) {
                   S[i][j] = LL[kL];
                   kL++;
               }
            }
        }

    }

    public static void main(String[] args) {
        int[] LL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int[][] S = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        fillGrid(LL, UR, S);

        for( int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[i].length; j++){
                System.out.printf("%d \t", S[i][j]);
            }
            System.out.println();
        }
        /*
        {
            { 0, 11, 12, 13, 14 },
            { 1, 0, 15, 16, 17 },
            { 2, 3, 0, 18, 19 },
            { 4, 5, 6, 0, 20 },
            { 7, 8, 9, 10, 0 }
        }
        */
    }
}
