package fr.aelion.run;

import fr.aelion.modeles.course.Document;
import fr.aelion.modeles.course.Media;
import fr.aelion.modeles.course.Video;
import fr.aelion.modeles.course.Slide;
import fr.aelion.repositories.course.Course;
import fr.aelion.services.courses.DisplayCourses;

public class CourseRun {
    private Course course = new Course();

    public CourseRun() {
        this.course.setTitle("SQL");
        this.makeCourse();
    }

    public void run() {
        DisplayCourses displayCourses = new DisplayCourses();
        displayCourses.setCourse(this.course);
        System.out.println(displayCourses.displayBuilder());
    }

    private void makeCourse() {
        Media video = new Video();
        video.setTitle(("Create table"));

        Media slide = new Slide();
        slide.setTitle(("Alter table"));

        Media document = new Document();
        document.setTitle(("Drop table"));

        this.course.addMedia(video);
        this.course.addMedia(slide);
        this.course.addMedia(document);


    }
}
