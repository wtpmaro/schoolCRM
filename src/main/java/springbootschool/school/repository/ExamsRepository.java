package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootschool.school.entity.StudentList;

public interface ExamsRepository extends JpaRepository <StudentList, Long>{
}
