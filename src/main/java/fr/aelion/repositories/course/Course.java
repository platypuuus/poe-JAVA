package fr.aelion.repositories.course;

import fr.aelion.modeles.course.Media;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private Set<Media> medias = new HashSet<>();
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public void removeMedia(Media media) {
        this.medias.remove(media);
    }
}
