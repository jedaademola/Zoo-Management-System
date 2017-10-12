package edu.mum.mpp.util;

import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.Hollyday;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HollydayDataUtil
{
    public static List<Hollyday> hollydayList = new ArrayList<>();
    private static long lastId;


    public static List<Hollyday> displayHollydays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "10/11/2017";
        LocalDate localDate = LocalDate.parse(date, formatter);

        if (hollydayList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {
                Hollyday newHollyday= new Hollyday();
                newHollyday.setId(k);
                newHollyday.setName("Hollyday" + k);
                newHollyday.setPeriod(date);
                newHollyday.setAmount(200.0);

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
