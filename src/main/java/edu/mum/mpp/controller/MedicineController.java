package edu.mum.mpp.controller;

import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Medicine;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.service.MedicineService;
import edu.mum.mpp.util.CustomResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class MedicineController {

    @Autowired
    MedicineService medicineService;


    @RequestMapping(value = "/manageMedicine", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> manageMedicine(@RequestBody @Valid Medicine medicine) throws Exception {

        if (medicine.getName() == null || medicine.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine Name cannot be empty");


        if (medicineService.checkMedicine(medicine.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Medicine already exist");
        }


        long id = medicineService.manageMedicine(medicine);

        Response resp = new Response();


        HttpStatus httpCode = (id > 0L) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((id > 0L) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);

    }


    @RequestMapping(value = "/medicine/paging", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_VIEW_ALL_USERS')")
    public Page<Medicine> getMedicines(
            @RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Long pageSize) throws Exception {
        return medicineService.getMedicines(pageNum, pageSize);
    }








    @RequestMapping(value = "/medicine", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Medicine medicine) {


        if (medicine.getName() == null || medicine.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine Name cannot be empty");


        if (medicineService.checkMedicine(medicine.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Medicine already exist");
        }


        Response resp = new Response();
        medicineService.create(medicine);
        HttpStatus httpCode = (medicine.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((medicine.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/medicine", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated Medicine medicine) {

        if (medicine.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine Id cannot be empty");

        if (medicine.getName() == null || medicine.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine Name cannot be empty");


        Medicine medicineTemp = medicineService.getSingleMedicine(medicine.getId());
        if (medicineTemp == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, " Medicine does not exist");
        }


        Response resp = new Response();
        medicineService.editMedicine(medicine);
        HttpStatus httpCode = (medicine.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((medicine.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/medicine", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Medicine> getMedicines() {
        return medicineService.getMedicines();
    }


    @RequestMapping(value = "/medicine/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Medicine getMedicineById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine Id cannot be empty");

        Medicine medicine = medicineService.getSingleMedicine(id);
        if (medicine == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Medicine does not exist");
        }

        return medicine;
    }
}
