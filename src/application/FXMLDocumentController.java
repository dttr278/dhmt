package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

enum BienDoi {
	DXDIEM, DXDT, XOAY, NONE
}

public class FXMLDocumentController implements Initializable {

	public ObservableList<MShape> s;
	double ox, oy;
	MShape shape;
	double x1, y1, x2, y2;
	BienDoi bd = BienDoi.NONE;
	Point p;
	@FXML
	Canvas cv;
	@FXML
	ToggleButton tbtnLine;
	@FXML
	ToggleButton tbtnRect;
	@FXML
	ToggleButton tbtnSquare;
	@FXML
	ToggleButton tbtnCircle;
	@FXML
	ToggleButton tbtnEllipse;
	@FXML
	ToggleButton tbtnBall;
	@FXML
	ToggleButton tbtnBall1;
	@FXML
	ToggleButton tbtnBall2;
	@FXML
	ToggleGroup shapeGroup;
	@FXML
	ColorPicker clpicLine;
	@FXML
	ColorPicker clpicFill;
	@FXML
	StackPane cvStack;

	@FXML
	Button btnClear;
	@FXML
	Button btnClear1;
	@FXML
	Button btnBack;
	@FXML
	Button btnHHCN;
	@FXML
	Button btnHC;
	@FXML
	StackPane cvStack1;
	@FXML
	Canvas cv1;
	@FXML
	ListView<MShape> lvBienDoi;
	@FXML
	Button btnTT;
	@FXML
	Button btnThuPhong;
	@FXML
	Button btnXoay;
	@FXML
	Button btnDX;
	@FXML
	Button btnDXDT;
	@FXML
	Button btnDel;
	@FXML
	TextArea text3DTab;
	@FXML
	ToggleButton tbtnChonO;

	MLine lOx, lOy;
	GraphicsContext gr;
	GraphicsContext gr1;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ox = oy = 0;
		s = FXCollections.observableArrayList(myListItem -> new Observable[] { myListItem.update });
		lvBienDoi.setItems(s);

		gr = cv.getGraphicsContext2D();
		gr1 = cv1.getGraphicsContext2D();
		lOx = new MLine(0, 0, 0, 0, gr, Color.BLACK);
		lOy = new MLine(0, 0, 0, 0, gr, Color.BLACK);
		Ve3D v = new Ve3D(gr1, cv1.getWidth(), cv1.getHeight(), 255, 350);
		v.VeToaDo();
		clpicLine.setValue(Color.BLACK);
		clpicFill.setValue(Color.TRANSPARENT);
		DrawAll();
		btnClear.setOnAction(e -> {
			cv.getGraphicsContext2D().clearRect(0, 0, 700, 600);
			s.clear();
		});
		cv.setOnMousePressed(e -> {
			x1 = x2 = e.getX() - ox;
			y1 = y2 = e.getY() - oy;
			if (bd == BienDoi.XOAY) {
				String goc = XoayDialog();
				lvBienDoi.getSelectionModel().getSelectedItem().Xoay(x1, y1, Double.valueOf(goc));
				lvBienDoi.getSelectionModel().getSelectedItem().UpDate();
				bd = BienDoi.NONE;

			} else if (bd == BienDoi.DXDIEM) {
				lvBienDoi.getSelectionModel().getSelectedItem().DoiXungQuaDiem(x1, y1);
				lvBienDoi.getSelectionModel().getSelectedItem().UpDate();
				bd = BienDoi.NONE;
			} else if (bd == BienDoi.DXDT) {
				if (p == null)
					p = new Point(x1, y1);
				else {
					lvBienDoi.getSelectionModel().getSelectedItem().DoiXungQuaDT(p.x, p.y, x1, y1);
					lvBienDoi.getSelectionModel().getSelectedItem().UpDate();
					bd = BienDoi.NONE;
					p = null;
				}
			} else if (tbtnLine.isSelected()) {
				shape = new MLine(x1, y1, x2, y2, gr, clpicLine.getValue());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnRect.isSelected()) {
				shape = new MRectange(x1, y1, 0, 0, gr, clpicLine.getValue(), clpicFill.getValue());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnSquare.isSelected()) {
				shape = new MSquare(x1, y1, 0, gr, clpicLine.getValue(), clpicFill.getValue());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnEllipse.isSelected()) {
				shape = new MEllipse(x1, y1, 0, 0, gr, clpicLine.getValue(), clpicFill.getValue());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnCircle.isSelected()) {
				shape = new MCircle(x1, y1, 0, gr, clpicLine.getValue(), clpicFill.getValue());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnBall.isSelected()) {
				shape = new Ball(x1, y1, 10, gr, clpicLine.getValue(), clpicFill.getValue(), 3, cv.getWidth(),
						cv.getHeight());
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnBall1.isSelected()) {
				shape = new Ball1(x1, y1, 30, gr, clpicLine.getValue(), clpicFill.getValue(), 2);
				shape.ChonO(ox, oy);
				s.add(shape);
			} else if (tbtnBall2.isSelected()) {
				shape = new Ball2(x1, y1, 160, gr, clpicLine.getValue(), clpicFill.getValue(), 3, cv.getWidth(),
						cv.getHeight(), ox, oy);
				s.add(shape);
			} else if (tbtnChonO.isSelected()) {
				ox = e.getX();
				oy = e.getY();

				lOx.setX1(0);
				lOx.setY1(oy);
				lOx.setX2(cv.getWidth());
				lOx.setY2(oy);

				lOy.setX1(ox);
				lOy.setY1(0);
				lOy.setX2(ox);
				lOy.setY2(cv.getHeight());

				for (int i = 0; i < s.size(); i++) {
					s.get(i).ChonO(ox, oy);
				}
			}

		});

		cv.setOnMouseDragged(e -> {
			x2 = e.getX() - ox;
			y2 = e.getY() - oy;
			if (tbtnLine.isSelected()) {
				MLine l = (MLine) shape;
				l.setY2(y2);
				l.setX2(x2);
				l.UpDate();
			} else if (tbtnRect.isSelected()) {
				MRectange rec = (MRectange) shape;
				rec.SetWidth(x2 - rec.getTopx()[0]);
				rec.SetHeight(y2 - rec.getTopy()[0]);
				rec.UpDate();
			} else if (tbtnSquare.isSelected()) {
				MSquare squa = (MSquare) shape;
				;
				squa.SetWidth(x2 - squa.getTopx()[0]);
				squa.SetHeight(x2 - squa.getTopx()[0]);
				squa.UpDate();
			} else if (tbtnEllipse.isSelected()) {

				MEllipse ellip = (MEllipse) shape;
				if (x2 > x1) {
					double rx = ellip.getA();
					double dx = x2 - ellip.getX() - rx;
					rx = (x2 - x1) / 2;
					ellip.setX(ellip.getX() + dx);
					ellip.setA(rx);
					ellip.UpDate();
				}
				if (y2 > y1) {
					double ry = ellip.getB();
					double dy = y2 - ellip.getY() - ry;
					ry = (y2 - y1) / 2;
					ellip.setY(ellip.getY() + dy);
					ellip.setB(ry);
					ellip.UpDate();
				}

			} else if (tbtnCircle.isSelected()) {
				if (x2 > x1) {
					MCircle ellip = (MCircle) shape;
					double rx = ellip.getA();
					double dx = x2 - ellip.getX() - rx;
					rx = (x2 - x1) / 2;
					ellip.setX(ellip.getX() + dx);
					ellip.setA(rx);
					ellip.setB(rx);
					ellip.UpDate();
				}

			} else if (tbtnChonO.isSelected()) {
				ox = e.getX();
				oy = e.getY();

				lOx.setX1(0);
				lOx.setY1(oy);
				lOx.setX2(cv.getWidth());
				lOx.setY2(oy);

				lOy.setX1(ox);
				lOy.setY1(0);
				lOy.setX2(ox);
				lOy.setY2(cv.getHeight());

				for (int i = 0; i < s.size(); i++) {
					s.get(i).ChonO(ox, oy);
				}
			}

		});

		btnHHCN.setOnMouseClicked(ev -> {
			Dialog<String[]> d = new Dialog<>();
			d.setTitle("Hình hộp chữ nhật");
			d.setHeaderText("Nhập thông tin");

			TextField x = new TextField();
			TextField y = new TextField();
			TextField z = new TextField();
			TextField cao = new TextField();
			TextField dai = new TextField();
			TextField rong = new TextField();

			GridPane grid = new GridPane();
			grid.add(new Label("x: "), 0, 0);
			grid.add(x, 1, 0);
			grid.add(new Label("y: "), 2, 0);
			grid.add(y, 3, 0);
			grid.add(new Label("z: "), 4, 0);
			grid.add(z, 5, 0);

			grid.add(new Label("Cao: "), 0, 1);
			grid.add(cao, 1, 1);
			grid.add(new Label("Rộng: "), 2, 1);
			grid.add(rong, 3, 1);
			grid.add(new Label("Dai: "), 4, 1);
			grid.add(dai, 5, 1);

			grid.setVgap(10);
			grid.setHgap(10);

			d.setResultConverter(dialogButton -> {
				if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
					String[] str = { x.getText(), y.getText(), z.getText(), cao.getText(), rong.getText(),
							dai.getText() };
					return str;
				}
				return null;
			});

			d.getDialogPane().getButtonTypes().addAll(new ButtonType("Ok", ButtonData.OK_DONE),
					new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
			d.getDialogPane().setContent(grid);

			Optional<String[]> rs = d.showAndWait();

			rs.ifPresent(s -> {
				try {
					v.HHCN(Integer.valueOf(x.getText()), Integer.valueOf(y.getText()), Integer.valueOf(z.getText()),
							Integer.valueOf(dai.getText()), Integer.valueOf(rong.getText()),
							Integer.valueOf(cao.getText()));
					text3DTab.appendText("\nHình hộp chữ nhật:" + "\nx: " + x.getText() + "\ny: " + y.getText()
							+ "\nz: " + z.getText() + "\ndai: " + dai.getText() + "\nrong: " + rong.getText()
							+ "\ncao: " + cao.getText());
				} catch (Exception e2) {
					// TODO: handle exception

				}

			});
		});

		btnHC.setOnAction(e -> {
			Dialog<String[]> d = new Dialog<>();
			d.setTitle("Hình chốp");
			d.setHeaderText("Nhập thông tin");

			TextField x = new TextField();
			TextField y = new TextField();
			TextField z = new TextField();
			TextField cao = new TextField();
			TextField dai = new TextField();

			GridPane grid = new GridPane();
			grid.add(new Label("x: "), 0, 0);
			grid.add(x, 1, 0);
			grid.add(new Label("y: "), 2, 0);
			grid.add(y, 3, 0);
			grid.add(new Label("z: "), 4, 0);
			grid.add(z, 5, 0);

			grid.add(new Label("Cao: "), 0, 1);
			grid.add(cao, 1, 1);
			grid.add(new Label("Dai: "), 2, 1);
			grid.add(dai, 3, 1);

			grid.setVgap(10);
			grid.setHgap(10);

			d.setResultConverter(dialogButton -> {
				if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
					String[] str = { x.getText(), y.getText(), z.getText(), cao.getText(), dai.getText() };
					return str;
				}
				return null;
			});

			d.getDialogPane().getButtonTypes().addAll(new ButtonType("Ok", ButtonData.OK_DONE),
					new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
			d.getDialogPane().setContent(grid);

			Optional<String[]> rs = d.showAndWait();

			rs.ifPresent(s -> {
				try {
					v.HChop(Integer.valueOf(x.getText()), Integer.valueOf(y.getText()), Integer.valueOf(z.getText()),
							Integer.valueOf(dai.getText()), Integer.valueOf(cao.getText()));
					text3DTab.appendText("\nHình chốp:" + "\nx: " + x.getText() + "\ny: " + y.getText() + "\nz: "
							+ z.getText() + "\ndai: " + dai.getText() + "\ncao: " + cao.getText());
				} catch (Exception e2) {
					// TODO: handle exception

				}
			});
		});

		btnBack.setOnAction(e -> {
			if (s.size() > 0) {
				s.remove(s.size() - 1);
				gr.clearRect(0, 0, cv.getWidth(), cv.getHeight());
			}
		});

		btnClear1.setOnAction(e -> {
			gr1.clearRect(0, 0, cv.getWidth(), cv.getHeight());
			v.VeToaDo();
			text3DTab.setText("");
		});

		btnDel.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				s.remove(m);
			}
		});
		btnTT.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				try {
					String[] d = TinhTienDialog();
					m.TinhTien(Integer.valueOf(d[0]), Integer.valueOf(d[1]));
					m.UpDate();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnThuPhong.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				try {
					String[] d = ThuPhongDialog();
					m.ThuPhong(Double.valueOf(d[0]), Double.valueOf(d[1]));
					m.UpDate();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnDX.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Chọn 1 điểm ");
				alert.showAndWait();
				bd = BienDoi.DXDIEM;
			}
		});
		btnDXDT.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Chọn 2 điểm ");
				alert.showAndWait();
				bd = BienDoi.DXDT;
			}
		});
		btnXoay.setOnAction(e -> {
			MShape m = lvBienDoi.getSelectionModel().getSelectedItems().get(0);
			if (m != null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Chọn 1 điểm ");
				alert.showAndWait();
				bd = BienDoi.XOAY;
			}
		});
	}

	void DrawAll() {
//		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				gr.clearRect(0, 0, cv.getWidth(), cv.getHeight());
//				
//				lOx.Draw();
//				lOy.Draw();
//				for (int i = 0; i < s.size(); i++) {
//					s.get(i).Draw();
//				}
//			}
//		}));
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				gr.clearRect(0, 0, cv.getWidth(), cv.getHeight());
				
				lOx.Draw();
				lOy.Draw();
				for (int i = 0; i < s.size(); i++) {
					s.get(i).Draw();
				}
			}
		}.start();
	}

	String[] TinhTienDialog() {
		Dialog<String[]> d = new Dialog<>();
		d.setTitle("Tinh tiến");
		d.setHeaderText("Nhập thông tin");

		TextField dx = new TextField("0");
		TextField dy = new TextField("0");

		GridPane grid = new GridPane();
		grid.add(new Label("dx: "), 0, 0);
		grid.add(dx, 1, 0);
		grid.add(new Label("dy: "), 2, 0);
		grid.add(dy, 3, 0);

		grid.setVgap(10);
		grid.setHgap(10);

		d.setResultConverter(dialogButton -> {
			if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
				String[] str = { dx.getText(), dy.getText() };
				return str;
			}
			return null;
		});

		d.getDialogPane().getButtonTypes().addAll(new ButtonType("Ok", ButtonData.OK_DONE),
				new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
		d.getDialogPane().setContent(grid);

		Optional<String[]> rs = d.showAndWait();

		return rs.get();
	}

	String[] ThuPhongDialog() {
		Dialog<String[]> d = new Dialog<>();
		d.setTitle("Thu phóng");
		d.setHeaderText("Nhập thông tin");

		TextField sx = new TextField("1");
		TextField sy = new TextField("1");

		GridPane grid = new GridPane();
		grid.add(new Label("sx: "), 0, 0);
		grid.add(sx, 1, 0);
		grid.add(new Label("sy: "), 2, 0);
		grid.add(sy, 3, 0);

		grid.setVgap(10);
		grid.setHgap(10);

		d.setResultConverter(dialogButton -> {
			if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
				String[] str = { sx.getText(), sy.getText() };
				return str;
			}
			return null;
		});

		d.getDialogPane().getButtonTypes().addAll(new ButtonType("Ok", ButtonData.OK_DONE),
				new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
		d.getDialogPane().setContent(grid);

		Optional<String[]> rs = d.showAndWait();
		return rs.get();
	}

	String XoayDialog() {
		Dialog<String> d = new Dialog<>();
		d.setTitle("Tinh tiến");
		d.setHeaderText("Nhập thông tin");

		TextField goc = new TextField();

		GridPane grid = new GridPane();
		grid.add(new Label("goc: "), 0, 0);
		grid.add(goc, 1, 0);

		grid.setVgap(10);
		grid.setHgap(10);

		d.setResultConverter(dialogButton -> {
			if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
				String str = goc.getText();
				return str;
			}
			return null;
		});

		d.getDialogPane().getButtonTypes().addAll(new ButtonType("Ok", ButtonData.OK_DONE),
				new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
		d.getDialogPane().setContent(grid);

		Optional<String> rs = d.showAndWait();
		return rs.get();
	}
}
