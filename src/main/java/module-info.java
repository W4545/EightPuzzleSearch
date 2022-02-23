module EightPuzzleSearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens dev.jacaro.school.eightpuzzlesearch.resources.fxml to javafx.fxml;
    opens dev.jacaro.school.eightpuzzlesearch.gui.controllers to javafx.fxml;

    exports dev.jacaro.school.eightpuzzlesearch.entry;
}