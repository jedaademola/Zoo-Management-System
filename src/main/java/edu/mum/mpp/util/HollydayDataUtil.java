package edu.mum.mpp.util;

import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Hollyday;

import java.util.ArrayList;
import java.util.List;

public class HollydayDataUtil
{
    public static List<Hollyday> hollydayList = new ArrayList<>();
    private static long lastId;


    public static List<Hollyday> displayHollydays() {

        if (hollydayList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {
                Hollyday newHollyday= new Hollyday();
                newHollyday.setId(k);
                newHollyday.setName("Food" + k);

                lastId = k;

                hollydayList.add(newHollyday);
            }
        }

        return hollydayList;
    }

    public static void addHollyday(Hollyday newHollyday) {
        lastId = lastId + 1;

        newHollyday.setId(lastId);
        hollydayList.add(newHollyday);
    }

    public static void editHollyday(Hollyday newHollyday) {
        int idTemp = (int) newHollyday.getId();
        hollydayList.set(idTemp - 1, newHollyday);
    }
}
