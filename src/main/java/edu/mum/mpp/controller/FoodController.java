package edu.mum.mpp.controller;


import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.service.FoodService;
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
public class FoodController {

    @Autowired
    FoodService foodService;


    @RequestMapping(value = "/manageFood", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> manageFood(@RequestBody @Valid Food food) throws Exception {


        if (food.getName() == null || food.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Name cannot be empty");


        if (foodService.checkFood(food.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Food already exist");
        }

        long id = foodService.manageFood(food);

        Response resp = new Response();


        HttpStatus httpCode = (id > 0L) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((id > 0L) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);

    }


    @RequestMapping(value = "/food/paging", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_VIEW_ALL_USERS')")
    public Page<Food> getFoods(
            @RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Long pageSize) throws Exception {
        return foodService.getFoods(pageNum, pageSize);
    }









    @RequestMapping(value = "/food", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Food food) {


        if (food.getName() == null || food.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Name cannot be empty");


        if (foodService.checkFood(food.getName())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Food already exist");
        }


        Response resp = new Response();
        foodService.create(food);
        HttpStatus httpCode = (food.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((food.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/food", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated Food food) {

        if (food.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Id cannot be empty");

        if (food.getName() == null || food.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Name cannot be empty");


        Food blockTemp = foodService.getSingleFood(food.getId());
        if (blockTemp == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, " Food does not exist");
        }


        Response resp = new Response();
        foodService.editFood(food);
        HttpStatus httpCode = (food.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((food.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/food", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Food> getFoods() {
        return foodService.getFoods();
    }


    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Food getFoodById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food Id cannot be empty");

        Food food = foodService.getSingleFood(id);
        if (food == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Food does not exist");
        }

        return food;
    }
}
