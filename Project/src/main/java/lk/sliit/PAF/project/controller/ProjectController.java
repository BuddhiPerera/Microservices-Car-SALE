package lk.sliit.PAF.project.controller;

import lk.sliit.PAF.project.dao.ProjectDAOImpl;
import lk.sliit.PAF.project.dto.ProjectDTO;
import lk.sliit.PAF.project.model.ProjectModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/projects")
public class ProjectController {

        ProjectDAOImpl dao = ProjectDAOImpl.getInstance();

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<ProjectDTO> list() {
            return dao.listAll();
        }

        ProjectModel projectObj = new ProjectModel();
        @POST
        @Produces(MediaType.TEXT_PLAIN)
        public String insertProject(@FormParam("pubName") String publisherName,
                                 @FormParam("proName") String projectName,
                                 @FormParam("Email") String email,
                                 @FormParam("proStatus") String status,
                                 @FormParam("proLink") String link,
                                 @FormParam("proUpDate") String updatedDate,
                                 @FormParam("proSubDate") String submittedDate,
                                 @FormParam("proDesc") String Description) {
            String output = projectObj.insertProject(publisherName, projectName, email, status, link, updatedDate, submittedDate,Description);
            System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd");
            return output;
        }

        /*  @POST
          @Consumes(MediaType.APPLICATION_JSON)
          public Response add(Product product) throws URISyntaxException {

              System.out.println("ssssssssssssssssssssssssssssssssssssssssssssss");
              int newProductId = dao.add(product);
              URI uri = new URI("/products/" + newProductId);
              return Response.created(uri).build();
          }
      */
        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response get(@PathParam("id") int id) {
            ProjectDTO project = dao.get(id);
            if (project != null) {
                return Response.ok(project, MediaType.APPLICATION_JSON).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }

        @DELETE
        @Path("{id}")
        public Response delete(@PathParam("id") int id) {
            if (dao.delete(id)) {
                return Response.ok().build();
            } else {
                return Response.notModified().build();
            }
        }
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Path("{id}")
        public Response update(@PathParam("id") int id, ProjectDTO project) {
            project.setId(id);
            if (dao.update(project)) {
                return Response.ok().build();
            } else {
                return Response.notModified().build();
            }
        }
    }

