package jsf_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class StaffDAOImpl implements StaffDAO {
	private EntityManager entityManager;

	public StaffDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Staff createStaff(Staff staff) {
		entityManager.getTransaction().begin();
		entityManager.persist(staff);
		entityManager.getTransaction().commit();
		return staff;
	}

	@Override
	public Staff findStaff(int id) {
		return entityManager.find(Staff.class, id);
	}

	@Override
	public List<Staff> findAllStaff() {
		TypedQuery<Staff> query = entityManager.createQuery("Select e from Staff e", Staff.class);
		return query.getResultList();
	}

	@Override
	public void removeStaff(int id) {
		Staff staff = findStaff(id);
		if (staff != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(staff);
			entityManager.getTransaction().commit();
		}

	}

}
