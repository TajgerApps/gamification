package engine;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2ES1;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import engine.renderer.CubeRenderer;
import engine.resources.Cube;

public class OpenGL extends JFrame implements GLEventListener, KeyListener {
	private static final long serialVersionUID = -8691139567837372504L;
	private GLU glu;
	private CubeRenderer renderer;
	private Cube[] cube;
	private Point mousePosition;
	private Long scrollPosition;
	private long cameraPosX = 0;
	private long cameraPosY = 0;
	
	private final int windowWidth = 800;
	private final int windowHeight = 800;

	public OpenGL() {
		super("Gamification");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		canvas.addKeyListener(this);

		this.setName("Gamification");
		this.getContentPane().add(canvas);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(windowWidth, windowHeight);
		this.setLocation(0, 0);
		canvas.requestFocusInWindow();
		
		this.renderer = new CubeRenderer();
		this.cube = new Cube[10000];
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				this.cube[j * 100 + i] = new Cube(i * 0.1 - 0.5, -1, j * 0.1 - 0.5, 0.1);
//			}
//		}
		this.cube[0] = new Cube(10, 0, 10, 10);
		
		this.mousePosition = new Point();
		this.scrollPosition = new Long(0);

		FPSAnimator animator = new FPSAnimator(canvas, 60);
		animator.start();
	}

	public void destroy() {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		this.update();
		this.render(drawable);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		glu = new GLU();
		gl.glClearColor(0, 0, 0, 0);
		gl.glClearDepth(100);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_MODELVIEW);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glEnable(GL2.GL_NORMALIZE);
		gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		gl.glShadeModel(GL2.GL_SMOOTH);

//		glu.gluPerspective(50.0f, this.windowWidth/this.windowHeight, 100, 1000);
		gl.glMatrixMode(GL2.GL_PROJECTION);
	    glu.gluOrtho2D(-10, 10, -10, 10);
	    gl.glMatrixMode(GL2.GL_MODELVIEW);
		System.out.println("Engine initialized");
	}

	public void update() {
		if (this.getMousePosition() != null) {
			this.mousePosition.setLocation(this.getMousePosition());
		}
	}

	public void render(GLAutoDrawable drawable) {
		double rotateX = (this.mousePosition.getX() / windowWidth) - 0.5;
		double rotateY = (this.mousePosition.getY() / windowHeight) - 0.5;

		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		gl.glTranslatef(this.cameraPosY, 0, this.cameraPosX);
		
		gl.glRotated(rotateX*360, 0, 1, 0);
		gl.glRotated(-rotateY*360, 1, 0, 0);
		for (int i = 0; i < this.cube.length; i++) {
			if (this.cube[i] != null) {
				this.renderer.render(gl, this.cube[i]);
			}
		}
		gl.glLoadIdentity();
		gl.glFlush();
		
		this.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
//				scrollPosition += e.getWheelRotation()>0?1:-1;
			}
		});
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case 38:
				this.cameraPosX++;
				break;
			case 40:
				this.cameraPosX--;
				break;
			case 37:
				this.cameraPosY--;
				break;
			case 39:
				this.cameraPosY++;
				break;
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}
}
