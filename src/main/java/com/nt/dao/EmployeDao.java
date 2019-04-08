package com.nt.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.EmployeBo;

public class EmployeDao {
	
	private String INSERT_RECORDS="INSERT INTO EMPL(EMPNO,ENAME,JOB,MGR,SAL,COMM,DEPTNO) VALUES(?,?,?,?,?,?,?)";
    private String GET_RECORDS="SELECT EMPNO,ENAME,JOB,MGR,SAL,COMM,DEPTNO FROM EMPL";
    private String GET_RECORDS_BY_EMPNO="SELECT EMPNO,ENAME,JOB,MGR,SAL,COMM,DEPTNO FROM EMPL WHERE EMPNO=?";
    private String UPDATE_RECORDS="UPDATE EMPL SET ENAME=?,JOB=?,MGR=?,SAL=?,COMM=?,DEPTNO=?";
    private String DELETE_RECORDS_BY_EMPNO="DELETE FROM EMPL WHERE EMPNO=?";
    private JdbcTemplate jt;

	public EmployeDao(JdbcTemplate jt) {
		
		this.jt = jt;
	}
	
	
public int insertRecords(EmployeBo bo) {
	
	int count=0;
	count=jt.update(INSERT_RECORDS,bo.getEmpNo(),bo.getEname(),bo.getJob(),bo.getMgr(),bo.getSal(),bo.getComm(),bo.getDeptNo());
	return count;
}
	
	public List<EmployeBo> getRecords(){
		List<EmployeBo> lebo=jt.query(GET_RECORDS,(ResultSet rs)->{
            List<EmployeBo> lbo=new ArrayList<EmployeBo>();   
			
			while(rs.next()) {
				EmployeBo bo=new EmployeBo();
				
				bo.setEmpNo(rs.getInt(1));
            	bo.setEname(rs.getString(2));
            	bo.setJob(rs.getString(3));
            	bo.setMgr(rs.getInt(4));
            	bo.setSal(rs.getInt(5));
            	bo.setComm(rs.getInt(6));
            	bo.setDeptNo(rs.getInt(7));
            	
            	lbo.add(bo);
               }
			
			return lbo;
		});
		return lebo;
	}
	
	public EmployeBo getRecordsById(int empNo) {
		/*EmployeBo ebo=new EmployeBo();
		
		//private String GET_RECORDS_BY_EMPNO="SELECT EMPNO,ENAME,JOB,MGR,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO=?";

		EmployeBo empbo=jt.query(GET_RECORDS_BY_EMPNO, (ResultSet rs)->{
			
			while(rs.next()) {
				ebo.setEmpNo(rs.getInt(1));
				ebo.setEname(rs.getString(2));
				ebo.setJob(rs.getString(3));
				ebo.setMgr(rs.getInt(4));
				ebo.setSal(rs.getInt(5));
				ebo.setComm(rs.getInt(6));
				ebo.setDeptNo(rs.getInt(7));
			}
			return ebo;
			
		},empNo);
		return empbo;*/
		
		//private String GET_RECORDS_BY_EMPNO="SELECT EMPNO,ENAME,JOB,MGR,SAL,COMM,DEPTNO FROM EMP WHERE EMPNO=?";

		EmployeBo empbo=jt.queryForObject(GET_RECORDS_BY_EMPNO, (rs,index)->{
			
			EmployeBo ebo=new EmployeBo();

				ebo.setEmpNo(rs.getInt(1));
				ebo.setEname(rs.getString(2));
				ebo.setJob(rs.getString(3));
				ebo.setMgr(rs.getInt(4));
				ebo.setSal(rs.getInt(5));
				ebo.setComm(rs.getInt(6));
				ebo.setDeptNo(rs.getInt(7));
			
			return ebo;
			
		},empNo);
		return empbo;
		
		
		
		
		
	}
	
	public int updateRecords(EmployeBo bo) {
		
		//private String UPDATE_RECORDS="UPDATE EMPL SET EMPNO=?,ENAME=?,JOB=?,MGR=?,SAL=?,COMM=?,DEPTNO=?";
		int count=jt.update(UPDATE_RECORDS,bo.getEname(),bo.getJob(),bo.getMgr(),bo.getSal(),bo.getComm(),bo.getDeptNo());
		return count;
	}
	
	
	
public int deleteRecordsByEmpNo(int empNo) {
		
		//private String UPDATE_RECORDS="UPDATE EMPL SET EMPNO=?,ENAME=?,JOB=?,MGR=?,SAL=?,COMM=?,DEPTNO=?";
		int count;
				count=jt.update(DELETE_RECORDS_BY_EMPNO,empNo);
		return count;
	}
	
	
	
	
}
