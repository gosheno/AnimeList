package logic.services;

import logic.dao.AnimeDao;
import logic.models.Anime;
import logic.models.User;

import java.util.List;

public class AnimeService {

    private AnimeDao animeDao = new AnimeDao();
    public AnimeService() {
    }

    public Anime findAnime(int id) {
        return animeDao.findById(id);
    }

    public void saveAnime(Anime anime) {
        animeDao.save(anime);
    }

    public void deleteAnime(Anime anime) {
        animeDao.remove(anime);
    }

    public void updateAnime(Anime anime) {
        animeDao.update(anime);
    }

    public List<Anime> findAllAnime() {
        return animeDao.findAll();
    }

    public Anime findAnimeById(int id) {return animeDao.findById(id);}

    public Anime getAnime(String name, User user) {
        return animeDao.getAnime(name, user);
    };
    public void remove_all(){animeDao.remove_all();};

    public List<String> getAnimeListAll(){return animeDao.getAnimeNamesAll();}

    public List<String> getAnimeListUser(User user){return animeDao.getAnimeNamesUser(user);}

    public List<Anime> getaAnimeListById(int id){return animeDao.getAnimeListId(id);}

}
