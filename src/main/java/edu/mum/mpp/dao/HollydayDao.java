package edu.mum.mpp.dao;

import edu.mum.mpp.model.HolidayRequest;
import edu.mum.mpp.model.Hollyday;
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
public class HollydayDao extends AbstractDao<Hollyday> {

    private SimpleJdbcCall manage, getLists, addHolidayRequest;

    @Autowired
    @Override

    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.manage = new SimpleJdbcCall(jdbcTemplate).withProcedureName("manageHoliday").withReturnValue();
        this.addHolidayRequest = new SimpleJdbcCall(jdbcTemplate).withProcedureName("addHolidayRequest").withReturnValue();

        this.getLists = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getHolidayLists")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(Hollyday.class));


    }

    public long manage(Hollyday hollyday) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(hollyday);
        Map<String, Object> m = this.manage.execute(in);
        return (Long) m.get("id");
    }

    public Page<Hollyday> getLists(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.getLists.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<Hollyday> page = new Page(count, content);
        return page;

    }


    public long addHolidayRequest(HolidayRequest holidayRequest) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(holidayRequest);
        Map<String, Object> m = this.addHolidayRequest.execute(in);
        return (Long) m.get("id");
    }

}
