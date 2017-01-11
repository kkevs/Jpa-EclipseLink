package first_eclipseLink;

import java.util.List;

public interface EmployeeDao {
	public Employee insertEmployee(int id, String name, String surname, int salary);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);

	public Employee raiseEmployeeSalary(int id, int raise);

}
