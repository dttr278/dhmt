package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Ball extends MCircle {

	double dx, dy, maxW, maxH;

	public Ball(double x, double y, double r, GraphicsContext g, Paint color, Paint fill, double dx, double maxw,
			double maxh) {
		super(x, y, r, g, color, fill);
		// TODO Auto-generated constructor stub
		this.dy = this.dx = dx;
		maxW = maxw;
		maxH = maxh;

	}

	@Override
	public void Draw() {
		TinhTien(dx, dy);
		if (x - a < 0 - ox) {
			dx = -dx;
			x = a - ox;
		} else if (x + a > maxW - ox) {
			dx = -dx;
			x = maxW - ox - a;
		}
		if (y - a < 0 - oy) {
			dy = -dy;
			y = a - oy;
		} else if (y + a > maxH - oy) {
			dy = -dy;
			y = maxH - oy - a;
		}
		super.Draw();
		UpDate();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Ball: " + (int) x + " y: " + (int) y + " r: " + (int) a);
	}

	@Override
	public void ChonO(double x, double y) {
		super.ChonO(x, y); // To change body of generated methods, choose Tools | Templates.
	}

}
