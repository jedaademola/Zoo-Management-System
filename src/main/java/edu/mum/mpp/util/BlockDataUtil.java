package edu.mum.mpp.util;

import edu.mum.mpp.model.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockDataUtil {

    public static List<Block> blockList = new ArrayList<>();
    private static long lastId;

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
}
