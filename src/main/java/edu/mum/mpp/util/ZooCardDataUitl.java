package edu.mum.mpp.util;

import edu.mum.mpp.model.ZooCard;

import java.util.ArrayList;
import java.util.List;

public class ZooCardDataUitl {


    public static List<ZooCard> zooCardList = new ArrayList<>();
    private static long lastId;

    public static List<ZooCard> displayZooCards() {

        if (zooCardList.size() < 1) {

            for (int k = 1; k <= 1; ++k) {

                int id = (k % 2 == 0) ? 1 : 2;

                ZooCard newZooCard = new ZooCard();
                newZooCard.setId(k);
                newZooCard.setAmountLimit(2000);
                newZooCard.setBalance(2000);
                newZooCard.setDiscount(.5);
                newZooCard.setUserId(id);
                newZooCard.setStatus(1);//TODO 1= ACTIVE, 0= DEACTIVATED..THEIR COULD BE OTHER STATUS AS WELL

                lastId = k;

                zooCardList.add(newZooCard);
            }
        }

        return zooCardList;
    }


    public static void addZooCard(ZooCard newZooCard) {
        lastId = lastId + 1;

        newZooCard.setId(lastId);
        zooCardList.add(newZooCard);
    }

    public static void editZooCard(ZooCard newZooCard) {
        int idTemp = (int) newZooCard.getId();
        zooCardList.set(idTemp - 1, newZooCard);
    }
}
