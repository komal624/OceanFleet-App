import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    // Getter
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // Setter
    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    // Requirement 1: Add Vessel
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) { // Case-sensitive check
                return vessel;
            }
        }
        return null; // If not found
    }

    // Requirement 3: Get High Performance Vessels
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return result;
        }

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        // Find max speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Collect vessels with max speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }

        return result;
    }
}
