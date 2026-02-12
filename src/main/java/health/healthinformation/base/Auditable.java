package health.healthinformation.base;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate createdAT;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate updatedAT;

    public LocalDate getCreatedAt(){
        return createdAT;
    }

    public LocalDate getUpdatedAT(){
        return updatedAT;
    }

}
