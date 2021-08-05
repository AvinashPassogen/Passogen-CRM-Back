package country.persistence.entities.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Getter
	 @Setter
    private Long id;

	 @CreatedBy
	    @Getter
	    @Setter
	    @JsonIgnore
    protected U createdBy;

	 @Getter
	    @Setter
	    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    protected LocalDateTime creationDate;

    
	 @Getter
	    @Setter
	    @LastModifiedBy
	    @JsonIgnore
    protected U lastModifiedBy;

	    @Getter
	    @Setter
	    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP")
    protected LocalDateTime lastModifiedDate;

    @Getter
    @Setter
    @JsonIgnore
    @Column(name = "is_active")
    protected boolean active = true;

	
}
