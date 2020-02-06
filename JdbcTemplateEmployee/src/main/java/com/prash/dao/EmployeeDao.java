package com.prash.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.prash.model.EmployeeModel;

@Repository("employeeDao")
public class EmployeeDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public List<EmployeeModel>  getAllEmployees() {   	
	   	
    	List<EmployeeModel> employees = template.query("select * from employee",
			    new RowMapper() {         // RowMapper
			        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	EmployeeModel std = new EmployeeModel();
			        	std.setEid((rs.getInt("eid")));
			        	std.setFname(rs.getString("fname"));
			        	std.setLname(rs.getString("lname"));
			        	std.setAge(((rs.getInt("age"))));
			        	std.setDid(((rs.getInt("did"))));
			        	std.setSalary(((rs.getInt("salary"))));
			            return std;
			        }

					public int[] getRowsForPaths(TreePath[] path) {
						// TODO Auto-generated method stub
						return null;
					}
			    });
         return employees;
    }    
	
		
		
		
	
	

}
