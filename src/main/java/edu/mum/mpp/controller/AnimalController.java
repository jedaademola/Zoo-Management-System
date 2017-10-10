package edu.mum.mpp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class AnimalController {

    private final static Logger logger = LoggerFactory.getLogger(AnimalController.class);

}
