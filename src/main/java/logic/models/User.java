package logic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Anime> animes;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        animes = new ArrayList<>();
    }

    public void addAnime(Anime anime) {
        anime.setUser(this);
        animes.add(anime);
    }

    public void removeAuto(Anime anime) {
        animes.remove(anime);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPasswird(String name) {
        this.name = name;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password =" + password +
                '}';
    }
}