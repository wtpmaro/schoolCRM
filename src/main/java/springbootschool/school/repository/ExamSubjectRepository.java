package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootschool.school.entity.ExamSubject;

import java.util.List;

@Repository
public interface ExamSubjectRepository extends JpaRepository<ExamSubject, Long> {

    List<ExamSubject> findAllBySubjectNameContaining(String subjectName);
}
