module EightPuzzleSearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlin.stdlib.jdk7;

    opens dev.jacaro.school.eightpuzzlesearch.resources.fxml to javafx.fxml;

    exports dev.jacaro.school.eightpuzzlesearch.entry;
}