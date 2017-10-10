package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Medicine;
import edu.mum.mpp.util.FoodDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import edu.mum.mpp.util.MedicineDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService extends AbstractService<Medicine> {

    private final static Logger logger = LoggerFactory.getLogger(MedicineService.class);


    @Autowired
    public MedicineService(@Qualifier("medicineDao") AbstractDao<Medicine> dao) {
        super(dao);
    }

    public Medicine create(Medicine medicine) {

        MedicineDataUtil.addMedicine(medicine);
        return medicine;
    }

    public boolean checkMedicine(String medicineName) {

        String medicineNameTemp = "";
        try {

            medicineNameTemp = MedicineDataUtil.displayMedicines().stream()
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

            singleMedicine = MedicineDataUtil.displayMedicines().stream()
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
