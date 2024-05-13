module david.finalproyect {
    requires javafx.controls;
    requires javafx.fxml;


    opens david.finalproyect to javafx.fxml;
    exports david.finalproyect;
}