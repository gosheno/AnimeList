package logic.dao;

import logic.models.User;
import logic.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class UserDao {

    public User findById(int id) {
        Session tmp = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return tmp.get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(user);
        tx1.commit();
        session.close();
    }

    public void remove(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(user);
        tx1.commit();
        session.close();
    }
    public void remove_all() {
        for (User item: findAll()){
            remove(item);
        }
    }


    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>)  session.createQuery("From User").list();
        session.close();
        return users;
    }
    public User get_user(String name, String password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where name = :paramName and password = :paramPassword");

        query.setParameter("paramName", name);
        query.setParameter("paramPassword", password);

        User user = (User)query.uniqueResult();
        session.close();
        return user;
    }

}
