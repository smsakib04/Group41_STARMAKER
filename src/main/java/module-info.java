module groupfortyone.group41_starmaker {
    requires javafx.controls;
    requires javafx.fxml;


    opens groupfortyone.group41_starmaker to javafx.fxml;
    opens groupfortyone.group41_starmaker.Salman to javafx.fxml;
    opens groupfortyone.group41_starmaker.Raghib to javafx.fxml;
//    opens groupfortyone.group41_starmaker.Youshra to javafx.fxml;
//    opens groupfortyone.group41_starmaker.Samanta to javafx.fxml;

    exports groupfortyone.group41_starmaker;
    exports groupfortyone.group41_starmaker.Salman;
    exports groupfortyone.group41_starmaker.Raghib;
//    exports groupfortyone.group41_starmaker.Youshra;
//    exports groupfortyone.group41_starmaker.Samanta;
}