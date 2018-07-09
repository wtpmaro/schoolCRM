package springbootschool.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springbootschool.school.entity.StudentList;

public interface StudentListRepository extends JpaRepository <StudentList, Long> {
}
