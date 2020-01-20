package breakout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static int[][] Reader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while (sc.hasNextLine()) {
            builder.append(sc.nextLine() + "\n");
        }

        String temp = builder.toString();
        String[] first = temp.split("\n", 3);
        String[][] fin = new String[first.length][8];
        for(int i = 0; i < first.length; i++) {
            fin[i] = first[i].split(" ", 8);
        }
        int[][] ret = new int[3][8];
        for(int i = 0; i < fin.length; i++) {
            for(int j = 0; j < fin[0].length; j++) {
                ret[i][j] = Integer.parseInt(fin[i][j].trim());
            }
        }
        return ret;
    }

}
