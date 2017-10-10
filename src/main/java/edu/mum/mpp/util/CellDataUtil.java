package edu.mum.mpp.util;

import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellDataUtil {
    public static List<Cell> cellList = new ArrayList<>();
    private static long lastId;

    public static void addCell(Cell newCell) {
        lastId = lastId + 1;

        newCell.setId(lastId);
        cellList.add(newCell);
    }

    public static List<Cell> displayCells() {

        if (cellList.size() < 1) { // if list blank populate these values in it

            for (int k = 1; k <= 5; ++k) {
                Cell newCell = new Cell();
                newCell.setId(k);
                newCell.setName("Cell" + k);
                //newCell.setLocation("East");
                lastId = k;

                cellList.add(newCell);
            }
        }
        return cellList;
    }
}
