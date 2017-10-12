package edu.mum.mpp.util;

import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDataUtil {
    private static List<Appointment> appointmentList = new ArrayList<>();
    public static long lastId;

    public static List<Appointment> displayAppointments() {

        String date = "10/10/2017";
        if (appointmentList.size() < 1) {

            for (int k = 1; k <= 10; ++k) {

                Appointment newAppointment = new Appointment();
                newAppointment.setId(k);
                newAppointment.setVisitorId(k);
                newAppointment.setDate(date);
                newAppointment.setNumberOfVisitor(k);

                lastId = k;

                appointmentList.add(newAppointment);
            }
        }

        return appointmentList;
    }


    public static void addAppointment(Appointment newAppointment) {
        lastId = lastId + 1;

        newAppointment.setId(lastId);
        appointmentList.add(newAppointment);
    }

    public static void editAppointment(Appointment newAppointment) {
        int idTemp = (int) newAppointment.getId();
        appointmentList.set(idTemp - 1, newAppointment);
    }
}
