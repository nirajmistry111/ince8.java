module ca.durhamcollege.oop3200f2022week10b {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200f2022week10b to javafx.fxml;
    exports ca.durhamcollege.oop3200f2022week10b;
}