package springbootschool.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springbootschool.school.entity.StudentList;
import java.util.List;

public interface StudentListRepository extends JpaRepository <StudentList, Long> {

    List<StudentList>  findAllByCityNameLikeOrderBySurname(String cityName);
    List<StudentList> findAllByNameLikeAndSurnameLike(String name, String surname);
    List<StudentList> findAllByEmailAddressLikeOrderBySurnameAscNameAsc(String emailAddress);
    List<StudentList> findAllByStudentCodeLikeOrderBySurnameAscNameAsc(String studentCode);
    List<StudentList> findAllByMobilePhoneLikeOrderBySurnameAscNameAsc(int mobilePhone);

}
