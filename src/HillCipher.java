import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HillCipher {
    public static void main(String[] args) {
        List<int[][]> res = getKeyMatrix();

        for (int[][] mat : res)
            System.out.println("Key matrix: " + Arrays.deepToString(mat));
        for (int[][] mat : res)
            System.out.println("Inverse matrix: " + Arrays.deepToString(inverseMatrix(mat)));

        System.out.println("Total key matrices: " + res.size());
    }

    // Get all the possible 2x2 key matrices
    public static List<int[][]> getKeyMatrix() {
        List<int[][]> keyMat = new ArrayList<>();

        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                for (int c = 0; c < 26; c++) {
                    for (int d = 0; d < 26; d++) {
                        int det = a * d - b * c;
                        if (gcd(det, 26) == 1)
                            keyMat.add(new int[][]{{a, b}, {c, d}});
                    }
                }
            }
        }
        return keyMat;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Get inverse key matrices
    public static int[][] inverseMatrix(int[][] mat) {
        int det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        int inverseDet = inverse(det, 26);

        int[][] inverseMat = new int[][]{
                {mat[1][1], -mat[0][1]},
                {-mat[1][0], mat[0][0]}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inverseMat[i][j] = (inverseMat[i][j] * inverseDet) % 26;
                if (inverseMat[i][j] < 0)
                    inverseMat[i][j] += 26;
            }
        }

        return inverseMat;
    }

    public static int inverse(int num, int m) {
        num = num % m;
        // Get the i which is suitable for (num * i) % m == 1
        for (int i = 1; i < m; i++)
            if ((num * i) % m == 1)
                return i;

        return 1;
    }
}
