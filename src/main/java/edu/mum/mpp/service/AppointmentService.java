package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.Appointment;
import edu.mum.mpp.util.AninalDataUtil;
import edu.mum.mpp.util.AppointmentDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService extends AbstractService<Appointment> {
    private final static Logger logger = LoggerFactory.getLogger(AnimalService.class);

    @Autowired
    public AppointmentService(@Qualifier("appointmentDao") AbstractDao<Appointment> dao) {
        super(dao);

    }

    public Appointment create(Appointment appointment) {

        AppointmentDataUtil.addAppointment(appointment);
        return appointment;
    }

    public boolean checkAppoitment(long id) {

        long idTemp = id;
        try {

            idTemp = AppointmentDataUtil.displayAppointments().stream()
                    .filter(
                            appointment -> appointment.getId() == id)
                    .map(Appointment::getId)
                    .findAny()
                    .orElse(0L);

        } catch (Exception ex) {
            logger.error(" [checkAppointment()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return idTemp == id;

    }


    public List<Appointment> getAppointments() {
        return AppointmentDataUtil.displayAppointments();
    }

    public Appointment getSingleAppointment(long id) {
        Appointment singleAppointment = null;
        try {

            singleAppointment = AppointmentDataUtil.displayAppointments().stream()
                    .filter(appointment -> appointment.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleAppointment()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleAppointment;
    }


    public Appointment editAppointment(Appointment appointment) {
        AppointmentDataUtil.editAppointment(appointment);
        return appointment;

    }
}
