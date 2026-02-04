package ui;

import model.Vessel;
import util.VesselUtil;
import java.util.List;
import java.util.Scanner;


public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        // Step 1: Number of vessels
        System.out.println("Enter the number of vessels to be added");
        int n = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        // Step 2: Input vessel details
        System.out.println("Enter vessel details");
        System.out.println("Format: vesselId:vesselName:averageSpeed:vesselType");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            // UC2 call
            vesselUtil.addVesselPerformance(vessel);
        }

        // Step 3: UC3 - Search by ID
        System.out.println("Enter the Vessel Id to check speed");
        String searchId = scanner.nextLine();

        Vessel found = vesselUtil.getVesselById(searchId);

        if (found != null) {
            System.out.println(
                    found.getVesselId() + " | " +
                            found.getVesselName() + " | " +
                            found.getVesselType() + " | " +
                            found.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        // Step 4: UC4 - High Performance Vessels
        System.out.println("High performance vessels are");

        List<Vessel> highPerf = vesselUtil.getHighPerformanceVessels();

        for (Vessel vessel : highPerf) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                            vessel.getVesselName() + " | " +
                            vessel.getVesselType() + " | " +
                            vessel.getAverageSpeed() + " knots"
            );
        }

        scanner.close();
    }
}

