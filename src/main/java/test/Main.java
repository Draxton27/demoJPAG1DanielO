package test;

import model.Carrera;
import model.Usuario;
import service.EntityManagerAdmin;
import service.IDAO;
import service.ImplIDAO;

import java.util.List;

public class Main {
    public static void  main(String[] args) {
        IDAO dao = new ImplIDAO();
        List<Usuario> lista = dao.getAll("Usuario.all", Usuario.class);
        try {
            Usuario u = new Usuario();
            u.setFirstName("Daniel");
            u.setLastName("Osorio");
            u.setId(3);
            dao.insert(u);
            Carrera carrera = new Carrera(1, "Ing.Sistemas", u);
            dao.insert(carrera);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Usuario> list = dao.getAll("Usuario.all", Usuario.class);
        System.out.println(list);

    }
}
