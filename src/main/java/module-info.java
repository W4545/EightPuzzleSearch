module EightPuzzleSearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires org.controlsfx.controls;

    opens dev.jacaro.school.eightpuzzlesearch.resources.fxml to javafx.fxml;
    opens dev.jacaro.school.eightpuzzlesearch.resources.images to javafx.fxml;
    opens dev.jacaro.school.eightpuzzlesearch.gui.controllers to javafx.fxml;

    opens dev.jacaro.school.eightpuzzlesearch.gui.structures to javafx.base;

    exports dev.jacaro.school.eightpuzzlesearch.entry;
}