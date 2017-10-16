package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.MedicineDao;
import edu.mum.mpp.model.LabelValue;
import edu.mum.mpp.model.Medicine;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.util.LoggerUtil;
import edu.mum.mpp.util.MedicineDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService extends AbstractService<Medicine> {

    private final static Logger logger = LoggerFactory.getLogger(MedicineService.class);


    @Autowired
    public MedicineService(@Qualifier("medicineDao") AbstractDao<Medicine> dao) {
        super(dao);
    }


    public List<LabelValue> getMedicineListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Medicine b : getMedicines(1, 20).getContent()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public Page<Medicine> getMedicines(long pageNum, long pageSize) {
        MedicineDao foodDao = (MedicineDao) dao;
        return foodDao.getMedicines(pageNum, pageSize);
    }

    public long manageMedicine(Medicine medicine) {


        MedicineDao foodDao = (MedicineDao) dao;
        return foodDao.manageMedicine(medicine);
    }


    public Medicine create(Medicine medicine) {

        MedicineDataUtil.addMedicine(medicine);
        return medicine;
    }

    public boolean checkMedicine(String medicineName) {

        String medicineNameTemp = "";
        try {

            medicineNameTemp = getMedicines(1, 20).getContent().stream()
                    .filter(
                            food -> food.getName().equals(medicineName)
                    )
                    .map(Medicine::getName)
                    .findAny()
                    .orElse("");

        } catch (Exception ex) {
            logger.error(" [checkMedicine()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return medicineNameTemp.equals(medicineName);

    }


    public List<Medicine> getMedicines() {
        return MedicineDataUtil.displayMedicines();
    }

    public Medicine getSingleMedicine(long id) {
        Medicine singleMedicine = null;
        try {

            singleMedicine = getMedicines(1, 20).getContent().stream()
                    .filter(food -> food.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleMedicine()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleMedicine;
    }


    public Medicine editMedicine(Medicine medicine) {
        MedicineDataUtil.editMedicine(medicine);
        return medicine;

    }
}
