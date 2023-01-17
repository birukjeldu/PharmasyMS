module pharmacy.pharmacyms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pharmacy to javafx.fxml;
    exports com.pharmacy;
}