module com.hopur7h.hotels.hopur7h {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hopur7h.hotels.hopur7h to javafx.fxml;
    exports com.hopur7h.hotels.hopur7h;
}
