package com.ibm.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm.springboot.entity.Student;

@Mapper
public interface StudentDao {

	// 增
	void insertStudent(@Param("student") Student student);

	// 删
	void deleteStudentById(@Param("id") Integer id);

	// 改
	void updateStudent(@Param("student") Student student);

	// 查
	Student findStudentById(@Param("id") Integer id);

	List<Student> getAll();

	Integer countStudent();

	// 查询符合某条件的学生列表
	List<Student> getAllByCondition(@Param("condition") String condition, @Param("val") String val);

	List<Student> page(@Param("pageIndex") Integer pageIndex, @Param("pageNum") Integer pageNum);

}
