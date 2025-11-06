module com.example.frindr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.frindr to javafx.fxml;
    exports com.example.frindr;
}