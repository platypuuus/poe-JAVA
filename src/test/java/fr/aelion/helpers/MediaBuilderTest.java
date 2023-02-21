package fr.aelion.helpers;

import fr.aelion.modeles.course.Author;
import fr.aelion.modeles.course.Media;
import fr.aelion.modeles.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MediaBuilderTest {
    private MediaBuilder MB = new MediaBuilder();
    private MediaBuilder badMB = new MediaBuilder();

    @BeforeEach
    void setUp() {
        MB.setMediaType("video");
        MB.title("test")
                .summary("c'est le test, il est la")
                .author(new Author())
                .duration(3.15F);

        badMB.setMediaType("document");
        badMB
                .author(new Author())
                .summary(("juste un résumé"));
    }

    @Test
    @DisplayName("the media build should be video")
    void build() {
        try{
            Media media = MB.build();
            assertTrue(MB.build() instanceof Video);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Title should be Test")
    void titleAttributeTest() {
        try{
        Media video = MB.build();
        assertEquals(video.getTitle(), "test");
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    @Test
    @DisplayName("all attribute should be correct")
    void AttributeTest() {
        try{
        Media video = MB.build();
        Float duration = 3.15F;
        assertAll(
                () -> assertEquals("test", video.getTitle()),
                () -> assertEquals("c'est le test, il est la", video.getSummary()),
                () -> assertTrue(video.getAuthor() instanceof Author),
                () -> assertEquals(duration, video.getDuration())
        );
    } catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
    @Test
    @DisplayName("not enough arg chould raise an exception")
    void notEnoughAttributeTest() {
        assertThrows(Exception.class,()-> badMB.build());
    }
    @Test
    @DisplayName("no type should raise an exception")
    void noTypeAttributeTest() {
        MediaBuilder bad = new MediaBuilder();
        bad.title("test")
                .summary("c'est le test, il est la")
                .author(new Author())
                .duration(3.15F);

        assertThrows(Exception.class,()-> badMB.build());
    }

}