package fr.aelion.helpers;

import fr.aelion.modeles.course.Author;
import fr.aelion.modeles.course.Media;
import fr.aelion.modeles.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaBuilderTest {
    private MediaBuilder MB = new MediaBuilder();

    @BeforeEach
    void setUp() {
        MB.setMediaType("video");
        MB.title("test")
                .summary("c'est le test, il est la")
                .author(new Author())
                .duration(3.15F);
    }

    @Test
    @DisplayName("the media build should be video")
    void build() {
        assertTrue(MB.build() instanceof Video);
    }

    @Test
    @DisplayName("Title should be Test")
    void titleAttributeTest() {
        Media video = MB.build();
        assertEquals(video.getTitle(), "test");
    }

    @Test
    @DisplayName("all attribute should be correct")
    void AttributeTest() {
        Media video = MB.build();
        Float duration = 3.15F;
        assertAll(
                () -> assertEquals("test", video.getTitle()),
                () -> assertEquals("c'est le test, il est la", video.getSummary()),
                () -> assertTrue(video.getAuthor() instanceof Author),
                () -> assertEquals(duration, video.getDuration())
        );
    }


}