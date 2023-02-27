package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class DtoMapperTest {
    private DtoMapper dtoMapper;
    private Media video = new Video();
    private MediaListDto dto = new MediaListDto();

    @BeforeEach
    void setUp() {
        dtoMapper = new DtoMapper();
    }

    @Test
    void map() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MediaListDto mappedDto = (MediaListDto)dtoMapper.map(video,dto);
        assertEquals(video.getTitle(),mappedDto.title);
    }
}