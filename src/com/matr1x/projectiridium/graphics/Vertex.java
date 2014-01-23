package com.matr1x.projectiridium.graphics;

import com.matr1x.projectiridium.util.Vector3f;

public class Vertex {
	
	public static final int SIZE = 3;
	
	private Vector3f pos;
	
	public Vertex(Vector3f pos) {
		this.pos = pos;
	}

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

}
