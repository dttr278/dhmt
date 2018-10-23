package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MCircle extends MEllipse {

	public MCircle(double x, double y, double r, GraphicsContext g, Paint color, Paint fill) {
		super(x, y, r, r, g, color, fill);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Hình tròn: " + (int) x + " y: " + (int) y + " r: " + (int) a);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		a = b = a * sx;
	}
	// @Override
	// void Draw() {
	// // TODO Auto-generated method stub
	//
	// gr.setFill(color);
	// CircleMidPoint();
	//
	// }
	// void CircleMidPoint() {
	// double x, y,cx,cy,p,R;
	// cx = this.x; cy = this.y;
	// x = 0;
	// y =R= this.a;
	// double maxX = Math.sqrt(2)/2*R;
	// p = 1 - R;
	// PutPixel(cx + x,cy + y, gr,lw);
	// PutPixel(cx + x,cy - y, gr,lw);
	// PutPixel(cx - x,cy + y, gr,lw);
	// PutPixel(cx - x,cy - y, gr,lw);
	// PutPixel(cx + y,cy + x, gr,lw);
	// PutPixel(cx + y,cy - x, gr,lw);
	// PutPixel(cx - y,cy + x, gr,lw);
	// PutPixel(cx - y,cy - x, gr,lw);
	// while (x <= maxX)
	// {
	// if (p < 0) p += 2 * x+3;
	// else { p += 2 * (x - y) +5; y-=1; }
	// x+=1;
	// PutPixel(cx + x,cy + y, gr,lw);
	// PutPixel(cx + x,cy - y, gr,lw);
	// PutPixel(cx - x,cy + y, gr,lw);
	// PutPixel(cx - x,cy - y, gr,lw);
	// PutPixel(cx + y,cy + x, gr,lw);
	// PutPixel(cx + y,cy - x, gr,lw);
	// PutPixel(cx - y,cy + x, gr,lw);
	// PutPixel(cx - y,cy - x, gr,lw);
	// }
	// }

	//
	// @Override
	// boolean InIt(double x, double y) {
	// // TODO Auto-generated method stub
	// double maxx, minx, maxy, miny;
	// maxx = x + r;
	// minx = x - r;
	// maxy = y + r;
	// miny = y - r;
	// if (x >= minx && x <= maxx && y >= miny && y <= maxy) return true;
	// return false;
	// }

}
