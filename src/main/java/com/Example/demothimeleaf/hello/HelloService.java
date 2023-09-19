package com.Example.demothimeleaf.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private HelloRepository repository;
	/**従業員を1件検索する*/
	public Employee getEmployee(String id) {
		//検索
		Map<String, Object> map = repository.findbayId(id);
		
		//mapから値を取得
		String employeeId = (String)map.get("id");
		String name = (String)map.get("name");
		int age = (Integer)map.get("age");
		//Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		
		return employee;
	}
}
