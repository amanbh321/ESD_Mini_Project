package com.amanbahuguna.esd_mini_project.repo;

import com.amanbahuguna.esd_mini_project.model.CourseTA;
import com.amanbahuguna.esd_mini_project.model.Courses;
import com.amanbahuguna.esd_mini_project.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoursesTARepo extends JpaRepository<CourseTA, Long> {

    @Query("SELECT p FROM CourseTA as p WHERE p.courseCode=:courseId AND p.approved=1")
    List<CourseTA> findByCourseCode(String courseId);

    Optional<CourseTA> findByCourseCodeAndStudId(String courseCode, Long studId);
}
