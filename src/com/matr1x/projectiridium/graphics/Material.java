package com.matr1x.projectiridium.graphics;

import com.matr1x.projectiridium.util.Texture;
import com.matr1x.projectiridium.util.Vector3f;

public class Material {
	
	private Texture texture;
	private Vector3f color;
	private float specularIntensity;
	private float specularPower;
	
	public Material(Texture texture) {
		this(texture, new Vector3f(1, 1, 1));
	}
	
	public Material(Texture texture, Vector3f color) {
		this(texture, color, 2, 32);
	}
	
	public Material(Texture texture, Vector3f color, float specularIntensity, float specularExponent) {
		this.texture = texture;
		this.color = color;
		this.specularIntensity = specularIntensity;
		this.specularPower = specularExponent;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public float getSpecularIntensity() {
		return specularIntensity;
	}

	public void setSpecularIntensity(float specularIntensity) {
		this.specularIntensity = specularIntensity;
	}

	public float getSpecularPower() {
		return specularPower;
	}

	public void setSpecularPower(float specularPower) {
		this.specularPower = specularPower;
	}

}
