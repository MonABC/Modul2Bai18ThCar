package com.company;

import java.util.Random;

import static com.company.Main.DISTANCE;
import static com.company.Main.STEP;


public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //khởi tạo điểm start (km ban đầu)
        int runDistance = 0;
        //khởi tạo thời gian bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();
        //kiêm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp chục chay
        while (runDistance < DISTANCE) {
            int speed = (new Random().nextInt(20));
            runDistance += speed;
            String log = "";
            int percentTravel = (runDistance * 100) / DISTANCE;
            for (int i = 0; i < DISTANCE; i += STEP) {
                if (percentTravel >= 1 + STEP) {
                    log += "=";

                } else if (percentTravel >= i && percentTravel < i + STEP) {
                    log += "o";

                } else {
                    log += "-";

                }
            }
            log += "|";
            System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.name + "broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.name + "Finish in " + (endTime - startTime) / 1000 + "s");

    }
}
