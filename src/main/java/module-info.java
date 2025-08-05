module groupfortyone.group41_starmaker {
    requires javafx.controls;
    requires javafx.fxml;


    opens groupfortyone.group41_starmaker to javafx.fxml;
    opens groupfortyone.group41_starmaker.Salman to javafx.fxml;
//    opens groupfortyone.group41_starmaker.Salman to javafx.fxml;

    exports groupfortyone.group41_starmaker;
    exports groupfortyone.group41_starmaker.Salman;
//    exports groupfortyone.group41_starmaker.Salman;
}