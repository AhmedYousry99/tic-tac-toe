package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.resources.ResourcesLocation;

public  class LoginScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;
    protected final Text text0;
    protected final TextField usernameTxtField;
    protected final Text text1;
    protected final Button loginButton;
    protected final Hyperlink hyperlink;
    protected final TextField passwordTxtField;

    public LoginScreenBase() {

        imageView = new ImageView();
        text = new Text();
        text0 = new Text();
        usernameTxtField = new TextField();
        text1 = new Text();
        loginButton = new Button();
        hyperlink = new Hyperlink();
        passwordTxtField = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1000.0);
        setPrefWidth(1500.0);

        imageView.setFitHeight(1000.0);
        imageView.setFitWidth(1500.0);
        imageView.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/main.jpg").toExternalForm()));

        text.setFill(javafx.scene.paint.Color.valueOf("#f2f0f0"));
        text.setLayoutX(681.0);
        text.setLayoutY(89.0);
        text.setStroke(javafx.scene.paint.Color.valueOf("#1b1a1a"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("Login");
        text.setWrappingWidth(138.4462890625);
        text.setFont(new Font("Agency FB", 70.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#f2f0f0"));
        text0.setLayoutX(629.0);
        text0.setLayoutY(300.0);
        text0.setStroke(javafx.scene.paint.Color.valueOf("#282828"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setText("Username");
        text0.setWrappingWidth(254.4462890625);
        text0.setFont(new Font("Agency FB", 70.0));

        usernameTxtField.setLayoutX(597.0);
        usernameTxtField.setLayoutY(355.0);
        usernameTxtField.setPrefHeight(49.0);
        usernameTxtField.setPrefWidth(318.0);
        usernameTxtField.setPromptText("Write here...");
        usernameTxtField.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#f2f0f0"));
        text1.setLayoutX(641.0);
        text1.setLayoutY(512.0);
        text1.setStroke(javafx.scene.paint.Color.valueOf("#1b1a1a"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setText("Password");
        text1.setWrappingWidth(254.4462890625);
        text1.setFont(new Font("Agency FB", 70.0));

        loginButton.setLayoutX(660.0);
        loginButton.setLayoutY(708.0);
        loginButton.setMnemonicParsing(false);
        loginButton.setPrefHeight(77.0);
        loginButton.setPrefWidth(180.0);
        loginButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        loginButton.setText("Login");
        loginButton.setTextFill(javafx.scene.paint.Color.valueOf("#f2efef"));
        loginButton.setFont(new Font("Agency FB", 40.0));

        hyperlink.setLayoutX(605.0);
        hyperlink.setLayoutY(785.0);
        hyperlink.setText("Don't have an account? Signup!");
        hyperlink.setTextFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        hyperlink.setFont(new Font("Agency FB", 28.0));

        passwordTxtField.setLayoutX(597.0);
        passwordTxtField.setLayoutY(569.0);
        passwordTxtField.setPrefHeight(49.0);
        passwordTxtField.setPrefWidth(318.0);
        passwordTxtField.setPromptText("Write here...");
        passwordTxtField.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        getChildren().add(imageView);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(usernameTxtField);
        getChildren().add(text1);
        getChildren().add(loginButton);
        getChildren().add(hyperlink);
        getChildren().add(passwordTxtField);

    }
}
