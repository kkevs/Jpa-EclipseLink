package first_eclipseLink;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee insertEmployee(int id, String name, String surname, int salary) {
		Employee employee = new Employee(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("Select e from Employee e");
		return query.getResultList();
	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityManager.remove(employee);
		}
	}

	@Override
	public Employee raiseEmployeeSalary(int id, int raise) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;
	}

}
