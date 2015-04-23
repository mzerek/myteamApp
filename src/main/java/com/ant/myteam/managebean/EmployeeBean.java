package com.ant.myteam.managebean;

import java.io.File;
import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import com.ant.myteam.model.Employee;
import com.ant.myteam.service.EmployeeService;

@Component("employeeBean")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	static String mailboxDestinationOne = "mailbox-destination-one";
	static String mailboxDestinationTwo = "mailbox-destination-two";

	private Employee employee = new Employee();

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JmsTemplate jmsTemplate;

	private Employee emp1;
	private Employee emp2;

	public EmployeeBean() {
		emp1 = new Employee();
		emp1.setFirstName("Huong");
		emp1.setLastName("Nguyen");
		emp2 = new Employee();
		emp2.setFirstName("Khang");
		emp2.setLastName("Le");
	}

	public void addEmployee() {
		employeeService.addEmployee(emp1);
		employeeService.addEmployee(emp2);
		employee = employeeService.findEmployeeById(emp1.getEmpId());

		sendMessageForTwo();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private void sendMessageForTwo() {
		FileSystemUtils.deleteRecursively(new File("activemq-data"));

		// Send a message
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// session.createTopic("fajnyOne");
				return session.createTextMessage("Message from AppOne!");
			}
		};

		System.out.println("Sending a new message from AppOne.");
		jmsTemplate.send(mailboxDestinationOne, messageCreator);
	}

}
