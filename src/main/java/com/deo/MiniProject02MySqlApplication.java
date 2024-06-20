package com.deo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.deo.controller.PayrollOperationsController;
import com.deo.model.Employee;

@SpringBootApplication
public class MiniProject02MySqlApplication {

	public static void main(String[] args) {
		//get IOC Container
				ApplicationContext ctx = SpringApplication.run(MiniProject02MySqlApplication.class, args);
				//get Controller  class obj ref
				PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
				//invoke the business method
				try 
				{
					List <Employee> list = controller.showEmployeesByDesigs("CLERK", "MANAGER", "SALES");
					
					list.forEach(emp->
					{
						System.out.println(emp);
					});
					
					
				}//try block ended
				catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Internal Problem -- try again ::"+e.getMessage());
				}//catch block ended
				
			//close the IOC Container
				((ConfigurableApplicationContext) ctx).close();
	}

}
