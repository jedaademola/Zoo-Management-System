package edu.mum.mpp.util;

import edu.mum.mpp.model.LabelValue;
import edu.mum.mpp.model.User;

import java.util.ArrayList;
import java.util.List;

public class SupplierDataUtil {


    public static List<User> supplierList = new ArrayList<>();
    private static long lastId;


    public static List<LabelValue> getSupplierListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (User u : displaySupplierUsers()) {

            LabelValue l = new LabelValue();
            l.setLabel(u.getFirstName() + " " + u.getLastName());
            l.setValue(u.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public static List<User> displaySupplierUsers() {

        if (supplierList.size() < 1) {

            //for (int k = 1; k <; ++k) {
            User newUser = new User();
            newUser.setId(1);
            newUser.setFirstName("Lukman");
            newUser.setLastName("Arogundade");

            // lastId = k;

            supplierList.add(newUser);
            //}
        }

        return supplierList;
    }


}
