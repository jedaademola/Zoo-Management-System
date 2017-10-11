package edu.mum.mpp.controller;

import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Name cannot be empty");


        if (hollydayService.checkHollyday(hollyday.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Food already exist");
        }


        Response resp = new Response();
        hollydayService.create(hollyday);
        HttpStatus httpCode = (hollyday.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((hollyday.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }
}
