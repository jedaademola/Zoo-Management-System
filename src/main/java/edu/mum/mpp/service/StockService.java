package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.StockReport;
import edu.mum.mpp.model.StockRequest;
import edu.mum.mpp.util.LoggerUtil;
import edu.mum.mpp.util.StockDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService extends AbstractService<StockRequest> {

    private final static Logger logger = LoggerFactory.getLogger(StockService.class);


    @Autowired
    public StockService(@Qualifier("stockDao") AbstractDao<StockRequest> dao) {
        super(dao);
    }

    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;

    public List<StockReport> displayStockReport() {


        List<StockReport> report = new ArrayList<>();
        try {
            List<StockRequest> stockRequestList = StockDataUtil.displayStockRequests();

            if (stockRequestList != null) {

                for (StockRequest s : stockRequestList) {

                    String firstName = userService.getSingleUser(s.getSupplierId()).getFirstName();
                    String lastName = userService.getSingleUser(s.getSupplierId()).getFirstName();

                    String supplierName = firstName + " " + lastName;
                    StockReport r = new StockReport();
                    r.setId(s.getId());
                    r.setPrice(s.getPrice());
                    r.setCategory(s.getCategory());
                    r.setQuantity(s.getQuantity());
                    r.setItemName(foodService.getSingleFood(s.getId()).getName());
                    r.setSupplier(supplierName);

                    r.setCreatedOn(s.getCreatedOn());
                    report.add(r);
                }


            }
        } catch (Exception ex) {
            logger.error(" [displayStockReport()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }


        return report;
    }

    public StockRequest create(StockRequest stockRequest) {

        StockDataUtil.addStockRequest(stockRequest);
        return stockRequest;
    }


    public List<StockRequest> getStockRequests() {
        return StockDataUtil.displayStockRequests();
    }

    public StockRequest getSingleStockRequest(long id) {
        StockRequest stockRequest = null;
        try {

            stockRequest = StockDataUtil.displayStockRequests().stream()
                    .filter(stock -> stock.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleStock()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return stockRequest;
    }


    public StockRequest editStockRequest(StockRequest stockRequest) {
        StockDataUtil.editStockRequest(stockRequest);
        return stockRequest;

    }
}