package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class MShape {
	final StringProperty update = new SimpleStringProperty();

	void UpDate() {
		update.set(toString());
		update.get();
	}

	double ox, oy, lw;
	Paint color, fill;

	public double getLw() {
		return lw;
	}

	public void setLw(double lw) {
		this.lw = lw;
	}

	GraphicsContext gr;

	public MShape() {
		lw = 2;
		ox = oy = 0;
		this.gr = null;
	}

	public MShape(GraphicsContext gr, Paint color, Paint fill) {
		ox = oy = 0;
		lw = 2;
		this.gr = gr;
		this.color = color;
		this.fill = fill;
	}

	public MShape(double ox, double oy, GraphicsContext gr, Paint color, Paint fill) {
		super();
		this.ox = ox;
		this.oy = oy;
		this.gr = gr;
		this.color = color;
		this.fill = fill;
		lw = 2;
	}

	public double getOx() {
		return ox;
	}

	public void setOx(double ox) {
		this.ox = ox;
	}

	public double getOy() {
		return oy;
	}

	public void setOy(double oy) {
		this.oy = oy;
	}

	public GraphicsContext getGr() {
		return gr;
	}

	public void setGr(GraphicsContext gr) {

		this.gr = gr;
	}

	abstract void TinhTien(double dx, double dy);

	abstract void DoiXungQuaDiem(double x, double y);

	abstract void DoiXungQuaDT(double x1, double y1, double x2, double y2);

	abstract void Xoay(double x, double y, double goc);

	abstract void ThuPhong(double sx, double sy);

	abstract void Draw();

	abstract void Fill();

	abstract void Stroke();

	public void ChonO(double x, double y) {
		ox = x;
		oy = y;
	}

}
