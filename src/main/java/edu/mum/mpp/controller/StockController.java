package edu.mum.mpp.controller;

import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.model.StockRequest;
import edu.mum.mpp.service.StockService;
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
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/stock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated StockRequest stockRequest) {

        //TODO VALIDATE INPUTS
        // if (stock.getName() == null || stock.getName().isEmpty())
        //   throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "stock Name cannot be empty");


        Response resp = new Response();
        stockService.create(stockRequest);
        HttpStatus httpCode = (stockRequest.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((stockRequest.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/stock", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated StockRequest stockRequest) {

        if (stockRequest.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Stock Id cannot be empty");

        // if (stock.getName() == null || stock.getName().isEmpty())
        //   throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "stock Name cannot be empty");
        //TODO VALIDATE INPUTS

        StockRequest tempStock = stockService.getSingleStockRequest(stockRequest.getId());
        if (tempStock == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, " Stock record does not exist");
        }


        Response resp = new Response();
        stockService.editStockRequest(stockRequest);
        HttpStatus httpCode = (stockRequest.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((stockRequest.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/stock", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<StockRequest> getStockRequests() {
        return stockService.getStockRequests();
    }


    @RequestMapping(value = "/stock/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public StockRequest getStockRequestById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Stock Id cannot be empty");

        StockRequest stock = stockService.getSingleStockRequest(id);
        if (stock == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Stock does not exist");
        }

        return stock;
    }
}
