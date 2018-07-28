package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootschool.school.entity.Exams;

import java.util.List;

public interface ExamsRepository extends JpaRepository <Exams, Long>{

    @Query("Select e from Exams e join e.studentList p Where p.name= :studentName")
    List<Exams> findAllByPublisher(@Param("studentName") String studentName);

}



/*
    @Query("Select b from Book b join b.publisher p Where p.name= :publisherName")
    List<Book> findAllByPublisher(@Param("publisherName") String publisherName );*/
