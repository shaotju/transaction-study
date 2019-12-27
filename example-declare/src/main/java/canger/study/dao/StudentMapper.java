package canger.study.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
    @Update("update student set age=#{age} where id=#{id}")
    void updateStudentAge(@Param("age") int age, @Param("id") int id);
    @Update("update student set name=#{name} where id=#{id}")
    void updateStudentName(@Param("name") String name,@Param("id") int id);
}
