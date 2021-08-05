package country.persistence.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import country.persistence.entities.audit.Auditable;

import lombok.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends Auditable<String> implements Serializable{

	@Getter
    @Setter
	@Column(name = "sortname")
    private String sortName;
	
	@Getter
    @Setter
    @Column(name = "name")
    private String name;
    
	@Getter
    @Setter
    @Column(name = "phonecode")
    private String phoneCode;
    
    @JsonIgnore
    @Getter
    @Setter
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<State> states = new HashSet<>();
	
}
