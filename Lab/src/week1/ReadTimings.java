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

// to solve the general problem, using class
class Trip {
    private String filePath;
    private int num;
    private Double maxSpeed = 0.0, totalDistance = 0.0, totalTime = 0.0, wheelDiameter = 0.665;
    private ArrayList<Double> timeList = new ArrayList<>();
    private ArrayList<Double> speedList = new ArrayList<>();

    Trip(String filePath) {
        this.filePath = filePath;
    }

    void run() {
        Double tempTime, tempSpeed;
        EasyReader myFile = new EasyReader(this.filePath);
        num = myFile.readInt();
        totalDistance = num * Math.PI * wheelDiameter / 1000.0;
        for (int i = 0; i < num; i++) {
            tempTime = myFile.readDouble();
            timeList.add(tempTime);
            totalTime += tempTime;

            tempSpeed = Math.PI * wheelDiameter / tempTime * 3.6;
            speedList.add(tempSpeed);
            if (maxSpeed < tempSpeed)   maxSpeed = tempSpeed;
        }
    }

    public void setWheelDiameter(Double wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public int getNum() {
        return num;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public Double getTotalTime() {
        return totalTime / 60;
    }

    public ArrayList<Double> getTimeList() {
        return timeList;
    }

    public ArrayList<Double> getSpeedList() {
        return speedList;
    }
}