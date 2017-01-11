package first_eclipseLink;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeTest {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDao employeeService = new EmployeeDaoImpl(entityManager);

		entityTransaction.begin();
		Employee employee = employeeService.insertEmployee(1, "Levent", "Erguder", 1000);
		Employee employee2 = employeeService.insertEmployee(2, "James", "Gosling", 10000);
		Employee employee3 = employeeService.insertEmployee(3, "Joshua", "Bloch", 10000);
		entityTransaction.commit();

		System.out.println("Persisted :" + employee);
		System.out.println("Persisted :" + employee2);
		System.out.println("Persisted :" + employee3);

		Employee employee4 = employeeService.findEmployee(1);
		System.out.println("Found : " + employee4);

		entityTransaction.begin();
		Employee employee5 = employeeService.raiseEmployeeSalary(1, 1000);
		entityTransaction.commit();

		System.out.println("Updated : " + employee5);

		entityTransaction.begin();
		employeeService.removeEmployee(1);
		entityTransaction.commit();

		System.out.println("findAllEmployees");
		List<Employee> employees = employeeService.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println("Found : " + emp);
		}

	}
}
