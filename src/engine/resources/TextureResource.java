package engine.resources;

import engine.Resource;

public class TextureResource extends Resource {
	protected int width;
	protected int height;
	protected String path;

	public TextureResource(String path) {
		this.path = path;
	}

	public TextureResource(String path, int width, int height) {
		this.width = width;
		this.height = height;
		this.path = path;
	}

	public void loadSize() {
		//TODO
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getPath() {
		return path;
	}
}
