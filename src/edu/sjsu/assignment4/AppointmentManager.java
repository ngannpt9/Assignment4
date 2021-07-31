package edu.sjsu.assignment4;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manages a collection of appointment.
 *
 */
public class AppointmentManager extends HashMap<String, Appointment> {

    /**
     * Add an appointment with type, description, start date, end date
     * to the map.
     *
     * @return true if add successfully.
     */
    public boolean addApp(Appointment appointment) {
        String des = appointment.getDescription();
        if (this.containsKey(des)) return false;
        else this.put(des, appointment);
            return true;
        }

    /**
     * Delete the corresponding appointment with the description from the map.
     *
     * @return true if delete successfully.
     */
    public boolean deleteApp(String desDelete) {
        if (this.containsKey(desDelete)) {
            this.remove(desDelete);
            return true;
        } else {
            return false;
        }
        }

    /**
     * Print all appointment information.
     *
     */
    public void viewApp() {
            for (Map.Entry<String, Appointment> e : this.entrySet()) {
                System.out.println(e.getValue().toString());
            }
        }
}
