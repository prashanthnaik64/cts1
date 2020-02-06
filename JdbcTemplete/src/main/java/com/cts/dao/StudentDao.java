package com.cts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.model.Student;

@Repository("studentDao")
public class StudentDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	 
    public List<Student>  getAllStudents() {   	
   	
    	List<Student> students = template.query("select * from student", new RowMapper() {         // RowMapper
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		                  Student std = new Student();
			        	std.setSid((rs.getInt("id")));
			        	std.setName(rs.getString("name"));
			        	std.setAge(((rs.getInt("age"))));
			            return std;
			        }
			    });
         return students;
    }
    public int saveStudent(Student student) {
    	return template.update("insert into student values("+student.getSid()+",'"+student.getName()+"',"+student.getAge()+")");
    }
    
    public int deleteStudent(int sid) {
    	return template.update("delete from student where id="+sid+"");
    }
    
    public Student getStudent(int sid) {
		String sql = "select * from student where id=?";
		Student student = template.queryForObject(sql, new Object[] {sid}, new BeanPropertyRowMapper<Student>(Student.class));
		System.out.println("getStudent :: "+student);
		return student;
	}
    
    public int editStudent(Student student) {
    	String sql = "update student set name='"+student.getName()+"', age="+student.getAge()+" where id="+student.getSid()+"";
    	return template.update(sql);
    }

}
