package jsf_jpa;

import java.util.List;

public class StaffServiceImpl {
	private static StaffDAOImpl staffDAOImpl;

	public StaffServiceImpl() {
		staffDAOImpl = new StaffDAOImpl();
	}

	public static StaffDAOImpl getStaffDAOImpl() {
		return staffDAOImpl;
	}

	public static void setStaffDAOImpl(StaffDAOImpl staffDAOImpl) {
		StaffServiceImpl.staffDAOImpl = staffDAOImpl;
	}

	public Staff createStaff(Staff staff) {
		return getStaffDAOImpl().createStaff(staff);
	}

	public Staff findStaff(int id) {
		return getStaffDAOImpl().findStaff(id);
	}

	public List findAllStaffs() {
		return getStaffDAOImpl().findAllStaff();

	}

	public void removeStaff(int id) {
		getStaffDAOImpl().removeStaff(id);
	}
}
