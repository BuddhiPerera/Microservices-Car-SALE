package lk.sliit.PAF.project.dao;




import lk.sliit.PAF.project.dto.ProjectDTO;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl {
    private static ProjectDAOImpl instance;
    private static List<ProjectDTO> data = new ArrayList<>();

    static {

    }



    public static ProjectDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProjectDAOImpl();
        }
        return instance;
    }

    public List<ProjectDTO> listAll() {
        return new ArrayList<>(data);
    }

    public int add(ProjectDTO product) {
        int newId = data.size() + 1;
        product.setProjectID(newId);
        data.add(product);

        return newId;
    }

    public ProjectDTO get(int id) {
        ProjectDTO productToFind = new ProjectDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }

    public boolean delete(int id) {
        ProjectDTO productToFind = new ProjectDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(ProjectDTO product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}