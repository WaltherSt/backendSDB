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
@Table(name="favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_account",nullable = false,updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_recipe",nullable = false,updatable = false)
    private Recipe recipe;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
        Date currentDate = new Date();
        currentDate.setTime(currentDate.getTime() + timeZone.getRawOffset());
        this.createdAt = currentDate;
    }




}
