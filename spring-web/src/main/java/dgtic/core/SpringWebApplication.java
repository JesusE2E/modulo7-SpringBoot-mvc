package dgtic.core;
/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}

*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication extends Application {
    private static org.springframework.context.ConfigurableApplicationContext context;
    public static void main(String[] args) {

        new Thread(() -> {
            context = SpringApplication.run(SpringWebApplication.class, args);
        }).start();

        launch(args);
    }
    @Override
    public void start(Stage stage) {

        Label loading = new Label("Cargando aplicación...");
        StackPane loadingPane = new StackPane(loading);

        Scene loadingScene = new Scene(loadingPane, 400, 200);

        stage.setTitle("Mi Aplicación");
        stage.setScene(loadingScene);
        stage.show();

        WebView webView = new WebView();

        new Thread(() -> {

            // Espera hasta que Spring Boot esté listo
            while (context == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Platform.runLater(() -> {

                webView.getEngine().load("http://localhost:8080");

                Scene scene = new Scene(webView, 1200, 800);

                stage.setScene(scene);
            });

        }).start();

        stage.setOnCloseRequest(e -> System.exit(0));
    }
}