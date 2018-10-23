package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class MSquare extends MRectange {

	public MSquare(double x, double y, double w, GraphicsContext gr, Paint color, Paint fill) {
		super(x, y, w, w, gr, color, fill);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Hình vuông x: " + (int) x + " y: " + (int) y + " dài: " + (int) w);
	}

	@Override
	void ThuPhong(double sx, double sy) {
		SetWidth(w * sx);
		SetHeight(w * sx);
	}

}
