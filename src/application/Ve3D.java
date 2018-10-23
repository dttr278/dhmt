package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ve3D {
	GraphicsContext gr;
	double maxW, maxH, oX, oY, goc;

	public Ve3D(GraphicsContext gr, double maxW, double maxH, double oX, double oY) {
		super();
		this.gr = gr;
		this.maxW = maxW;
		this.maxH = maxH;
		this.oX = oX;
		this.oY = oY;
		goc = Math.atan(oX / (maxH - oY));
		goc = Math.toDegrees(goc);
	}

	public Point PointXY(double x, double y) {
		double tx, ty;
		tx = oX + x;
		ty = oY + y;
		Point p = VeHinh.XoayPhai(tx, ty, tx, oY, goc);
		return p;
	}

	public void VeToaDo() {
		gr.setLineWidth(1);
		gr.setStroke(Color.CHOCOLATE);
		gr.strokeLine(oX, oY, 0, maxH);
		gr.strokeLine(oX, oY, oX, 0);
		gr.strokeLine(oX, oY, maxW, oY);
		gr.fillText("O", oX - 15, oY);
		gr.fillText("x", maxW - 15, oY - 5);
		gr.fillText("y", 5, maxH - 15);
		gr.fillText("z", oX - 10, 10);
	}

	public void HHCN(double x, double y, double z, double dai, double rong, double cao) {
		gr.setStroke(Color.BLACK);
		Point d1 = PointXY(x, y);
		Point d2 = PointXY(x, y + dai);
		d1.y -= z;
		d2.y -= z;

		gr.setLineWidth(1);
		gr.setLineDashes(6);

		gr.strokeLine(d1.x, d1.y, d1.x, d1.y + cao);
		gr.strokeLine(d1.x, d1.y + cao, d2.x, d2.y + cao);
		gr.strokeLine(d1.x, d1.y + cao, d1.x + rong, d1.y + cao);

		gr.setLineDashes(0);

		gr.strokeLine(d1.x, d1.y, d1.x + rong, d1.y);
		gr.strokeLine(d1.x, d1.y, d2.x, d2.y);
		gr.strokeLine(d2.x, d2.y, d2.x + rong, d2.y);
		gr.strokeLine(d1.x + rong, d1.y, d2.x + rong, d2.y);

		gr.strokeLine(d2.x, d2.y, d2.x, d2.y + cao);
		gr.strokeLine(d2.x + rong, d2.y, d2.x + rong, d2.y + cao);
		gr.strokeLine(d1.x + rong, d1.y, d1.x + rong, d1.y + cao);

		gr.strokeLine(d2.x, d2.y + cao, d2.x + rong, d2.y + cao);
		gr.strokeLine(d2.x + rong, d2.y + cao, d1.x + rong, d1.y + cao);

	}

	public void HChop(double x, double y, double z, double dai, double cao) {
		gr.setStroke(Color.BROWN);
		Point dinh, d1, d2;
		dinh = PointXY(x, y);
		dinh.y -= z;
		d1 = new Point(dinh.x, dinh.y + cao);
		d2 = new Point(d1.x, d1.y + dai);
		d2 = VeHinh.XoayPhai(d2.x, d2.y, d1.x, d1.y, goc);

		gr.setLineWidth(1);
		gr.setLineDashes(6);

		gr.strokeLine(dinh.x, dinh.y, d1.x, d1.y);
		gr.strokeLine(d2.x, d2.y, d1.x, d1.y);
		gr.strokeLine(d1.x, d1.y, d1.x + dai, d1.y);

		gr.setLineDashes(0);
		gr.strokeLine(dinh.x, dinh.y, d1.x + dai, d1.y);
		gr.strokeLine(dinh.x, dinh.y, d2.x, d2.y);
		gr.strokeLine(dinh.x, dinh.y, d2.x + dai, d2.y);

		gr.strokeLine(d2.x, d2.y, d2.x + dai, d2.y);
		gr.strokeLine(d2.x + dai, d2.y, d1.x + dai, d1.y);
	}
}
