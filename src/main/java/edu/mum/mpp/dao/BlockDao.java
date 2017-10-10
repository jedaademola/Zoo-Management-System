package edu.mum.mpp.dao;


import edu.mum.mpp.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class BlockDao extends AbstractDao<Block> {

    private SimpleJdbcCall sample;

    @Autowired
    @Override

    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        //  queueEmail = new SimpleJdbcCall(jdbcTemplate).withProcedureName("queueEmail").withReturnValue();
        //  updateEmailStatus = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updateEmailStatus").withReturnValue();
        // getEmailsToSend = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getEmailsToSend")
        //       .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(EmailDetails.class));
    }


}
