package edu.sjsu.assignment4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class will keep the information of appointment.
 *
 */
public class Appointment implements Comparable<Appointment>{
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Contructor for appointment class.
     *
     * @param description the appointment description.
     * @param startDate the appointment start date.
     * @param endDate the appointment end date.
     */
    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Contructors for appointment description.
     *
     * @param description the appointment description.
     */
    public Appointment(String description) {
        this.description = description;
    }

    /**
     * Getter for appointment description.
     *
     * @return appointment description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for appointment start date.
     *
     * @return appointment start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Getter for appointment end date.
     *
     * @return appointment end date.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Print the resulting for view appointment.
     *
     * @return the print resulting.
     */
    @Override
    public String toString() {
        return "Appointment{" +
                "description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    /**
     * Compare between the inputs.
     *
     * @param o the object to compare.
     * @return the resulting of compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(description, that.description);
    }

    /**
     * Hashing the inputs.
     *
     * @return the resulting of hashing
     */
    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    /**
     * Compare by the description, start date and end date.
     *
     * @param o the object to compare.
     * @return the resulting of compare.
     */
    @Override
    public int compareTo(Appointment o) {
        if (this.getDescription() != o.getDescription()) return this.getDescription().compareTo(o.getDescription());
        else if (this.getStartDate() != o.getStartDate()) return this.getStartDate().compareTo(o.getStartDate());
        else return this.getEndDate().compareTo(o.getEndDate());
    }

}
