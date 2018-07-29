package springbootschool.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootschool.school.entity.Exams;
import springbootschool.school.entity.StudentList;
import springbootschool.school.repository.ExamsRepository;
import springbootschool.school.repository.StudentListRepository;

import java.util.List;

@Service
public class SearchOptions {

    @Autowired
    StudentListRepository studentListRepository;

    @Autowired
    ExamsRepository examsRepository;

    public List<StudentList> searchUser(int value, String criteria) {

        switch (value) {
            case 1:
                return studentListRepository.findAllByCityNameLikeOrderBySurname(criteria);
            case 2:
                String[] splitted = criteria.trim().split("\\s+");
                String firstName = splitted[0];
                String surName = splitted[1];

                return studentListRepository.findAllByNameLikeAndSurnameLike(firstName, surName);

            case 3:
                return studentListRepository.findAllByEmailAddressContainingOrderBySurnameAscNameAsc(criteria);

            case 4:
                return studentListRepository.findAllByMobilePhoneLikeOrderBySurnameAscNameAsc(Integer.parseInt(criteria));

            case 5:
                return studentListRepository.findAllByStudentCodeLikeOrderBySurnameAscNameAsc(criteria);
            default:
                return studentListRepository.findAll();
        }

    }

    public  List<Exams> searchExam (int value, String criteria) {

        switch (value) {
            case 1:
                return examsRepository.findAllByNameLike(criteria);
            case 2:
                String[] splitted = criteria.trim().split("\\s+");
                String firstName = splitted[0];
                String surName = splitted[1];

                return examsRepository.findAllByStudentList_NameAndStudentList_Surname(firstName, surName);

            case 3:
                return examsRepository.findAllByExamSubject_SubjectName(criteria);

            case 4:
                return examsRepository.findAllByGroup(criteria);

            case 5:
                return examsRepository.findAllByGradeEquals(Double.parseDouble(criteria));
            default:
                return examsRepository.findAll();
        }
    }
}

