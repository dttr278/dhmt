package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MLine extends MShape {
	double x1, y1, x2, y2;

	public MLine(double x1, double y1, double x2, double y2, GraphicsContext gr, Paint color) {
		super(gr, color, color);

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public MLine(GraphicsContext gr, Paint color, Paint fill) {
		// TODO Auto-generated constructor stub
		super(gr, color, fill);
	}

	@Override
	void TinhTien(double dx, double dy) {
		// TODO Auto-generated method stub
		x1 += dx;
		x2 += dx;
		y1 += dy;
		y2 += dy;
	}

	@Override
	void DoiXungQuaDiem(double x, double y) {
		// TODO Auto-generated method stub
		x1 = 2 * x - x1;
		y1 = 2 * y - y1;
		x2 = 2 * x - x2;
		y2 = 2 * y - y2;
	}

	@Override
	void Xoay(double x, double y, double goc) {
		// TODO Auto-generated method stub
		Point d;
		d = VeHinh.XoayTrai(x1, y1, x, y, goc);
		x1 = d.x;
		y1 = d.y;
		d = VeHinh.XoayTrai(x2, y2, x, y, goc);
		x2 = d.x;
		y2 = d.y;

	}

	@Override
	void ThuPhong(double sx, double sy) {
		// TODO Auto-generated method stub
		x2 = x1 + (x2 - x1) * sx;
		y2 = y1 + (y2 - y1) * sy;
	}

	@Override
	void Draw() {
		gr.setFill(color);
		VeHinh.DDA(x1 + ox, y1 + oy, x2 + ox, y2 + oy, gr, lw);
	}

	@Override
	void DoiXungQuaDT(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		Point d;
		d = VeHinh.DoiXungDT(this.x1, this.y1, x1, y1, x2, y2);
		this.x1 = d.x;
		this.y1 = d.y;
		d = VeHinh.DoiXungDT(this.x2, this.y2, x1, y1, x2, y2);
		this.x2 = d.x;
		this.y2 = d.y;
	}

	@Override
	void Fill() {
		// TODO Auto-generated method stub

	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	@Override
	void Stroke() {
		// TODO Auto-generated method stub
		gr.setStroke(color);
		gr.setLineWidth(lw);
		gr.strokeLine(x1 + ox, y1 + oy, x2 + ox, y2 + oy);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Đường thẳng x1: " + (int) x1 + " y1: " + (int) y1 + " x2: " + (int) x2 + " y2: " + (int) y2;
	}

}
