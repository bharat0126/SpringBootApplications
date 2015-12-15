package hello;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mongodb.config.MongoDBConfig1;
import com.mongodb.config.MongoDBConfig2;
import com.mongodb.entity.Customer;
import com.mongodb.entity.Employee;
import com.mongodb.repo1.EmployeeRepository;
import com.mongodb.repo2.CustomerRepository;

public class Main {
	public static void main(String[] args) {
		   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(MongoDBConfig1.class);
	       ctx.register(MongoDBConfig2.class);
	       ctx.refresh();
	       
	       CustomerRepository customerRepository=ctx.getBean(CustomerRepository.class);
	       Customer customer=new Customer("Bharat", "Verma");
	       customerRepository.deleteAll();
	       customerRepository.save(customer);
	       
	       EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
	       Employee ram = new Employee(1,"Ram",20);
	       Employee shyam = new Employee(2,"Shyam",19);
	       Employee mohan = new Employee(3,"Mohan",20);
	       Employee krishn = new Employee(4,"Krishn",20);
    	   //Delete if exists already
    	   employeeRepository.deleteAll();
    	   //Save employee
    	   employeeRepository.save(ram);
    	   employeeRepository.save(shyam);
    	   employeeRepository.save(mohan);
    	   employeeRepository.save(krishn);
    	   //Get employee By Name
    	   Employee emp = employeeRepository.getEmployeeByName(shyam.name);
    	   System.out.println(emp.name);
    	   //Fetch all employee for the age
    	   List<Employee> employees = employeeRepository.getEmployeeByAge(20);
    	   System.out.println("----employee for the age 20----");
    	   for (Employee employee : employees) {
			System.out.println("Id:"+employee.id+",Name:"+employee.name);
		   }
	   }
}
