package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootschool.school.entity.Exams;

public interface ExamsRepository extends JpaRepository <Exams, Long>{
}
