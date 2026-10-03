package pt.iscte.dcti.pcd.race;

import javax.swing.JFrame;

public class CarRace {

    public static void main(String[] args) {
        int numCars = 10;
        int numSteps = 100;

        JFrame frame = new JFrame("Car Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Track track = new Track(numCars, numSteps);

        Car[] cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            cars[i] = new Car(i, numSteps);
            cars[i].addObserver(track);
        }

        frame.add(track);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        for (int i = 0; i < numCars; i++) {
            new Thread(cars[i]).start();
        }
    }

}
