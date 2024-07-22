package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.resources.ResourcesLocation;

public class SignupScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Text text;
    protected final Text text0;
    protected final TextField usernametxtField;
    protected final Text text1;
    protected final PasswordField passwordTxtField;
    protected final Text text2;
    protected final PasswordField confirmPassTxtField;
    protected final Button signupButton;
    protected final Hyperlink loginRedirect;

    public SignupScreenBase() {

        imageView = new ImageView();
        text = new Text();
        text0 = new Text();
        usernametxtField = new TextField();
        text1 = new Text();
        passwordTxtField = new PasswordField();
        text2 = new Text();
        confirmPassTxtField = new PasswordField();
        signupButton = new Button();
        loginRedirect = new Hyperlink();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1000.0);
        setPrefWidth(1500.0);
        getStyleClass().add("button");

        imageView.setFitHeight(1000.0);
        imageView.setFitWidth(1500.0);
        imageView.setLayoutX(-4.0);
        imageView.setLayoutY(-1.0);
        imageView.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/main.jpg").toExternalForm()));

        text.setFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        text.setLayoutX(676.0);
        text.setLayoutY(112.0);
        text.setStroke(javafx.scene.paint.Color.valueOf("#1b1919"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("Signup");
        text.setFont(new Font("Agency FB", 70.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        text0.setLayoutX(647.0);
        text0.setLayoutY(253.0);
        text0.setStroke(javafx.scene.paint.Color.valueOf("#171717"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setText("Username");
        text0.setFont(new Font("Agency FB", 70.0));

        usernametxtField.setLayoutX(585.0);
        usernametxtField.setLayoutY(306.0);
        usernametxtField.setPrefHeight(44.0);
        usernametxtField.setPrefWidth(348.0);
        usernametxtField.setPromptText("Write here...");
        usernametxtField.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 10.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        text1.setLayoutX(637.0);
        text1.setLayoutY(433.0);
        text1.setStroke(javafx.scene.paint.Color.valueOf("#171717"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setText("Password");
        text1.setFont(new Font("Agency FB", 70.0));

        passwordTxtField.setLayoutX(592.0);
        passwordTxtField.setLayoutY(456.0);
        passwordTxtField.setPrefHeight(44.0);
        passwordTxtField.setPrefWidth(348.0);
        passwordTxtField.setPromptText("Write here...");
        passwordTxtField.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 10.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        text2.setLayoutX(573.0);
        text2.setLayoutY(601.0);
        text2.setStroke(javafx.scene.paint.Color.valueOf("#171717"));
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setText("Confirm password");
        text2.setFont(new Font("Agency FB", 70.0));

        confirmPassTxtField.setLayoutX(592.0);
        confirmPassTxtField.setLayoutY(623.0);
        confirmPassTxtField.setPrefHeight(44.0);
        confirmPassTxtField.setPrefWidth(348.0);
        confirmPassTxtField.setPromptText("Write here...");
        confirmPassTxtField.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 10.0));

        signupButton.setLayoutX(686.0);
        signupButton.setLayoutY(742.0);
        signupButton.setMnemonicParsing(false);
        signupButton.setPrefHeight(49.0);
        signupButton.setPrefWidth(160.0);
        signupButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        signupButton.setText("Signup");
        signupButton.setTextFill(javafx.scene.paint.Color.WHITE);
        signupButton.setFont(new Font("Agency FB", 30.0));

        loginRedirect.setLayoutX(643.0);
        loginRedirect.setLayoutY(821.0);
        loginRedirect.setText("Have an account? Login!");
        loginRedirect.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        loginRedirect.setFont(new Font("Agency FB", 30.0));

        getChildren().add(imageView);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(usernametxtField);
        getChildren().add(text1);
        getChildren().add(passwordTxtField);
        getChildren().add(text2);
        getChildren().add(confirmPassTxtField);
        getChildren().add(signupButton);
        getChildren().add(loginRedirect);

    }
}
