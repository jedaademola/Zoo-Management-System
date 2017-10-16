package edu.mum.mpp.dao;



import edu.mum.mpp.model.Food;
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
public class FoodDao extends AbstractDao<Food> {

    private SimpleJdbcCall manageFood, getFoods;

    @Autowired
    @Override

    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);


        this.manageFood = new SimpleJdbcCall(jdbcTemplate).withProcedureName("manageFood").withReturnValue();

        this.getFoods = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getFoods")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(Food.class));


    }

    public long manageFood(Food food) throws DataAccessException {
        SqlParameterSource in = new BeanPropertySqlParameterSource(food);
        Map<String, Object> m = this.manageFood.execute(in);
        return (Long) m.get("id");
    }

    public Page<Food> getFoods(long pageNum, long pageSize) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize);

        Map m = this.getFoods.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<Food> page = new Page(count, content);
        return page;

    }


}
