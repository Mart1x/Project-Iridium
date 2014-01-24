package com.matr1x.projectiridium.game;

import com.matr1x.projectiridium.graphics.Shader;
import com.matr1x.projectiridium.graphics.Vertex;
import com.matr1x.projectiridium.handlers.Input;
import com.matr1x.projectiridium.handlers.Mesh;
import com.matr1x.projectiridium.handlers.ResourceLoader;
import com.matr1x.projectiridium.util.Time;
import com.matr1x.projectiridium.util.Vector3f;


public class Game {
	
	private Mesh mesh;
	private Shader shader;
	
	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		
		Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1, -1, 0)),
									  new Vertex(new Vector3f(0, 1, 0)),
									  new Vertex(new Vector3f(1, -1, 0))};
	
		mesh.addVertices(data);
		
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		
		shader.addUniform("uniformFloat");
	}
	
	public void input() {
		if(Input.getKeyDown(Input.KEY_UP))
			System.out.println("We've just pressed up!");
		if(Input.getKeyUp(Input.KEY_UP))
			System.out.println("We've just released up!");
		
		if(Input.getMouseDown(1))
			System.out.println("We've just right clicked at " + Input.getMousePosition().toString());
		if(Input.getMouseUp(1))
			System.out.println("We've just released right mouse button!");
	}
	
	float temp = 0.0f;
	
	public void update() {
		temp += Time.getDelta();
		
		shader.setUniformf("uniformFloat", (float)Math.abs(Math.sin(temp)));
	}
	
	public void render() {
		shader.bind();
		mesh.draw();
	}

}
