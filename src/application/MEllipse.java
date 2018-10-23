package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MEllipse extends MShape {
	double x, y, a, b;

	@Override
	void TinhTien(double dx, double dy) {
		// TODO Auto-generated method stub
		x += dx;
		y += dy;
	}

	@Override
	void DoiXungQuaDiem(double x, double y) {
		// TODO Auto-generated method stub
		Point d = VeHinh.DoiXung(this.x, this.y, x, y);
		this.x = d.x;
		this.y = d.y;
	}

	@Override
	void Xoay(double x, double y, double goc) {
		// TODO Auto-generated method stub
		Point d;
		d = VeHinh.XoayTrai(this.x, this.y, x, y, goc);
		this.x = d.x;
		this.y = d.y;
	}

	@Override
	void ThuPhong(double sx, double sy) {
		// TODO Auto-generated method stub
		a *= sx;
		b *= sy;
	}

	@Override
	void Draw() {
		// TODO Auto-generated method stub
		// VeHinh.EllipseMidPoint(x+ox,y+oy,a,b,gr,lw);
		Fill();
		Stroke();
	}

	public MEllipse(double cx, double cy, double a, double b, GraphicsContext gr, Paint color, Paint fill) {
		super(gr, color, fill);
		this.x = cx;
		this.y = cy;
		this.a = a;
		this.b = b;
	}

	@Override
	void DoiXungQuaDT(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		Point d = VeHinh.DoiXungDT(this.x, this.y, x1, y1, x2, y2);
		this.x = d.x;
		this.y = d.y;
	}

	@Override
	void Fill() {
		// TODO Auto-generated method stub
		gr.setFill(fill);
		gr.fillOval(x - a + ox, y - b + oy, 2 * a, 2 * b);
	}

	@Override
	void Stroke() {
		// TODO Auto-generated method stub
		gr.setLineWidth(lw);
		gr.setStroke(color);
		gr.strokeOval(x - a + ox, y - b + oy, 2 * a, 2 * b);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Hình ellipse x: " + (int) x + " y: " + (int) y + " a: " + (int) a + " b: " + (int) b);
	}

}
