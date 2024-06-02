module com.example.alpha0001 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.desktop;

    requires java.sql;
    requires mysql.connector.j;

    opens com.projetoa3.alpha0001 to javafx.fxml;
    exports com.projetoa3.alpha0001;



    exports com.projetoa3.alpha0001.Principal.Produtos;
    opens com.projetoa3.alpha0001.Principal.Produtos to javafx.fxml;
}