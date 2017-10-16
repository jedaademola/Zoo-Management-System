package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.CellDao;
import edu.mum.mpp.model.Cell;
import edu.mum.mpp.model.CellReport;
import edu.mum.mpp.model.LabelValue;
import edu.mum.mpp.model.Page;
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


    public List<LabelValue> getCellListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (CellReport c : getCells(1, 20).getContent()) {

            LabelValue l = new LabelValue();
            l.setLabel(c.getName());
            l.setValue(c.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public Page<CellReport> getCells(long pageNum, long pageSize) {
        CellDao cellDao = (CellDao) dao;
        return cellDao.getCells(pageNum, pageSize);
    }

    public long manageCell(Cell cell) {


        CellDao cellDao = (CellDao) dao;
        return cellDao.manageCell(cell);
    }

    public Cell create(Cell cell) {

        CellDataUtil.addCell(cell);
        return cell;
    }

    public Cell editCell(Cell cell) {
        CellDataUtil.editCell(cell);
        return cell;

    }
    //

    public CellReport getSingleCell(long id) {
        CellReport singleCell = null;
        try {
            Page<CellReport> cells = getCells(1, 20);
            singleCell = cells.getContent().stream()
                    .filter(cell -> cell.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleCell()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleCell;
    }


    public List<CellReport> displayCellReport() {


        // List<CellReport> report = new ArrayList<>();

        List<CellReport> report = new ArrayList<>();

        try {

            report = getCells(1, 20).getContent();
            /*
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
        */

        } catch (Exception ex) {
            logger.error(" [displayCellReport()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }


        return report;
    }

}
