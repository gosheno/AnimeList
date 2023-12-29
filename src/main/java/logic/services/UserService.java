package logic.services;

import logic.dao.UserDao;
import logic.models.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }
    public int  regcheck(String login){ return usersDao.is_regged(login);}

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.remove(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public User getUser(String name, String password) {
        return usersDao.get_user(name, password);
    };
    public void remove_all(){usersDao.remove_all();};



}
