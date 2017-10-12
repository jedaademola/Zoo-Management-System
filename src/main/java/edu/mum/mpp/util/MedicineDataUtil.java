package edu.mum.mpp.util;

import edu.mum.mpp.model.LabelValue;
import edu.mum.mpp.model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineDataUtil {

    public static List<Medicine> medicineList = new ArrayList<>();
    private static long lastId;


    public static List<LabelValue> getMedicineListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Medicine b : displayMedicines()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public static List<Medicine> displayMedicines() {

        if (medicineList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {
                Medicine newMedicine = new Medicine();
                newMedicine.setId(k);
                newMedicine.setName("Medicine" + k);

                lastId = k;

                medicineList.add(newMedicine);
            }
        }

        return medicineList;
    }

    public static void addMedicine(Medicine newMedicine) {
        lastId = lastId + 1;

        newMedicine.setId(lastId);
        medicineList.add(newMedicine);
    }

    public static void editMedicine(Medicine newMedicine) {
        int idTemp = (int) newMedicine.getId();
        medicineList.set(idTemp - 1, newMedicine);
    }

}
