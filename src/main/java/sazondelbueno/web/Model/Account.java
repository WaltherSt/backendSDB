package sazondelbueno.web.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.TimeZone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 25, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    public Account(String email, String password) {
        this.password = email;
        this.email = password;
    }

    @PrePersist
    protected void onCreate() {
        // Establecer la zona horaria de Colombia
        TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");

        // Crear un objeto Date con la fecha y hora actual en la zona horaria de Colombia
        Date currentDate = new Date();

        // Establecer la zona horaria en el objeto Date
        currentDate.setTime(currentDate.getTime() + timeZone.getRawOffset());

        // Asignar la fecha y hora actualizada al atributo 'createdAt'
        this.createdAt = currentDate;
    }
}
