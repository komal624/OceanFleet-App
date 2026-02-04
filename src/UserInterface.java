import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        System.out.println("Enter vessel details");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            vesselUtil.addVesselPerformance(vessel);
        }

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

