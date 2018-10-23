package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Ball1 extends Ball {
	MRectange e1, e2, e3, e4;
	double goc, d = 5;

	public Ball1(double x, double y, double r, GraphicsContext g, Paint color, Paint fill, double dx) {
		super(x, y, r, g, color, fill, dx, 0, 0);
		// TODO Auto-generated constructor stub
		e1 = new MRectange(x - r, y - d, r, 2 * d, g, color, fill);
		e2 = new MRectange(x - d, y - r, 2 * d, r, g, color, fill);
		e3 = new MRectange(x, y - d, r, 2 * d, g, color, fill);
		e4 = new MRectange(x - d, y, 2 * d, r, g, color, fill);
		goc = 5;
	}

	public void Draw() {
		e1.Xoay(x, y, goc);
		e2.Xoay(x, y, goc);
		e3.Xoay(x, y, goc);
		e4.Xoay(x, y, goc);

		e1.Fill();
		e2.Fill();
		e3.Fill();
		e4.Fill();

		e1.Stroke();
		e2.Stroke();
		e3.Stroke();
		e4.Stroke();

		UpDate();
	}

	@Override
	void TinhTien(double dx, double dy) {
		// TODO Auto-generated method stub
		super.TinhTien(dx, dy);
		e1.TinhTien(dx, dy);
		e2.TinhTien(dx, dy);
		e3.TinhTien(dx, dy);
		e4.TinhTien(dx, dy);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		// TODO Auto-generated method stub
		super.ThuPhong(sx, sy);
		double d = this.d = this.d * sx;
		e1 = new MRectange(x - a, y - d, a, 2 * d, gr, color, fill);
		e2 = new MRectange(x - d, y - a, 2 * d, a, gr, color, fill);
		e3 = new MRectange(x, y - d, a, 2 * d, gr, color, fill);
		e4 = new MRectange(x - d, y, 2 * d, a, gr, color, fill);
		ChonO(ox, oy);
	}

	@Override
	void Xoay(double x, double y, double goc) {
		// TODO Auto-generated method stub
		super.Xoay(x, y, goc);
		e1.Xoay(x, y, goc);
		e2.Xoay(x, y, goc);
		e3.Xoay(x, y, goc);
		e4.Xoay(x, y, goc);
	}

	@Override
	void DoiXungQuaDiem(double x, double y) {
		// TODO Auto-generated method stub
		super.DoiXungQuaDiem(x, y);
		e1.DoiXungQuaDiem(x, y);
		e2.DoiXungQuaDiem(x, y);
		e3.DoiXungQuaDiem(x, y);
		e4.DoiXungQuaDiem(x, y);
	}

	@Override
	void DoiXungQuaDT(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		super.DoiXungQuaDT(x1, y1, x2, y2);
		e1.DoiXungQuaDT(x1, y1, x2, y2);
		e2.DoiXungQuaDT(x1, y1, x2, y2);
		e3.DoiXungQuaDT(x1, y1, x2, y2);
		e4.DoiXungQuaDT(x1, y1, x2, y2);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Ball 1: " + (int) x + " y: " + (int) y + " r: " + (int) a);
	}

	@Override
	public void ChonO(double x, double y) {
		super.ChonO(x, y); // To change body of generated methods, choose Tools | Templates.
		e1.ChonO(x, y);
		e2.ChonO(x, y);
		e3.ChonO(x, y);
		e4.ChonO(x, y);
	}

}
