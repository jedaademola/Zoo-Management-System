package edu.mum.mpp.controller;


import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.Appointment;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.service.AnimalService;
import edu.mum.mpp.service.AppointmentService;
import edu.mum.mpp.util.CustomResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "/appointment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Appointment appointment) {

        // ObjectMapper objectMapper = new ObjectMapper();

        /*if (appointment.get == null || animal.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Animal Name cannot be empty");

        if (animal.getTag() == null || animal.getTag().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Tag cannot be empty");

        if (animal.getBlockId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block cannot be empty");

        animal.setCellId(AninalDataUtil.lastId + 1);//TODO REMOVE LATER JUST FOR TESTING, lastId SHOULD BE RPIVATE

        if (animal.getCellId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Cell cannot be empty");

        if (animalService.checkAnimal(animal.getCellId())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, "Another Animal already exist assigned to this Cell");
        }
        */

        //    User user = TokenService.getCurrentUserFromSecurityContext();
        //   role.setCreatedBy(user.getId());

        Response resp = new Response();
        appointmentService.create(appointment);
        HttpStatus httpCode = (appointment.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((appointment.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated Appointment appointment) {

        if (appointment.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Appointment Id cannot be empty");

        /*if (animal.getName() == null || animal.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Animal Name cannot be empty");

        if (animal.getTag() == null || animal.getTag().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Tag cannot be empty");

        if (animal.getBlockId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block cannot be empty");

        if (animal.getCellId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Cell cannot be empty");

        Animal animalTemp = animalService.getSingleAnimal(animal.getId());
        if (animalTemp == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, " Animal record does not exist");
        }
        */

        Response resp = new Response();
        appointmentService.editAppointment(appointment);
        HttpStatus httpCode = (appointment.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((appointment.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/appointment", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)

    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }


    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Appointment getAppointmentById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Appointment Id cannot be empty");

        Appointment appointment = appointmentService.getSingleAppointment(id);
        if (appointment == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Appointment does not exist");
        }

        return appointment;
    }
}
