package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeBo;
import com.nt.dao.EmployeDao;
import com.nt.dto.EmployeDto;

public class EmployeService {

	private EmployeDao dao;

	public EmployeService(EmployeDao dao) {
		super();
		this.dao = dao;
	}
	
	public String insertRecords(EmployeDto dto) {
		EmployeBo bo=new EmployeBo();
		
		BeanUtils.copyProperties(dto,bo);
		System.out.println(bo.getDeptNo());
		int count=dao.insertRecords(bo);
		String str=null;
		if(count==1) {
			str="Records are Successfully Inserted...";
		}else{
			str="Records are not Inserted...";
		}
		return str;	
	}
	
	
	public List<EmployeDto> fetchEmployes(){
		
		List<EmployeBo> lebo=dao.getRecords();
		List<EmployeDto> dto=null;
		dto=new ArrayList<EmployeDto>();
		
		for(EmployeBo bo:lebo) {
		
			EmployeDto edto=new EmployeDto();
		    BeanUtils.copyProperties(bo, edto);
		    dto.add(edto);
		
		}
		
		return dto;
		
	}
	
	public EmployeDto getEmployeById(int empNo) {
		EmployeBo bo=dao.getRecordsById(empNo);
		EmployeDto dto=new EmployeDto();
		BeanUtils.copyProperties(bo, dto);
		return dto;
		
	}
	
	
	public String updateRecords(EmployeDto dto) {
		EmployeBo bo=new EmployeBo();
		
		BeanUtils.copyProperties(dto,bo);
		System.out.println(bo.getDeptNo());
		int count=dao.updateRecords(bo);
		String str=null;
		if(count==1) {
			str="Records are Successfully Edited...";
		}else{
			str="Records are not Edited...";
		}
		return str;	
	}
	
	public String deleteRecord(int empNo) {
		
		int count=dao.deleteRecordsByEmpNo(empNo);
		String str=null;
		if(count==1) {
			str="Records are Successfully Deleted...";
		}else{
			str="Records are not Edited...";
		}
		return str;	
	}
	
	
	
}
