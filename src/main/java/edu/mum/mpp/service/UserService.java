package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.UserDao;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(@Qualifier("userDao") AbstractDao<User> dao) {
        super(dao);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    public User find(long userId) {

        UserDao userDao = (UserDao) dao;
        return userDao.find(userId);
    }

    public User findByUsername(String username) {
        UserDao userDao = (UserDao) dao;
        return userDao.findByUsername(username);
    }


    public Page<User> findUsers(long pageNum, long pageSize, long userId) {
        UserDao userDao = (UserDao) dao;
        return userDao.findUsers(pageNum, pageSize, userId);
    }

    public void updateLogin(String username, Boolean passwordMatched) {
        UserDao userDao = (UserDao) dao;
        userDao.updateLogin(username, passwordMatched);
    }


    public void lockLogin(long userId) {
        UserDao userDao = (UserDao) dao;
        userDao.lockLogin(userId);
    }

    public void unlockLogin(long userid) {
        UserDao userDao = (UserDao) dao;
        userDao.unlockLogin(userid);
    }

    public void updateFailedLogin(String username) {
        UserDao userDao = (UserDao) dao;
        userDao.updateFailedLogin(username);
    }


    public Boolean passwordUsedRecently(long userId, String password) {
        UserDao userDao = (UserDao) dao;
        List<User> passwords = userDao.getUserPreviousPasswords(userId);
        for (User user : passwords) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public long changePassword(long userId, String password) {
        UserDao userDao = (UserDao) dao;
        String encoded = passwordEncoder.encode(password);
        return userDao.changePassword(userId, encoded);
    }

    public long updatePassword(long userid, String password) {
        UserDao userDao = (UserDao) dao;
        String encoded = passwordEncoder.encode(password);
        return userDao.updatePassword(userid, encoded);
    }


    public User loginUser(String username, String password) {
        UserDao userDao = (UserDao) dao;
       /* String convertId = AES.decrypt(username);

        if (convertId == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Invalid Encrypted data");
        }
*/
        User user = userDao.loginUser(1);

        if (null == user) {
            return null;
        } else {
            if (passwordEncoder.matches(password, user.getPassword())) {

                user.setLoginStatus(true);
            } else {
                user.setLoginStatus(false);
            }

            return user;
        }

    }

    @Override
    public void update(User user) {
        super.update(user);
    }


    public User isUserExists(String email, String mobileNumber) {
        UserDao userDao = (UserDao) dao;
        return userDao.isUserExists(email, mobileNumber);
    }
}
