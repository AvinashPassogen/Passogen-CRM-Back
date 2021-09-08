package country.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import country.persistence.entities.audit.Auditable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City extends Auditable<String> implements Serializable {
	
	@Getter
	@Setter
    private String name;

	@Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = RelationshipConstants.STATE_ID)
    private State state;

	@Getter
	@Setter
    private Double latitude;

	@Getter
	@Setter
    private Double longitude;


}
