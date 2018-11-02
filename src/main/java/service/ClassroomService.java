package service;

public interface ClassroomService {

    String getClassrooms();

    String addClassroom(String classroom);

    String deleteClassroom(Long id);

    String getClassroom(Long id);

}
