package application;

import javafx.scene.canvas.GraphicsContext;

public class VeHinh {
	public static void PutPixel(double x, double y, GraphicsContext gr, double lw) {
		gr.fillRect(x, y, lw, lw);
	}

	public static Point DoiXung(double x1, double y1, double x, double y) {
		x1 = 2 * x - x1;
		y1 = 2 * y - y1;
		return new Point(x1, y1);
	}

	public static Point DoiXungDT(double x, double y, double x1, double y1, double x2, double y2) {
		x -= x1;
		y -= y1;
		double m = (y2 - y1) / (x2 - x1);
		double a = Math.atan(m);
		a = Math.toDegrees(a);
		Point t;
		t = XoayTrai(x, y, 0, 0, a);
		t.y *= -1;
		t = XoayPhai(t.x, t.y, 0, 0, a);
		t.x += x1;
		t.y += y1;
		return t;
	}

	public static Point XoayPhai(double x, double y, double x1, double y1, double goc) {
		goc = Math.toRadians(goc);
		double sin = Math.sin(goc);
		double cos = Math.cos(goc);
		Point d = new Point();
		x -= x1;
		y -= y1;
		d.x = x * cos - y * sin + x1;
		d.y = x * sin + y * cos + y1;
		return d;
	}

	public static Point XoayTrai(double x, double y, double x1, double y1, double goc) {
		goc = Math.toRadians(goc);
		double sin = Math.sin(goc);
		double cos = Math.cos(goc);
		Point d = new Point();
		x -= x1;
		y -= y1;
		d.x = x * cos + y * sin + x1;
		d.y = y * cos + y1 - x * sin;
		return d;
	}

	public static void EllipseMidPoint(double xc, double yc, double a, double b, GraphicsContext gr, double lw) {
		double x, y;
		x = 0;
		y = b;
		double A, B;
		A = a * a;
		B = b * b;
		double p = B + A / 4 - A * b;
		x = 0;
		y = b;
		double Dx = 0;
		double Dy = 2 * A * y;

		PutPixel(x + xc, y + yc, gr, lw);
		PutPixel(-x + xc, y + yc, gr, lw);
		PutPixel(x + xc, -y + yc, gr, lw);
		PutPixel(-x + xc, -y + yc, gr, lw);

		while (Dx < Dy) {
			x++;
			Dx += 2 * B;
			if (p < 0)
				p += B + Dx;
			else {
				y--;
				Dy -= 2 * A;
				p += B + Dx - Dy;
			}
			PutPixel(x + xc, y + yc, gr, lw);
			PutPixel(-x + xc, y + yc, gr, lw);
			PutPixel(x + xc, -y + yc, gr, lw);
			PutPixel(-x + xc, -y + yc, gr, lw);
		}
		p = B * (x + 0.5f) * (x + 0.5f) + A * (y - 1) * (y - 1) - A * B;
		while (y > 0) {
			y--;
			Dy -= A * 2;
			if (p > 0)
				p += A - Dy;
			else {
				x++;
				Dx += B * 2;
				p += A - Dy + Dx;
			}
			PutPixel(x + xc, y + yc, gr, lw);
			PutPixel(-x + xc, y + yc, gr, lw);
			PutPixel(x + xc, -y + yc, gr, lw);
			PutPixel(-x + xc, -y + yc, gr, lw);

		}
	}

	static void DDA(double x1, double y1, double x2, double y2, GraphicsContext gr, double lw) {
		double Dx, Dy, count;
		Dx = x2 - x1;
		Dy = y2 - y1;
		if (Math.abs(Dy) > Math.abs(Dx))
			count = Math.abs(Dy);
		else
			count = Math.abs(Dx);
		double x, y, delta_X, delta_Y;
		if (count > 0) {
			delta_X = Dx;
			delta_X /= count;
			delta_Y = Dy;
			delta_Y /= count;
			x = x1;
			y = y1;
			do {
				PutPixel(x, y, gr, lw);
				x += delta_X;
				y += delta_Y;
				--count;
			} while (count >= 0);

		}
	}

}
