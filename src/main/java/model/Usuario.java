package model;

import jakarta.persistence.*;

//todas las entidades tienen una key
//e es el nickname para llamar a todos
@Entity
@Table(name = "Usuario")
@NamedQueries({                             //se ocupa jpql
        @NamedQuery(name = "Usuario.all", query = "select e from Usuario e" )
})
public class Usuario {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;

    public Usuario() {
    }

    public Usuario(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
