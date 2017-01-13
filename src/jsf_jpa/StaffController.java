package jsf_jpa;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class StaffController {
	Staff staff = new Staff();
	private List<Staff> staffs = new ArrayList<>();

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public void addStaff() {
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.createStaff(staff);
		staffs = staffService.findAllStaffs();

	}

	public void deleteStaff(int id) {
		StaffServiceImpl staffService = new StaffServiceImpl();
		staffService.removeStaff(id);
		staffs = staffService.findAllStaffs();

	}
}
