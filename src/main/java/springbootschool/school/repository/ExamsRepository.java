package springbootschool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;

import java.util.List;

public interface ExamsRepository extends JpaRepository <Exams, Long>{

    @Query("Select e from Exams e join e.studentList p Where p.name= :studentName")
    List<Exams> findAllByName(@Param("studentName") String studentName);

    @Query("Select e from Exams e join e.studentList p Where p.groupNumber= :groupName")
    List<Exams> findAllByGroup(@Param("groupName") String groupName);

    @Query("Select e from Exams e join e.examSubject p Where p.subjectName= :subject")
    List<Exams> findAllBySubject(@Param("subject") String subject);


    List<Exams> findAllByNameLike(String signatureExam);

    List<Exams> findAllByExamSubject_SubjectName(String subjectName);

    List<Exams> findAllByStudentList_NameAndStudentList_Surname(String name,String surname);

    List<Exams> findAllByNameLikeOrderByStudentList_NameAsc(String name);

    List<Exams> findAllByStudentList_GroupNumber(String groupName);

    List<Exams> findAllByGradeEquals(Double grade);



}



/*
    @Query("Select b from Book b join b.publisher p Where p.name= :publisherName")
    List<Book> findAllByPublisher(@Param("publisherName") String publisherName );*/
