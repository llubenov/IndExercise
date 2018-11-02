package rest;

import service.ClassroomService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/classroom")
public class ClassroomEndpoint {

    @Inject
    private ClassroomService service;

    @Path("/getClassrooms")
    @GET
    @Produces({"application/json"})
    public String getClassrooms() {
        return service.getClassrooms();
    }

    @Path("/json/{id}")
    @GET
    @Produces({"application/json"})
    public String getClassroom(@PathParam("id") Long id) {
        return service.getClassroom(id);
    }

    @Path("/json")
    @POST
    @Produces({"application/json"})
    public String addClassroom(String movie) {
        return service.addClassroom(movie);
    }

    @Path("/json/{id}")
    @DELETE
    @Produces({"application/json"})
    public String deleteClassroom(@PathParam("id") Long id) {
        return service.deleteClassroom(id);
    }

    public void setService(ClassroomService service) {
        this.service = service;
    }

}


