package engine;

import java.util.LinkedList;
import util.Logger;

import engine.resources.TextureResource;

public class Engine {
	private LinkedList<Resource> resources;

	public Engine() {
		resources = new LinkedList<>();
		Logger.log("Engine created");
	}

	public void addTextures(LinkedList<TextureResource> resources) {
		this.resources.addAll(resources);
		Logger.log("Resources loaded");
	}

	public void addResource(Resource resource) {
		this.resources.add(resource);
		Logger.log("Resource " + resource.getClass().getName() + " loaded");
	}

	public void initGraphics() {
		OpenGL graphics = new OpenGL();
	}

	public void run() {
		Logger.log("Engine is starting.");

		Logger.log("Engine is stopped.");
	}
}
