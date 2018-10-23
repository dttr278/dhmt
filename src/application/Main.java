package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		stage.setTitle("Vẽ hình cơ bản - dttr");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setOnShown(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Chương trình vẽ hình cơ bản");
			alert.setHeaderText("Nhóm 5 - D15CQCN01");
			alert.setContentText("Đỗ Tấn Trung - N15DCCN041 " + "\nNguyễn Văn Phi Long - N15DCCN017"
					+ "\nTrần Ngọc Hiếu - N15DCCN001" + "\nTrần Huy Hoàng - N15DCCN002"
					+ "\nĐào Văn Thành - N15DCCN004");
			alert.showAndWait();
		});
		stage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
