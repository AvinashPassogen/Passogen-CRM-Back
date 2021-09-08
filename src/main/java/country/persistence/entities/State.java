package country.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import country.persistence.entities.audit.Auditable;
import country.persistence.entities.Country;
import country.persistence.entities.RelationshipConstants;
import country.persistence.entities.*;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "states")
public class State extends Auditable<String> implements Serializable {
	
	@Getter
	@Setter
    private String name;

	@JsonIgnore
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = RelationshipConstants.COUNTRY_ID)
    private Country country;
}
