package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.AbstractModel;
import edu.mum.mpp.model.ZooCard;
import edu.mum.mpp.util.LoggerUtil;
import edu.mum.mpp.util.ZooCardDataUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(PaymentService.class);


    @Autowired
    public PaymentService(@Qualifier("paymentDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    public ZooCard createZooCard(ZooCard card) {

        ZooCardDataUitl.addZooCard(card);
        return card;
    }

    public boolean checkZooCardRecord(long userId) {

        long userIdTemp = userId;
        try {

            userIdTemp = ZooCardDataUitl.displayZooCards().stream()
                    .filter(
                            card -> card.getUserId() == userId
                    )
                    .map(ZooCard::getUserId)
                    .findAny()
                    .orElse(0L);

        } catch (Exception ex) {
            logger.error(" [checkFood()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return userIdTemp == userId;

    }


    public List<ZooCard> getZooCards() {

        return ZooCardDataUitl.displayZooCards();
    }

    public ZooCard getSingleCard(long id) {
        ZooCard singleZooCard = null;
        try {

            singleZooCard = ZooCardDataUitl.displayZooCards().stream()
                    .filter(card -> card.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleCard()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleZooCard;
    }


    public ZooCard editFood(ZooCard card) {
        ZooCardDataUitl.editZooCard(card);
        return card;

    }
}
