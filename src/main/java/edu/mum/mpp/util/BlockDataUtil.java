package edu.mum.mpp.util;

import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.LabelValue;

import java.util.ArrayList;
import java.util.List;

public class BlockDataUtil {

    public static List<Block> blockList = new ArrayList<>();
    private static long lastId;


    public static List<LabelValue> getBlockListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Block b : displayBlocks()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public static List<Block> displayBlocks() {
        //blockList = new ArrayList<>();
        if (blockList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {
                Block newBlock = new Block();
                newBlock.setId(k);
                newBlock.setName("Block" + k);
                newBlock.setLocation("East");
                lastId = k;

                blockList.add(newBlock);
            }
        }

        return blockList;
    }

    public static void addBlock(Block newBlock) {
        lastId = lastId + 1;

        newBlock.setId(lastId);
        blockList.add(newBlock);
    }

    public static void editBlock(Block newBlock) {
        int idTemp = (int) newBlock.getId();
        blockList.set(idTemp - 1, newBlock);
    }
}
