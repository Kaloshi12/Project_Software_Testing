package View;

import Files.BillFile;
import Model.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Bill_IdView extends BorderPane {
    private ListView<Integer> billIdListView;
    private Stage stage;
    private Button showDetailsButton;
    private BillFile file = new BillFile();
    private ObservableList<Integer> billIds = FXCollections.observableArrayList();

    public Bill_IdView() {
        stage = new Stage();
        stage.setTitle("List of Bills");

        // Populate billIds with the existing Bill IDs
        for (Bill bill : file.getAll()) {
            billIds.add(bill.getBillID());
        }

        billIdListView = new ListView<>(billIds);
        billIdListView.setId("billList");
        showDetailsButton = new Button("Show Bill");
        showDetailsButton.setId("detailsBill");
        showDetailsButton.setPrefWidth(80);
        showDetailsButton.setPrefHeight(40);

        setCenter(billIdListView);
        setBottom(showDetailsButton);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ListView<Integer> getBillIdListView() {
        return billIdListView;
    }

    public void setBillIdListView(ListView<Integer> billIdListView) {
        this.billIdListView = billIdListView;
    }

    public Button getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(Button showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public ObservableList<Integer> getBillIds() {
        return billIds;
    }
}
