package engine.input;

import java.awt.MouseInfo;
import java.awt.Point;

public class Mouse {
	private Point topLeft;
	private Point bottomRight;

	public Mouse() {

	}

	public Long getX() {
		return Math.round(MouseInfo.getPointerInfo().getLocation().getX());
	}

	public Long getY() {
		return Math.round(MouseInfo.getPointerInfo().getLocation().getY());
	}

	public void setPosition(Long x, Long y) {
		MouseInfo.getPointerInfo().getLocation().setLocation(x, y);
	}

	public void setBounds(int x1, int y1, int x2, int y2) {
		topLeft = new Point(x1, y1);
		bottomRight = new Point(x2, y2);
	}

	public void checkBounds() {
		Long x = this.getX();
		Long y = this.getY();
		if (topLeft.getX() > x) {
			x = Math.round(topLeft.getX());
		}
		if (topLeft.getY() > y) {
			y = Math.round(topLeft.getY());
		}
		if (bottomRight.getX() > x) {
			x = Math.round(bottomRight.getX());
		}
		if (bottomRight.getY() > y) {
			y = Math.round(bottomRight.getY());
		}
		this.setPosition(x, y);
	}

}
