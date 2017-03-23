package engine.renderer;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import engine.resources.Cube;

public class CubeRenderer extends Renderer{
	public void render(GL2 gl, Cube cube)
	{
		double size = cube.getSize();
		double halfSize = size / 2;
		double x = cube.getX();
		double y = cube.getY();
		double z = cube.getZ();
		
		gl.glBegin(GL.GL_TRIANGLES);
		//front
		gl.glColor3d(1.0, 0.0, 0.0);
		gl.glVertex3d(x - halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		//back
		gl.glColor3d(0.0, 1.0, 0.0);
		gl.glVertex3d(x - halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z - halfSize);
		//left
		gl.glColor3d(0.0, 0.0, 1.0);
		gl.glVertex3d(x + halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		//right
		gl.glColor3d(0.0, 1.0, 1.0);
		gl.glVertex3d(x - halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y + halfSize, z + halfSize);
		//top
		gl.glColor3d(1.0, 1.0, 0.0);
		gl.glVertex3d(x + halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y + halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y + halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y + halfSize, z + halfSize);
		//bottom
		gl.glColor3d(1.0, 0.0, 1.0);
		gl.glVertex3d(x + halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z - halfSize);
		gl.glVertex3d(x - halfSize, y - halfSize, z + halfSize);
		gl.glVertex3d(x + halfSize, y - halfSize, z + halfSize);
		
		gl.glEnd();
	}
	
	protected static double calculate()
	{
		return 0.0;
	}
}
