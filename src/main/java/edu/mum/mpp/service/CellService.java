package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.Cell;
import edu.mum.mpp.model.CellReport;
import edu.mum.mpp.util.BlockDataUtil;
import edu.mum.mpp.util.CellDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CellService extends AbstractService<Cell> {
    public CellService(@Qualifier("cellDao") AbstractDao<Cell> dao) {
        super(dao);
    }

    private final static Logger logger = LoggerFactory.getLogger(CellService.class);

    @Autowired
    BlockService blockService;

    public Cell create(Cell cell) {

        CellDataUtil.addCell(cell);
        return cell;
    }

    public Cell editCell(Cell cell) {
        CellDataUtil.editCell(cell);
        return cell;

    }
    //

    public Cell getSingleCell(long id) {
        Cell singleCell = null;
        try {

            singleCell = CellDataUtil.displayCells().stream()
                    .filter(cell -> cell.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleCell()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleCell;
    }


    public List<CellReport> displayCellReport() {


        List<CellReport> report = new ArrayList<>();
        try {
            List<Cell> cellList = CellDataUtil.displayCells();

            if (cellList != null) {

                for (Cell s : cellList) {


                    CellReport r = new CellReport();
                    r.setId(s.getId());
                    r.setName(s.getName());

                    r.setBlockName(blockService.getSingleBlock(s.getBlockId()).getName());

                    report.add(r);
                }


            }
        } catch (Exception ex) {
            logger.error(" [displayStockReport()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }


        return report;
    }

}
