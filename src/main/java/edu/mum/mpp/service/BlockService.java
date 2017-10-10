package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.util.BlockDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService extends AbstractService<Block> {

    private final static Logger logger = LoggerFactory.getLogger(BlockService.class);

    @Autowired
    public BlockService(@Qualifier("blockDao") AbstractDao<Block> dao) {
        super(dao);
    }

    public Block create(Block block) {

        BlockDataUtil.addBlock(block);
        return block;
    }

    public boolean checkBlock(String blockName, String location) {

        String blockNameTemp = "";
        try {

            blockNameTemp = BlockDataUtil.displayBlocks().stream()
                    .filter(
                            block -> block.getName().equals(blockName)
                                    && block.getLocation().equals(location))
                    .map(Block::getName)
                    .findAny()
                    .orElse("");

        } catch (Exception ex) {
            logger.error(" [checkBlock()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return blockNameTemp.equals(blockName);

    }


    public List<Block> getBlocks() {
        return BlockDataUtil.displayBlocks();
    }
}
