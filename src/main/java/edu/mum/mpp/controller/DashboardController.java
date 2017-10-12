package edu.mum.mpp.controller;

import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.StockRequest;
import edu.mum.mpp.service.CellService;
import edu.mum.mpp.service.StockService;
import edu.mum.mpp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class DashboardController {

    @Autowired
    StockService stockService;

    @Autowired
    CellService cellService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/generalPage", method = RequestMethod.GET)
    public ModelAndView generalPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("generalPage");
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexpage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/manageBlock", method = RequestMethod.GET)
    public ModelAndView manageBlock() {
        ModelAndView model = new ModelAndView();
        model.addObject("blocks", BlockDataUtil.displayBlocks());
        model.setViewName("manageBlock");
        return model;
    }

    @RequestMapping(value = "/manageFood", method = RequestMethod.GET)
    public ModelAndView manageFood() {
        ModelAndView model = new ModelAndView();
        model.addObject("foods", FoodDataUtil.displayFoods());
        model.setViewName("manageFood");
        return model;
    }


    @RequestMapping(value = "/manageStock", method = RequestMethod.GET)
    public ModelAndView manageStock(@ModelAttribute("command") StockRequest stockRequest) {
        ModelAndView model = new ModelAndView();
        model.addObject("stocks", stockService.displayStockReport());
        model.addObject("suppliers", SupplierDataUtil.getSupplierListForDropDown());
        model.addObject("itemIds", FoodDataUtil.getFoodListForDropDown());
        //
        //  food/medicine
        model.setViewName("manageStock");
        return model;
    }


    @RequestMapping(value = "/manageMedicine", method = RequestMethod.GET)
    public ModelAndView manageMedicine() {
        ModelAndView model = new ModelAndView();
        model.addObject("medicines", MedicineDataUtil.displayMedicines());
        model.setViewName("manageMedicine");
        return model;
    }



    @RequestMapping(value = "/manageCell", method = RequestMethod.GET)
    public ModelAndView manageCell(@ModelAttribute("command") Block block) {
        ModelAndView model = new ModelAndView();
        model.addObject("blocks", BlockDataUtil.getBlockListForDropDown());
        model.addObject("cells", cellService.displayCellReport());
        model.setViewName("manageCell");
        return model;
    }


    @RequestMapping(value = "/manageAnimal", method = RequestMethod.GET)
    public ModelAndView manageAnimal(@ModelAttribute("command") Block block) {

        ModelAndView model = new ModelAndView();
        // model.addObject("states",states);
        model.addObject("blocks", BlockDataUtil.getBlockListForDropDown());
        model.addObject("cells", CellDataUtil.getCellListForDropDown());
        model.addObject("animals", AnimalDataUtil.displayAnimals());
        model.setViewName("manageAnimal");
        return model;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView table() {
        ModelAndView model = new ModelAndView();
        model.setViewName("table");
        return model;
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        return model;
    }

  /*  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView model = new ModelAndView();
        model.addObject("users", getUsers());
        model.setViewName("dashboard");
        return model;
    }

    private List getUsers() {
        User user = new User();
        user.setEmail("johndoe123@gmail.com");
        user.setName("John Doe");
        user.setAddress("Bangalore, Karnataka");
        User user1 = new User();
        user1.setEmail("amitsingh@yahoo.com");
        user1.setName("Amit Singh");
        user1.setAddress("Chennai, Tamilnadu");
        User user2 = new User();
        user2.setEmail("bipulkumar@gmail.com");
        user2.setName("Bipul Kumar");
        user2.setAddress("Bangalore, Karnataka");
        User user3 = new User();
        user3.setEmail("prakashranjan@gmail.com");
        user3.setName("Prakash Ranjan");
        user3.setAddress("Chennai, Tamilnadu");
        return Arrays.asList(user, user1, user2, user3);
    }*/

}