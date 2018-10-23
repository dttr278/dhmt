package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MRectange extends MPolygon {
	double x, y, w, h;

	public MRectange(double x, double y, double w, double h, GraphicsContext gr, Paint color, Paint fill) {
		super(new double[] { x, y, x + w, y, x + w, y + h, x, y + h }, gr, color, fill);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void SetWidth(double w) {
		topx[2] = topx[1] = topx[0] + w;
		this.w = w;
	}

	public void SetHeight(double h) {
		topy[2] = topy[3] = topy[0] + h;
		this.h = h;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Hình chữ nhật x: " + (int) x + " y: " + (int) y + " dài: " + (int) w + " rộng: " + (int) h);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		SetWidth(w * sx);
		SetHeight(h * sy);
	}

}
