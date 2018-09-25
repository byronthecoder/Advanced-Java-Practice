package week1;


import Tools.Sheffield.EasyReader;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReadTimings {
    public static void main(String[] args) {
        EasyReader myFile = new EasyReader
                ("F://mycode//Advanced-Java-Practice//lab//src//week1//timings.txt"); // just
        // change the pathway in your computer

        int num = myFile.readInt();
        double tempTime;
        DecimalFormat df = new DecimalFormat("0.000");
        ArrayList<Double> time = new ArrayList<>();
        ArrayList<Double> speed = new ArrayList<>();
        System.out.println(num);

        for (int i = 0; i < num; i++) {
            tempTime = myFile.readDouble();
            time.add(tempTime);

            speed.add(Math.PI * 0.665 / tempTime * 3.6);
            System.out.println(df.format(speed.get(i)) + " km/h");
        }


    }
}
