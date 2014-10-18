package com;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntityLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Entity entity;
	
	public EntityLabel(Entity entity){
		setEntity(entity);
		if(entity!=null)
		setIcon(new ImageIcon(entity.getFrames()[0]));
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}
}
