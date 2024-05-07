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
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "id_account",nullable = false,updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name="id_recipe",nullable = false,updatable = false)
    private Recipe recipe;


    @PrePersist
    protected void onCreate() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
        Date currentDate = new Date();
        currentDate.setTime(currentDate.getTime() + timeZone.getRawOffset());
        this.createdAt = currentDate;
    }
}
