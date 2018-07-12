package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootschool.school.entity.ExamSubject;

@Repository
public interface ExamSubjectRepository extends JpaRepository<ExamSubject, Long> {
}
