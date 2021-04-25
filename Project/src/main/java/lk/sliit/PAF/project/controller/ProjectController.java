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
    ProjectModel model = new ProjectModel();

    @GET
    @Path("/getprojects")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectDTO> list() throws Exception {

        return model.listAll();
    }

    ProjectModel projectObj = new ProjectModel();



    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void updateProduct(ProjectDTO projectDTO) {
        System.out.println(projectDTO);

        projectObj.updateProject(projectDTO.getProjectID(),projectDTO.getPublisherName(), projectDTO.getProjectName(),
                projectDTO.getEmail(),projectDTO.getStatus(),projectDTO.getLink(),projectDTO.getUpdatedDate(),projectDTO.getSubmittedDate(),projectDTO.getdescription());

    }



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
        String output = projectObj.insertProject(publisherName, projectName, email, status, link, updatedDate, submittedDate, Description);
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
    @Path("/delete/{id}")
    public void delete(@PathParam("id") String id) {

        System.out.println("dddddddddddddddddddddrrrrrrrrrrrrddddddddddddddd " + id);
        model.deleteProject(id);
    }
}

