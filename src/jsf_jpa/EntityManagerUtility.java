package jsf_jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("StaffPersistenceUnit");

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
