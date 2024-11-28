package com.amanbahuguna.esd_mini_project.repo;

import com.amanbahuguna.esd_mini_project.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentsRepo extends JpaRepository<Students, Long> {
    Optional<Students> findById(Long studentId);
    @Query("SELECT s FROM Students s WHERE s.roll_no = :rollNo")
    Optional<Students> findByRoll(@Param("rollNo") String rollNo);
}
