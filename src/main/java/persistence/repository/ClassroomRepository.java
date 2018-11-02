package persistence.repository;

public interface ClassroomRepository {

	String getClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(Long id);
	String getClassroom(Long id);

}