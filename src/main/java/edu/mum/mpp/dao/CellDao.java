package edu.mum.mpp.dao;

import edu.mum.mpp.model.Cell;
import edu.mum.mpp.model.CellReport;
import edu.mum.mpp.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class CellDao extends AbstractDao<Cell> {

    private SimpleJdbcCall manageCell, getCells;
    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.manageCell = new SimpleJdbcCall(jdbcTemplate).withProcedureName("manageCell").withReturnValue();

        this.getCells = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getBlocks")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(CellReport.class));

    }


    public long manageCell(Cell cell) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(cell);
        Map<String, Object> m = this.manageCell.execute(in);
        return (Long) m.get("id");
    }

    public Page<CellReport> getCells(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.getCells.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<CellReport> page = new Page(count, content);
        return page;

    }
}
