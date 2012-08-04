package net.topikachu.sparrow.datamodel;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class AbstractEntity {
	
@Id
private String id=UUID.randomUUID().toString();

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}


}
