package edu.mum.mpp.util;

import edu.mum.mpp.model.StockReport;
import edu.mum.mpp.model.StockRequest;
import edu.mum.mpp.service.FoodService;
import edu.mum.mpp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockDataUtil {


    public static List<StockRequest> stockRequestList = new ArrayList<>();
    private static long lastId;


   /* public static List<LabelValue> getStockRequestListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (StockRequest b : displayStockRequests()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }*/

    public static List<StockRequest> displayStockRequests() {

        if (stockRequestList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {

                int itemId = (k % 2 == 0) ? 1 : 2;

                StockRequest newStockRequest = new StockRequest();
                newStockRequest.setId(itemId);
                newStockRequest.setItemId(1);
                newStockRequest.setPrice(20 * k);
                newStockRequest.setQuantity(1 * k);
                newStockRequest.setSupplierId(1);
                newStockRequest.setCategory("Food");
                newStockRequest.setCreatedOn(LocalDateTime.of(2017, 10, 10, 10, 20));

                lastId = k;

                stockRequestList.add(newStockRequest);
            }
        }

        return stockRequestList;
    }


    public static void addStockRequest(StockRequest newStockRequest) {
        lastId = lastId + 1;

        newStockRequest.setId(lastId);
        stockRequestList.add(newStockRequest);
    }

    public static void editStockRequest(StockRequest newStockRequest) {
        int idTemp = (int) newStockRequest.getId();
        stockRequestList.set(idTemp - 1, newStockRequest);
    }
}
