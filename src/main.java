import java.awt.MouseInfo;
import java.util.ArrayList;
import engine.Engine;
import engine.resources.Cube;
import engine.resources.loaders.TextureLoader;
import util.Logger;

public class main {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		Engine e = new Engine();
		e.initGraphics();
	}

	public static void testResourceLoader() {
		Engine e = new Engine();
		try {
			e.addTextures(new TextureLoader("resources/textures/").getResources());
			e.run();
		} catch (Exception exception) {
			Logger.log("Error happend: " + exception.getMessage());
			exception.printStackTrace();
		}
		Logger.log("Finish.");
	}

}
