import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TesteJanelaFX extends Application {
    @Override
    public void start(Stage stage){
        Pane painel = new Pane();
        Scene scn = new Scene(painel);

        scn.getStylesheets().add
                (TesteJanelaFX.class.getResource("estilo.css").toExternalForm());

        Label lblTexto = new Label("Hello World");
        lblTexto.relocate(100.0, 30.0);
        Button btn = new Button("Ok");
        btn.relocate(150.0, 100.0);
        // painel.getChildren().add(lblTexto);
        // painel.getChildren().add(btn);
        painel.getChildren().addAll(lblTexto, btn);

        stage.setScene(scn);
        stage.setTitle("Minha primeira Janela JavaFX");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(TesteJanelaFX.class, args);
    }
}
