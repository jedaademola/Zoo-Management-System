package edu.mum.mpp.dao;


import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Lukman.Arogundade on 10/18/2016.
 */

@Repository
public class UserDao extends AbstractDao<User> {
    private SimpleJdbcCall findByUsername, updateLogin, getUserPreviousPasswords, changeUserPassword,
            loginUser, isUserExists, findUsers, lockLogin, updateFailedLogin, unlockLogin,
            getUserByParameter, updatePassword, activateDeactivate, findUserByCategory;

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "DS") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
/*
        create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_user").withReturnValue();
        update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_user").withReturnValue();
        delete = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_user").withReturnValue();
        loginUser = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_user").
                returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));



        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_user")
                .returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));

        updateLogin = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_login").withReturnValue();

        updateRetailLogin = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updateRetailLogin").withReturnValue();

        lockLogin = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_lock").withReturnValue();
        update_failed_login = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_failed_login").withReturnValue();



        unlockLogin = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_unlock").withReturnValue();


        getUserPreviousPasswords = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_user_previous_passwords")
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));

        changeUserPassword = new SimpleJdbcCall(jdbcTemplate).withProcedureName("change_user_password").withReturnValue();
        updatePassword = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updatePassword").withReturnValue();
        isUserExists = new SimpleJdbcCall(jdbcTemplate).withProcedureName("is_user_exists").
                returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));



        findUsers = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_users")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));

        findByUsername = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_user_by_username")
                .returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));


        getUserByParameter = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_user_by_parameter")
                .returningResultSet(SINGLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));


        activateDeactivate = new SimpleJdbcCall(jdbcTemplate).withProcedureName("change_user_status").withReturnValue();

        getDomains = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getDomains")
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(Domain.class));
        getCorporateInstitution = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getCorporateInstitution")
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(CorporateInstitution.class));

        findUserByCategory = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_users_category")
                .returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, BeanPropertyRowMapper.newInstance(User.class));

*/
    }


    public User find(Long userId) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("id", userId);
        Map<String, Object> m = find.execute(in);
        List<User> result = (List<User>) m.get(SINGLE_RESULT);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public void updateLogin(String username, Boolean passwordMatched) throws DataAccessException {
        int loginAttemptsConfig = 5;//TODO PUT IN CONFIG FILE
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("username", username)
                .addValue("password_matched", passwordMatched)
                .addValue("loginAttemptsConfig", loginAttemptsConfig);
        updateLogin.execute(in);
    }


    public void lockLogin(long userId) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("userId", userId);
        lockLogin.execute(in);
    }

    public void unlockLogin(long userId) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("userId", userId);
        unlockLogin.execute(in);
    }

    public User findByUsername(String username) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username);
        Map<String, Object> m = findByUsername.execute(in);
        List<User> result = (List<User>) m.get(SINGLE_RESULT);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public User getUserByParameter(String username) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username);
        Map<String, Object> m = getUserByParameter.execute(in);
        List<User> result = (List<User>) m.get(SINGLE_RESULT);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public Page<User> findUsers(long pageNum, long pageSize, long userId) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize)
                .addValue("userId", userId);

        Map m = this.findUsers.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<User> page = new Page(count, content);
        return page;
    }


    public void updateFailedLogin(String username) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username);
        updateFailedLogin.execute(in);
    }

    public List<User> getUserPreviousPasswords(long userId) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
        Map<String, Object> m = getUserPreviousPasswords.execute(params);
        return (List<User>) m.get(MULTIPLE_RESULT);
    }

    public long changePassword(long userId, String password) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("userId", userId).addValue("password", password);
        Map<String, Object> m = changeUserPassword.execute(in);
        return (Long) m.get("userid");
    }


    public long updatePassword(long userId, String password) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("userId", userId).addValue("password", password);
        Map<String, Object> m = updatePassword.execute(in);
        return (Long) m.get("userid");
    }

    public User loginUser(long id) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("id", id);
        Map<String, Object> m = loginUser.execute(in);
        List<User> result = (List<User>) m.get(SINGLE_RESULT);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }


    public User isUserExists(String email, String mobileNumber) throws DataAccessException {
        MapSqlParameterSource in = (new MapSqlParameterSource())
                .addValue("email", email)
                .addValue("phoneNumber", mobileNumber);
        Map m = this.isUserExists.execute(in);
        List<User> result = (List<User>) m.get(SINGLE_RESULT);
        return !result.isEmpty() ? result.get(0) : null;
    }

    public void activateDeactivate(String username, int state) throws DataAccessException {
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username).addValue("active", state);
        activateDeactivate.execute(in);
    }


    public Page<User> findUserByCategory(long pageNum, long pageSize, String category, long userId) throws DataAccessException {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("page_num", pageNum)
                .addValue("page_size", pageSize)
                .addValue("category", category)
                .addValue("userId", userId);

        Map m = this.findUserByCategory.execute(params);
        List content = (List) m.get("list");
        Long count = (Long) ((List) m.get("count")).get(0);
        Page<User> page = new Page(count, content);
        return page;
    }


}
