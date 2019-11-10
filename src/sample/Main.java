package sample;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.opencv.core.Core;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("Identify Person ");

        FileChooser fileChooser = new FileChooser();

        Button button = new Button("Select File");

        Label filename = new Label("Filename: ");
        Label hasperson = new Label("Has Person: ");

        //Creating an image
        Image image = new Image(new FileInputStream("/home/moita/IdeaProjects/lp2/img/default.png"));
        //Setting the image view
        ImageView imageView = new ImageView(image);
        //Setting the position of the image
        //setting the fit height and width of the image view
        imageView.setFitHeight(355);
        imageView.setFitWidth(400);
        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);

            Dataset dataset = new Dataset();
            processImage img = new processImage(selectedFile.getPath());

            imageView.setImage(new Image(selectedFile.toURI().toString()));
            imageView.setFitHeight(355);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);
            filename.setText("Filename: "+ selectedFile.getName());

            Controller controller = new Controller();

            Boolean  hasPerson  = controller.knn(dataset.getData(), img.getFeatures(), 10);
            hasperson.setText("Filename: "+ hasPerson);

        });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(filename, 0, 2);
        GridPane.setConstraints(hasperson, 1, 2);

        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(imageView, 1, 1);

        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(button, imageView, filename, hasperson);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }


    public static void main(String[] args) {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        launch(args);
    }
}
