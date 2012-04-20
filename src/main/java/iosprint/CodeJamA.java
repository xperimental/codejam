package iosprint;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CodeJamA {

    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        int cases = Integer.parseInt(reader.readLine());
        for (int c = 0; c < cases; c++) {
            String data = reader.readLine();
            String[] parts = data.split(" ");
            int L = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);
            int[] K = new int[M];
            for (int n = 0; n < M; n++) {
                K[n] = Integer.parseInt(parts[2 + n]);
            }
            int R = getResult(L, M, K);
            System.out.println("Case #" + (c + 1) + ": " + R);
        }
    }

    private static int getResult(int l, int m, int[] k) {
        int max = 0;
        for (int i = 0; i < k.length; i++) {
            if (k[i] > l) {
                return -1;
            } else if (k[i] > max) {
                max = k[i];
            }
        }
        if (max == 0) {
            return 0;
        } else {
            return l * m - (l - max);
        }
    }
}
