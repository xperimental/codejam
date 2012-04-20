package iosprint;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CodeJamB {

    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        int cases = Integer.parseInt(reader.readLine());
        for (
                int c = 0;
                c < cases; c++)

        {
            String data = reader.readLine();
            String[] parts = data.split(" ");
            int K = Integer.parseInt(parts[0]);
            String S = parts[1];
            int[] R = getResult(K, S);

            System.out.print("Case #" + (c + 1) + ": ");
            if (R.length > 0) {
                for (int i = 0; i < R.length; i++) {
                    System.out.print(R[i]);
                    if (i < R.length - 1) {
                        System.out.print(" ");
                    }
                }
            } else {
                System.out.print("NONE");
            }
            System.out.println();
        }
    }

    private static int[] getResult(int k, String s) {
        Set<Integer> duplicates = new HashSet<Integer>();
        Set<String> numbers = new HashSet<String>();

        for (int i = 0; i < s.length() - (k - 1); i++) {
            String p = s.substring(i, i + k);
            if (numbers.contains(p)) {
                duplicates.add(Integer.parseInt(p));
            } else {
                numbers.add(p);
            }
        }

        int[] r = new int[duplicates.size()];
        Iterator<Integer> iter = duplicates.iterator();
        int i = 0;
        while (iter.hasNext()) {
            r[i] = iter.next();
            i++;
        }
        Arrays.sort(r);
        return r;
    }
}
