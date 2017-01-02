package com.gp.spring.dependency.model;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		/*Address a = new Address();
		
		a.setCity("Bangalore");
		a.setCountry("India");
		a.setPinCode(560066);
		a.setState("Karnataka");*/
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("D:/Eclipse_Workspace/Example/Spring_Dependency_Injection/beans.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath: beans.xml");
		Resource r = new ClassPathResource("beans.xml");
		BeanFactory c =  new XmlBeanFactory(r);
		Address a = (Address) c.getBean("address");
		
		Employee emp = new Employee();
		emp.setAddress(a);
		emp.setDepartment("MSP");
		emp.setId(11011941);
		emp.setName("Giriraj Patil");
		emp.setSalary(10000.00f);
		
		System.out.println("Emp Name ==>"+emp.getName());
		System.out.println("Emp Id ==>"+emp.getId());
		System.out.println("Emp Department ==>"+emp.getDepartment());
		System.out.println("Emp Salary ==>"+emp.getSalary());
		System.out.println("Emp City ==>"+emp.getAddress().getCity());
		System.out.println("Emp State ==>"+emp.getAddress().getState());
		System.out.println("Emp Pin Code ==>"+emp.getAddress().getPinCode());
		System.out.println("Emp Country ==>"+emp.getAddress().getCountry());
	}
}
