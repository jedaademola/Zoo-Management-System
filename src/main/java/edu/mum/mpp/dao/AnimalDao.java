package edu.mum.mpp.dao;


import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.AnimalReport;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.PaymentReport;
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
public class AnimalDao extends AbstractDao<Animal> {

    private SimpleJdbcCall manageAnimal, getAnimals, searchAnimal, report;

    @Autowired
    @Override

    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.manageAnimal = new SimpleJdbcCall(jdbcTemplate).withProcedureName("manageAnimal").withReturnValue();

        this.getAnimals = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getAnimals")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(AnimalReport.class));


        this.searchAnimal = new SimpleJdbcCall(jdbcTemplate).withProcedureName("searchAnimal")
                .returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(AnimalReport.class));

        this.report = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getReports")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(PaymentReport.class));

    }


    public AnimalReport searchAnimal(String name) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("name", name);
        Map<String, Object> m = searchAnimal.execute(in);
        List<AnimalReport> result = (List<AnimalReport>) m.get(SINGLE_RESULT);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }
    public long manageAnimal(Animal animal) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(animal);
        Map<String, Object> m = this.manageAnimal.execute(in);
        return (Long) m.get("id");
    }

    public Page<AnimalReport> getAnimals(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.getAnimals.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<AnimalReport> page = new Page(count, content);
        return page;

    }

    public Page<PaymentReport> report(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.report.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<PaymentReport> page = new Page(count, content);
        return page;

    }


}
