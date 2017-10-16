package edu.mum.mpp.dao;


import edu.mum.mpp.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


@Repository
public class EmailDao extends AbstractDao<EmailDetails> {

    private SimpleJdbcCall queueEmail, getEmailsToSend, updateEmailStatus;

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "internetBankingDS") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        queueEmail = new SimpleJdbcCall(jdbcTemplate).withProcedureName("queueEmail").withReturnValue();
        updateEmailStatus = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updateEmailStatus").withReturnValue();
        getEmailsToSend = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getEmailsToSend")
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(EmailDetails.class));
    }

    public void QueueMessage(String sender, String recipient, String subject, String contentType, String content) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("sender", sender)
                .addValue("recipient", recipient)
                .addValue("subject", subject)
                .addValue("contentType", contentType)
                .addValue("content", content);

        this.queueEmail.execute(in);
    }

    public void UpdateEmailStatus(long id, int status) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("status", status);

        this.updateEmailStatus.execute(in);
    }

    public List<EmailDetails> GetEmailsToSend() {

        Map<String, Object> m = this.getEmailsToSend.execute();
        List<EmailDetails> list = (List<EmailDetails>) m.get(MULTIPLE_RESULT);

        return list;
    }
}
