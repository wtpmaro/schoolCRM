package springbootschool.school.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Exams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "subject_id")
    private ExamSubject examSubject;

    @NotEmpty
    private String name;

    @NotNull
    @Min(0)
    private Double result;

    @NotNull
    @Min(1)
    @Max(6)
    private Double grade;

    @NotEmpty
    @Size(min = 3, max = 256)
    private String description;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "studentList_id")
    private StudentList studentList;

    public Exams() {}

    public ExamSubject getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(ExamSubject examSubject) {
        this.examSubject = examSubject;
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public void setStudentList(StudentList studentList) {
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
