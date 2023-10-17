package model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "Carrera")
public class Carrera {
    @Id
    private Integer id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    //sirve para relacionar las tablas, columnas contra que columnas. Esto es una llave foranea
    //referencedColumnName: en este caso vemos la tabla carrera, y con name, pegamos el campo id de usuario
    @JoinColumn(name = "usuario_id"
            , referencedColumnName = "id")
    private Usuario usuario;

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
