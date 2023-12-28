package logic.services;

import logic.dao.AnimeDao;
import logic.models.Anime;

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

    public Anime getAnime(String name) {
        return animeDao.get_anime(name);
    };
    public void remove_all(){animeDao.remove_all();};


}
