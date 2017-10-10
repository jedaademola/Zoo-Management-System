package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.Cell;
import edu.mum.mpp.util.BlockDataUtil;
import edu.mum.mpp.util.CellDataUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CellService extends AbstractService<Cell> {
    public CellService(@Qualifier("cellDao") AbstractDao<Cell> dao) {
        super(dao);
    }

    public Cell create(Cell cell) {

        CellDataUtil.addCell(cell);
        return cell;
    }
}
