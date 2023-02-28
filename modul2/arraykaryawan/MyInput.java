package modul2.arraykaryawan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyInput {
    public String bacaString() {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1);
        String string = " ";
        try {
            string = bfr.readLine();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return string;
    }

    public int bacaInt() {
        return Integer.parseInt(bacaString());
    }
}
