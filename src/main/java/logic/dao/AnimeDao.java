package logic.dao;

import logic.models.Anime;
import logic.models.User;
import logic.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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
    public Anime getAnime(String name, User user) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Anime where user.id = :paramId and name = :paramName" );
        session.close();
        query.setParameter("paramId", user.getId());
        query.setParameter("paramName", name);
        return (Anime)query.uniqueResult();
    }


    public List<String> getAnimeNamesAll() {
        List<String> animeNames = new ArrayList<>();
        for (Anime anime : findAll()) {
            animeNames.add(anime.getName());
        }
        return animeNames;

    }

    public List<String> getAnimeNamesUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Anime where user.id = :paramid");
        query.setParameter("paramid", user.getId());
        List<Anime> animeList = query.list();
        session.close();
        List<String> animeNames = new ArrayList<>();
        for (Anime anime : animeList) {
            System.out.println(anime.getName());
            animeNames.add(anime.getName());
        }
        return animeNames;
    }

}
