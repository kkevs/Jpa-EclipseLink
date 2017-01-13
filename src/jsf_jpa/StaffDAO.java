package jsf_jpa;

import java.util.List;

public interface StaffDAO {
	public Staff createStaff(Staff staff);

	public Staff findStaff(int id);

	public List<Staff> findAllStaff();

	public void removeStaff(int id);
}
