package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.StockRequest;
import edu.mum.mpp.util.LoggerUtil;
import edu.mum.mpp.util.StockDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService extends AbstractService<StockRequest> {

    private final static Logger logger = LoggerFactory.getLogger(StockService.class);


    @Autowired
    public StockService(@Qualifier("stockDao") AbstractDao<StockRequest> dao) {
        super(dao);
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