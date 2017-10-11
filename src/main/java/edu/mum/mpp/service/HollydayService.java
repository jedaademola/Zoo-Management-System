package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Hollyday;
import edu.mum.mpp.util.FoodDataUtil;
import edu.mum.mpp.util.HollydayDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HollydayService extends AbstractService<Hollyday>
{
    private final static Logger logger = LoggerFactory.getLogger(HollydayService.class);

    @Autowired
    public HollydayService(@Qualifier("hollydayDao") AbstractDao<Hollyday> dao)
    {
        super(dao);
    }

    public Hollyday create(Hollyday hollyday) {

        HollydayDataUtil.addHollyday(hollyday);
        return hollyday;
    }

    public boolean checkHollyday(String hollydayName) {

        String hollydayNameTemp = "";
        try {

            hollydayNameTemp = HollydayDataUtil.displayHollydays().stream()
                    .filter(
                            hollyday -> hollyday.getName().equals(hollydayName)
                    )
                    .map(Hollyday::getName)
                    .findAny()
                    .orElse("");

        } catch (Exception ex) {
            logger.error(" [checkFood()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return hollydayNameTemp.equals(hollydayName);

    }


    public List<Hollyday> getHollydays() {
        return HollydayDataUtil.displayHollydays();
    }

    public Hollyday getSingleHollyday(long id) {
        Hollyday singleHollyday = null;
        try {

            singleHollyday = HollydayDataUtil.displayHollydays().stream()
                    .filter(hollyday -> hollyday.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleFood()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleHollyday;
    }


    public Hollyday editHollyday(Hollyday hollyday) {
        HollydayDataUtil.editHollyday(hollyday);
        return hollyday;

    }
}
