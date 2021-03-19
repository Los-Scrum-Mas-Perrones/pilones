import com.jfoenix.assets.JFoenixResources;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.svg.SVGGlyphLoader;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {


    public static boolean ventana_splash = false;

    @Override
    public void start(Stage stage) throws Exception{

            StackPane root = FXMLLoader.load(getClass().getResource("/pantalla_principal.fxml"));

            JFXDecorator decorator = new JFXDecorator(stage, root,false,false,true);
           
            decorator.setGraphic(new SVGGlyph(""));

            stage.setTitle("Plasencia");
            stage.setMaximized(false);
            stage.setResizable(false);

            double width = 1200;
            double height = 780;

            Scene scene = new Scene(decorator, width, height);
            stage.setScene(scene);
            stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}


