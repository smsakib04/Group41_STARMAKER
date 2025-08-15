module groupfortyone.group41_starmaker {
    requires javafx.controls;

    opens groupfortyone.group41_starmaker.Samanta to javafx.fxml;
    requires javafx.fxml;
 //   requires groupfortyone.group41_starmaker;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.jdi;
//    requires groupfortyone.group41_starmaker;
  //  requires javafx.graphics;


    opens groupfortyone.group41_starmaker to javafx.fxml;
    opens groupfortyone.group41_starmaker.Salman to javafx.fxml;
    opens groupfortyone.group41_starmaker.Raghib to javafx.fxml;
    opens groupfortyone.group41_starmaker.Youshra to javafx.fxml;

    exports groupfortyone.group41_starmaker;
    exports groupfortyone.group41_starmaker.Salman;
    exports groupfortyone.group41_starmaker.Raghib;
    exports groupfortyone.group41_starmaker.Youshra;
    exports groupfortyone.group41_starmaker.Samanta;
}