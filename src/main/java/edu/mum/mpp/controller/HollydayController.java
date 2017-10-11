package edu.mum.mpp.controller;

import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Hollyday;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.service.HollydayService;
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

public class HollydayController
{
    @Autowired
    HollydayService hollydayService;

    @RequestMapping(value = "/hollyday", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Hollyday hollyday) {


        if (hollyday.getName() == null || hollyday.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Hollyday Package Name cannot be empty");


        if (hollydayService.checkHollyday(hollyday.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, "Hollyday Package already exist");
        }


        Response resp = new Response();
        hollydayService.create(hollyday);
        HttpStatus httpCode = (hollyday.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((hollyday.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/hollyday", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated Hollyday hollyday) {

        if (hollyday.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Holliday Package Id cannot be empty");

        if (hollyday.getName() == null || hollyday.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Hollyday Package Name cannot be empty");

        /*if (animal.getTag() == null || animal.getTag().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Tag cannot be empty");

        if (animal.getBlockId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block cannot be empty");

        if (animal.getCellId() < 0)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Cell cannot be empty");*/

        Hollyday hollydayTemp = hollydayService.getSingleHollyday(hollyday.getId());
        if (hollydayTemp == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Hollyday Package record does not exist");
        }


        Response resp = new Response();
        hollydayService.editHollyday(hollyday);
        HttpStatus httpCode = (hollyday.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((hollyday.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/hollyday", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)

    public List<Hollyday> getHollydays() {
        return hollydayService.getHollydays();
    }


    @RequestMapping(value = "/hollyday/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Hollyday getHollydayById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Hollyday Package Id cannot be empty");

        Hollyday hollyday = hollydayService.getSingleHollyday(id);
        if (hollyday == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Holyday Package does not exist");
        }

        return hollyday;
    }
}
