package edu.mum.mpp.dao;


import edu.mum.mpp.model.Medicine;
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
public class MedicineDao extends AbstractDao<Medicine> {

    private SimpleJdbcCall manageMedicine, getMedicines;

    @Autowired
    @Override

    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);


        this.manageMedicine = new SimpleJdbcCall(jdbcTemplate).withProcedureName("manageMedicine").withReturnValue();

        this.getMedicines = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getMedicines")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(Medicine.class));


    }

    public long manageMedicine(Medicine medicine) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(medicine);
        Map<String, Object> m = this.manageMedicine.execute(in);
        return (Long) m.get("id");
    }

    public Page<Medicine> getMedicines(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.getMedicines.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<Medicine> page = new Page(count, content);
        return page;

    }



}

