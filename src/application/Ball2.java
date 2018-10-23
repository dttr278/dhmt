package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Ball2 extends Ball {
	MPolygon hv;
	MCircle ht, ht1, ht3;
	MLine l;
	double goc;

	public Ball2(double x, double y, double r, GraphicsContext g, Paint color, Paint fill, double dx, double maxw,
			double maxh, double ox, double oy) {
		super(x, y, r, g, color, fill, dx, maxw, maxh);

		// TODO Auto-generated constructor stub
		ht = new MCircle(x + r, y, r / 4, g, color, fill);
		ht1 = new MCircle(x + r, y, r / 9, g, color, Color.AZURE);
		ht3 = new MCircle(x, y, r / 7, g, color, fill);
		hv = new MPolygon(new double[] { x + r, y - r / 4, x + r + r / 4, y, x + r, y + r / 4, x + r - r / 4, y }, g,
				fill, color);
		l = new MLine(x, y, ht.getX(), ht.getY(), g, color);
		goc = -1;
		ChonO(ox, oy);
		while (ht.x - ht.a < 0 - ox || ht.x + ht.a > maxW - ox || ht.y - ht.a < 0 - oy || ht.y + ht.a > maxH - oy) {
			ht.Xoay(x, y, goc);
			ht1.Xoay(x, y, goc);
			hv.Xoay(x, y, goc);
		}

	}

	@Override
	public void Draw() {
		ht.Xoay(x, y, goc);
		ht1.Xoay(x, y, goc);
		hv.Xoay(x, y, goc);
		l.setX2(hv.getTopx()[3]);
		l.setY2(hv.getTopy()[3]);

		if (ht.x - ht.a < 0 - ox) {
			goc = -goc;
		} else if (ht.x + ht.a > maxW - ox) {
			goc = -goc;
		}
		if (ht.y - ht.a < 0 - oy) {
			goc = -goc;
		} else if (ht.y + ht.a > maxH - oy) {
			goc = -goc;
		}

		ht.Fill();
		hv.Fill();
		ht1.Fill();

		l.Stroke();
		ht3.Stroke();
		ht.Stroke();
		ht1.Stroke();
		hv.Stroke();

		ht3.Fill();
		UpDate();
	}

	@Override
	void TinhTien(double dx, double dy) {
		// TODO Auto-generated method stub
		super.TinhTien(dx, dy);
		ht.TinhTien(dx, dy);
		ht1.TinhTien(dx, dy);
		ht3.TinhTien(dx, dy);
		hv.TinhTien(dx, dy);
		l.TinhTien(dx, dy);
	}

	@Override
	void Xoay(double x, double y, double goc) {
		// TODO Auto-generated method stub
		super.Xoay(x, y, goc);
		ht.Xoay(x, y, goc);
		ht1.Xoay(x, y, goc);
		ht3.Xoay(x, y, goc);
		hv.Xoay(x, y, goc);
		l.Xoay(x, y, goc);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		// TODO Auto-generated method stub
		super.ThuPhong(sx, sy);
		double r = a;
		ht = new MCircle(x + r, y, r / 4, gr, color, fill);
		ht1 = new MCircle(x + r, y, r / 9, gr, color, Color.AZURE);
		ht3 = new MCircle(x, y, r / 7, gr, color, fill);
		hv = new MPolygon(new double[] { x + r, y - r / 4, x + r + r / 4, y, x + r, y + r / 4, x + r - r / 4, y }, gr,
				fill, color);
		l = new MLine(x, y, ht.getX(), ht.getY(), gr, color);
		ChonO(ox, oy);
	}

	@Override
	void DoiXungQuaDiem(double x, double y) {
		// TODO Auto-generated method stub
		super.DoiXungQuaDiem(x, y);
		ht.DoiXungQuaDiem(x, y);
		ht1.DoiXungQuaDiem(x, y);
		ht3.DoiXungQuaDiem(x, y);
		hv.DoiXungQuaDiem(x, y);
		l.DoiXungQuaDiem(x, y);
	}

	@Override
	void DoiXungQuaDT(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		super.DoiXungQuaDT(x1, y1, x2, y2);
		ht.DoiXungQuaDT(x1, y1, x2, y2);
		ht1.DoiXungQuaDT(x1, y1, x2, y2);
		ht3.DoiXungQuaDT(x1, y1, x2, y2);
		hv.DoiXungQuaDT(x1, y1, x2, y2);
		l.DoiXungQuaDT(x1, y1, x2, y2);
	}

	@Override
	void Fill() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Ball 2: " + (int) x + " y: " + (int) y + " r: " + (int) a);
	}

	@Override
	public void ChonO(double x, double y) {
		super.ChonO(x, y); // To change body of generated methods, choose Tools | Templates.
		ht.ChonO(x, y);
		ht1.ChonO(x, y);
		ht3.ChonO(x, y);
		hv.ChonO(x, y);
		l.ChonO(x, y);
	}

}
