module assignment2.scrabblepoint.a2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens assignment2.scrabblepoint.a2 to javafx.fxml;
    exports assignment2.scrabblepoint.a2;
}