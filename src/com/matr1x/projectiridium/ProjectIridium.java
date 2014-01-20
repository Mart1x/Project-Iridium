package com.matr1x.projectiridium;

import com.matr1x.projectiridium.graphics.Window;

public class ProjectIridium {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Project Iridium";
	
	public ProjectIridium() {
		
	}
	
	public void start() {
		run();
	}
	
	public void stop() {
		
	}
	
	public void run() {
		while(!Window.isCloseRequested()) {
			render();
		}
		
	}
	
	public void render() {
		Window.render();
	}
	
	public void cleanUp() {
		
	}
	
	public static void main(String args[]) {
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		
		ProjectIridium game = new ProjectIridium();
		
		game.start();
	}

}
