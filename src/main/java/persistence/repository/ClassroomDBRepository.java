package persistence.repository;


import persistence.domain.Classroom;
import persistence.domain.Trainee;
import util.JSONUtil;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getClassrooms() {
		Query query = manager.createQuery("SELECT a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String jsonMovie) {
		Classroom aClassroom = util.getObjectForJSON(jsonMovie, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"Classroom has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}
	
	public String getClassroom(Long id) {
		Classroom aClassroom =  manager.find(Classroom.class, id);
		return util.getJSONForObject(aClassroom);
	}

	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}
