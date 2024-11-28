package com.amanbahuguna.esd_mini_project.service;

import com.amanbahuguna.esd_mini_project.dto.LoginRequest;
import com.amanbahuguna.esd_mini_project.dto.assignStudentsRequest;
import com.amanbahuguna.esd_mini_project.helper.JWTHelper;
import com.amanbahuguna.esd_mini_project.model.CourseTA;
import com.amanbahuguna.esd_mini_project.model.Courses;
import com.amanbahuguna.esd_mini_project.model.Employees;
import com.amanbahuguna.esd_mini_project.model.Students;
import com.amanbahuguna.esd_mini_project.repo.CoursesRepo;
import com.amanbahuguna.esd_mini_project.repo.CoursesTARepo;
import com.amanbahuguna.esd_mini_project.repo.EmployeesRepo;
import com.amanbahuguna.esd_mini_project.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepo employeesRepo;
    private final CoursesRepo coursesRepo;
    private final StudentsRepo studentsRepo;
    private final EncryptionService encryptionService;
    private final CoursesTARepo coursesTARepo;
    private final JWTHelper jwtHelper;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }

    public Employees getEmployeeByEmpID(Long emp_id) {
        return employeesRepo.findById(emp_id)
                .orElse(null);
    }

    public Employees getEmployeeByEmail(String email) {
        return employeesRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));
    }

    public Employees createEmployee(Employees employees) {
        employees.setPassword(encryptionService.encode(employees.getPassword()));
        return employeesRepo.save(employees);
    }

    public List<Courses> getCourseByEmpId(long emp_id) {
        return coursesRepo.findByEmpId(emp_id);
    }

    public List<Students> getStudentsByRegisterTA(String courseId) {
        if(coursesRepo.findByCourseCodeEquals(courseId).isPresent()) {
            List<CourseTA> cta =  coursesTARepo.findByCourseCode(courseId);
            List<Students> students = new ArrayList<>();
            for(CourseTA courseTA : cta) {
                studentsRepo.findById(courseTA.getStudId()).ifPresent(students::add);
//                students.add(studentsRepo.findById(courseTA.getStudId()).orElse(null));
            }

            return students;
        }
        return new ArrayList<>();
    }

    public String assignStudents(assignStudentsRequest request) {
//        CourseTA courseTA = coursesTARepo.findById(courseTaId).orElse(null);
//
//        if(courseTA == null) {
//            coursesTARepo.save(courseTA);
//            return "Assigned";
//        }
//        return "Already Assigned";
        
        String rollNo = request.studRollNo();
        String courseCode = request.courseCode();
        int approved = request.approved();

        Optional<Students> stud = studentsRepo.findByRoll(rollNo);
        if(!stud.isPresent()) {
            return "Student not found";
        }

        Long studId = stud.get().getId();

        Optional<CourseTA> courseTAopt = coursesTARepo.findByCourseCodeAndStudId(courseCode,studId);
        if(courseTAopt.isPresent()){
            return "Already Assigned";
        }

        CourseTA courseTA = new CourseTA();
        courseTA.setCourseCode(courseCode);
        courseTA.setStudId(studId);
        courseTA.setApproved(approved);
        coursesTARepo.save(courseTA);

        return "Student Assigned";
    }


    public ResponseEntity<?> authenticate(LoginRequest loginRequest) {
//        Employees employee = employeesRepo.findByEmail(loginRequest.email())
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        if(!encryptionService.validates(loginRequest.password(), employee.getPassword())) {
//            throw new RuntimeException("Wrong password");
//        }
//        return employee;
        Employees employee = getEmployeeByEmail(loginRequest.email());
        if(!encryptionService.validates(loginRequest.password(), employee.getPassword())) {
            return null;
        }

//        return "Authenticate Successfully";

        employee.setJwtToken(jwtHelper.generateToken(loginRequest.email()));
        return ResponseEntity.ok(employee);
    }



//    public ResponseEntity<String> login(Employees employees) {
//
//    }
}
