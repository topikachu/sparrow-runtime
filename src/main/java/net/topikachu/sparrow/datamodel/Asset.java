package net.topikachu.sparrow.datamodel;

import javax.persistence.Entity;

@Entity
public class Asset extends AbstractEntity{
	private String assetTag;

	public String getAssetTag() {
		return assetTag;
	}

	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}
	
}
