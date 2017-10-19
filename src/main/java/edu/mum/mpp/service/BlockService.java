package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.BlockDao;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.LabelValue;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.util.BlockDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockService extends AbstractService<Block> {

    private final static Logger logger = LoggerFactory.getLogger(BlockService.class);

    @Autowired
    public BlockService(@Qualifier("blockDao") AbstractDao<Block> dao) {
        super(dao);
    }


    public List<LabelValue> getBlockListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Block b : getBlocks(1, 20).getContent()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public Page<Block> getBlocks(long pageNum, long pageSize) {
        BlockDao blockDao = (BlockDao) dao;
        return blockDao.getBlocks(pageNum, pageSize);
    }

    public long manageBlock(Block block) {


        BlockDao blockDao = (BlockDao) dao;
        return blockDao.manageBlock(block);
    }


    public Block create(Block block) {

        BlockDataUtil.addBlock(block);
        return block;
    }

    public boolean checkBlock(String blockName, String location) {

        String blockNameTemp = blockName;
        try {
            Page<Block> blocks = getBlocks(1, 20);
            blockNameTemp = blocks.getContent().stream()
                    .filter(
                            block -> block.getName().equals(blockName))
                    .filter(block -> block.getLocation().equals(location))
                    .map(Block::getName)
                    .findAny()
                    .orElse("");

        } catch (Exception ex) {
            logger.error(" [checkBlock()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return blockNameTemp.equals(blockName);

    }


    // public List<Block> getBlocks() {
    // return BlockDataUtil.displayBlocks();
    // }

    public Block getSingleBlock(long id) {
        Block singleBlock = null;
        try {
            ///TODO  pageNum=1,  pageSize=20
            Page<Block> blocks = getBlocks(1, 20);

            singleBlock = blocks.getContent().stream()

                    .filter(block -> block.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleBlock()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleBlock;
    }


    public Block editBlock(Block block) {
        BlockDataUtil.editBlock(block);
        return block;

    }
}
