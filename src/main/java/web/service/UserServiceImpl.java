package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showPeople() {
        return userDao.showPeople();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUserById(Long id) {
        return userDao.showUserById(id);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }
}
