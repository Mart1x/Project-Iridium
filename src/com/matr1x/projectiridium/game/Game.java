package com.matr1x.projectiridium.game;

import com.matr1x.projectiridium.graphics.BaseLight;
import com.matr1x.projectiridium.graphics.DirectionalLight;
import com.matr1x.projectiridium.graphics.Material;
import com.matr1x.projectiridium.graphics.PhongShader;
import com.matr1x.projectiridium.graphics.Shader;
import com.matr1x.projectiridium.graphics.Vertex;
import com.matr1x.projectiridium.graphics.Window;
import com.matr1x.projectiridium.handlers.Camera;
import com.matr1x.projectiridium.handlers.Mesh;
import com.matr1x.projectiridium.handlers.ResourceLoader;
import com.matr1x.projectiridium.handlers.Transform;
import com.matr1x.projectiridium.util.RenderUtil;
import com.matr1x.projectiridium.util.Time;
import com.matr1x.projectiridium.util.Vector2f;
import com.matr1x.projectiridium.util.Vector3f;

public class Game {
	
	private Mesh mesh;
	private Shader shader;
	private Material material;
	private Transform transform;
	private Camera camera;
	
	public Game() {
		mesh = new Mesh();
		material = new Material(ResourceLoader.loadTexture("test.png"), new Vector3f(0, 1, 1));
		shader = PhongShader.getInstance();
		camera = new Camera();
		transform = new Transform();

		
		Vertex[] vertices = new Vertex[] { new Vertex( new Vector3f(-1.0f, -1.0f, 0.5773f),	new Vector2f(0.0f, 0.0f)),
										   new Vertex( new Vector3f(0.0f, -1.0f, -1.15475f),new Vector2f(0.5f, 0.0f)),
										   new Vertex( new Vector3f(1.0f, -1.0f, 0.5773f),	new Vector2f(1.0f, 0.0f)),
										   new Vertex( new Vector3f(0.0f, 1.0f, 0.0f),      new Vector2f(0.5f, 1.0f))};
		
		int[] indices = new int[] {0, 3, 1,
								   1, 3, 2,
								   2, 3, 0,
								   1, 2, 0};
	
		mesh.addVertices(vertices, indices, true);
		
		transform.setProjection(70f, Window.getWidth(), Window.getHeight(), 0.1f, 1000);
		transform.setCamera(camera);
		
		PhongShader.setAmbientLight(new Vector3f(0.1f, 0.1f, 0.1f));
		PhongShader.setDirectionalLight(new DirectionalLight(new BaseLight(new Vector3f(1, 1, 1), 0.8f), new Vector3f(1, 1, 1)));
	}
	
	public void input() {
		camera.input();
	}
	
	float temp = 0.0f;
	
	public void update() {
		temp += Time.getDelta();
		
		float sinTemp = (float)Math.sin(temp);
		
		transform.setTranslation(sinTemp, 0, 5);
		transform.setRotation(0, sinTemp * 180, 0);
		//transform.setScale(0.7f * sinTemp, 0.7f * sinTemp, 0.7f * sinTemp);
	}
	
	public void render() {
		RenderUtil.setClearColor(Transform.getCamera().getPos().div(2048f).abs());
		shader.bind();
		shader.updateUniforms(transform.getTransformation(), transform.getProjectedTransformation(), material);
		mesh.draw();
	}

}
