package logic.dao;

import logic.models.Anime;
import logic.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnimeDao {
    public Anime findById(int id) {
        Session tmp = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return tmp.get(Anime.class, id);
    }

    public void save(Anime anime) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(anime);
        tx1.commit();
        session.close();
    }

    public void update(Anime anime) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(anime);
        tx1.commit();
        session.close();
    }

    public void remove(Anime anime) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(anime);
        tx1.commit();
        session.close();
    }



    public void remove_all() {
        for (Anime item: findAll()){
            remove(item);
        }
    }

    public List<Anime> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Anime> items = (List<Anime>)  session.createQuery("From Anime").list();
        session.close();
        return items;
    }
    public Anime get_anime(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Anime> items = (List<Anime>)  session.createQuery("From Anime").list();
        session.close();

        for(Anime item:items){
            if (item.getName().equals(name) ){
                return item;
            }
        }
        return null;
    }



}
