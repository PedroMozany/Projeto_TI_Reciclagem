package com.projeto.seletinha.repository;

import com.projeto.seletinha.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<StudentModel, Integer> {


    <Student extends StudentModel> Student save(Student entity);

    List<StudentModel> findAll();

    Optional<StudentModel> findById(Integer registry);

    void deleteById(int id);

    List<StudentModel> findByTeam(int team);

    @Query(value = "select * from student where series = ?1 group by team", nativeQuery = true)
    List<StudentModel> findBySeries(int series);

}
