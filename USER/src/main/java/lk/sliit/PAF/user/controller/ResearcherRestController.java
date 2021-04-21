package lk.sliit.PAF.user.controller;

import lk.sliit.PAF.user.dao.ResearcherDAOImpl;
import lk.sliit.PAF.user.dto.ResearcherDTO;
import lk.sliit.PAF.user.model.ResearcherModel;


import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/researcher")
public class ResearcherRestController {
    ResearcherDAOImpl researcherDAO = ResearcherDAOImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResearcherDTO> researcherDTOList(){
        return researcherDAO.listAll();
    }

    ResearcherModel researcherModel = new ResearcherModel();
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void insertResearcher(@FormParam("fName") String fName,
                                 @FormParam("lName") String lName,
                                 @FormParam("email") String email,
                                 @FormParam("contact") String contactNo,
                                 @FormParam("address") String address,
                                 @FormParam("zipcode") String zipCode,
                                 @FormParam("rate") String rate,
                                 @FormParam("pass") String pass){
        String output = researcherModel.insertBuyerDetail(fName,lName,email,contactNo,address,zipCode,rate,pass);
    }
}
