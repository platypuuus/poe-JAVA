package fr.aelion.services.courses;

import fr.aelion.models.course.Media;
import fr.aelion.models.course.Video;
import fr.aelion.repositories.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCoursesTest {
    private DisplayCourses DC;
    private StringBuilder expectedOutput = new StringBuilder();

    @BeforeEach
    void setUp() {
        DC = new DisplayCourses();

        Course course = new Course();
        Media video = new Video();
        video.setTitle("titre vidéo");
        course.setTitle(("Titre du cours"));

        DC.setCourse(course);

        expectedOutput.append("Course : Titre du cours")
                .append("\n")
                .append("titre vidéo")
                .append("\n");
    }

    @Test
    @DisplayName("Should display the whole course")
    void displayBuilder() {
        assertEquals(expectedOutput.toString(), DC.displayBuilder());

    }
}