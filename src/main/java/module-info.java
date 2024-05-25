module com.aspe.pricipalamount.midterm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aspe.pricipalamount.midterm to javafx.fxml;
    exports com.aspe.pricipalamount.midterm;
}