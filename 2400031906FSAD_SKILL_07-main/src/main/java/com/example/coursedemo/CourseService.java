package com.example.coursedemo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public Course updateCourse(int id, Course updatedCourse) {

        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }

        return null;
    }

    public boolean deleteCourse(int id) {

        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        return result;
    }
}