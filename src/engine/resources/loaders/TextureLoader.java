package engine.resources.loaders;

import java.io.File;
import java.util.LinkedList;
import engine.resources.TextureResource;

public class TextureLoader {
	protected String path;
	protected LinkedList<TextureResource> resources;

	public TextureLoader(String path) {
		this.path = path;
		this.resources = new LinkedList<TextureResource>();
	}

	public String getPath() {
		return path;
	}

	public LinkedList<TextureResource> getResources() throws Exception {
		File folder = new File(this.path);
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++)
				this.resources.add(new TextureResource(files[i].getAbsolutePath()));
		} else if (folder.isFile()) {
			this.resources.add(new TextureResource(folder.getAbsolutePath()));
		} else {
			throw new Exception("Resource not found.");
		}

		return resources;
	}

}
