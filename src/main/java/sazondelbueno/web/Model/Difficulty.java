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
@Table(name="difficulty")
public class Difficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level",nullable = false)
    private String level;

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
