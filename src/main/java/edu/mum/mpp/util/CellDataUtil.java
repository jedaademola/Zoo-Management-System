package edu.mum.mpp.util;


import edu.mum.mpp.model.Cell;
import edu.mum.mpp.model.LabelValue;

import java.util.ArrayList;
import java.util.List;

public class CellDataUtil {
    public static List<Cell> cellList = new ArrayList<>();
    private static long lastId;


    public static List<LabelValue> getCellListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Cell c : displayCells()) {

            LabelValue l = new LabelValue();
            l.setLabel(c.getName());
            l.setValue(c.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public static void addCell(Cell newCell) {
        lastId = lastId + 1;

        newCell.setId(lastId);
        cellList.add(newCell);
    }

    public static void editCell(Cell newCell) {
        int idTemp = (int) newCell.getId();
        cellList.set(idTemp - 1, newCell);
    }

    public static List<Cell> displayCells() {

        if (cellList.size() < 1) { // if list blank populate these values in it

            for (int k = 1; k <= 5; ++k) {
                Cell newCell = new Cell();
                newCell.setId(k);
                newCell.setName("Cell" + k);
                newCell.setBlockId(k);
                lastId = k;

                cellList.add(newCell);
            }
        }
        return cellList;
    }
}
