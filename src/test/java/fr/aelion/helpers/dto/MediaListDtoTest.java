package fr.aelion.helpers.dto;

import fr.aelion.models.course.Author;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class MediaListDtoTest {
    private MediaListDto dto;
    Video video;

    @BeforeEach
    void setUp() {
        dto = new MediaListDto();
        video= new Video();
        video.setTitle("Title of Video");
        video.setDuration(5.35f);
        video.setSummary("résumé video");
        video.setAuthor(new Author());
    }
    @Test
    void deserialize() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        DtoMapper dtoMapper = new DtoMapper();

        dto = (MediaListDto) dtoMapper.map(video, dto);
        assertEquals("Title of Video",dto.title);
        assertAll(
                () -> assertEquals("Title of Video",dto.title),
                () -> assertEquals(video.getDuration(),dto.duration)
        );
    }
}