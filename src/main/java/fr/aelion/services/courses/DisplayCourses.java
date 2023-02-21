package fr.aelion.services.courses;

import fr.aelion.repositories.course.Course;

public class DisplayCourses {
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void display() {
        System.out.println("Course : " + course.getTitle());
        course.getMedias().forEach(m -> {
            System.out.println("Media : " + m.getTitle());
        });
    }
}
