package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MPolygon extends MShape {
	// MLine[] ml;

	public MPolygon(double[] top, GraphicsContext gr, Paint color, Paint fill) {
		super(gr, color, fill);

		setTop(top);
		// ml=new MLine[topx.length];
		// for (int i = 0; i < ml.length; i++) {
		// ml[i]=new MLine(gr, color, fill);
		// }
	}

	public MPolygon(GraphicsContext gr, Paint color, Paint fill) {
		super(gr, color, fill);

	}

	public double[] getTopx() {
		return topx;
	}

	public void setTopx(double[] topx) {
		this.topx = topx;
	}

	public double[] getTopy() {
		return topy;
	}

	public void setTopy(double[] topy) {
		this.topy = topy;
	}

	public void setTop(double[] top) {
		topx = new double[top.length / 2];
		topy = new double[top.length / 2];
		topx_ = new double[top.length / 2];
		topy_ = new double[top.length / 2];
		int j = 0;
		for (int i = 0; i < top.length - 1; i += 2) {
			topx[j] = top[i];
			topy[j] = top[i + 1];
			j++;
		}
	}

	double[] topx;
	double[] topy;

	double[] topx_;
	double[] topy_;

	@Override
	void TinhTien(double dx, double dy) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topx.length; i++) {
			topx[i] += dx;
			topy[i] += dy;
		}

	}

	@Override
	void DoiXungQuaDiem(double x, double y) {
		// TODO Auto-generated method stub
		Point d;
		for (int i = 0; i < topx.length; i++) {
			d = VeHinh.DoiXung(topx[i], topy[i], x, y);
			topx[i] = d.x;
			topy[i] = d.y;
		}
	}

	@Override
	void Xoay(double x, double y, double goc) {
		// TODO Auto-generated method stub
		Point d;
		for (int i = 0; i < topx.length; i++) {
			d = VeHinh.XoayTrai(topx[i], topy[i], x, y, goc);
			topx[i] = d.x;
			topy[i] = d.y;
		}
		// setTop(top);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		// TODO Auto-generated method stub

	}

	@Override
	void Draw() {
		// TODO Auto-generated method stub
		// for (int i = 0; i < topx.length-1; i++) {
		// ml[i].setX1(topx[i]);
		// ml[i].setY1(topy[i]);
		// ml[i].setX2(topx[i+1]);
		// ml[i].setY2(topy[i+1]);
		// ml[i].Draw();
		// }
		// ml[ml.length-1].setX1(topx[topx.length-1]);
		// ml[ml.length-1].setY1(topy[topy.length-1]);
		// ml[ml.length-1].setX2(topx[0]);
		// ml[ml.length-1].setY2(topy[0]);
		// ml[ml.length-1].Draw();

		Fill();
		Stroke();
	}

	@Override
	void DoiXungQuaDT(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		Point d;
		for (int i = 0; i < topx.length; i++) {
			d = VeHinh.DoiXungDT(topx[i], topy[i], x1, y1, x2, y2);
			topx[i] = d.x;
			topy[i] = d.y;
		}
	}

	@Override
	void Fill() {
		// TODO Auto-generated method stub
		for (int i = 0; i < topx.length; i++) {
			topx_[i] = topx[i] + ox;
			topy_[i] = topy[i] + oy;
		}
		gr.setFill(fill);
		gr.fillPolygon(topx_, topy_, topx.length);
	}

	@Override
	void Stroke() {
		// TODO Auto-generated method stub
		for (int i = 0; i < topx.length; i++) {
			topx_[i] = topx[i] + ox;
			topy_[i] = topy[i] + oy;
		}
		gr.setLineWidth(lw);
		gr.setStroke(color);
		gr.strokePolygon(topx_, topy_, topx.length);
	}

}
