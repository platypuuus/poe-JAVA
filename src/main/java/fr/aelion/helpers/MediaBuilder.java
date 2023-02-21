package fr.aelion.helpers;

import fr.aelion.helpers.interfaces.Builder;
import fr.aelion.modeles.course.*;

import java.util.Optional;

public class MediaBuilder implements Builder<Media> {
    private String title;
    private String summary;
    private Float duration;
    private Author author;
    private String mediaType;

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public MediaBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MediaBuilder summary(String summary) {
        this.summary = summary;
        return this;
    }

    public MediaBuilder duration(Float duration) {
        this.duration = duration;
        return this;
    }

    public MediaBuilder author(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public Optional<Media> build() {
        Media media;

        switch (this.mediaType.toUpperCase()) {
            case "VIDEO":
                media = new Video();
                break;
            case "SLIDE":
                media = new Slide();
                break;
            case "DOCUMENT":
                media = new Document();
                break;
            default:
                media = new Video();
        }
        media.setTitle(this.title);
        media.setSummary(this.summary);
        media.setAuthor(this.author);
        media.setDuration(this.duration);

        return Optional.of(media);
    }
}
