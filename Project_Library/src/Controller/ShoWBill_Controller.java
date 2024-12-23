package Controller;

import Files.BillFile;
import Model.Bill;
import View.Bill_IdView;
import View.DetailsBills_ByID;
import javafx.collections.ObservableList;

public class ShoWBill_Controller {
    private Bill_IdView view;
    private BillFile file;

    public ShoWBill_Controller(Bill_IdView view) {
        this.view = view;
        this.file = new BillFile();
        view.getShowDetailsButton().setOnAction(e -> getBillDetail());
    }

    public void getBillDetail() {
        Integer selectedId = view.getBillIdListView().getSelectionModel().getSelectedItem();
        if (selectedId != null) {
            System.out.println("Success");
            ObservableList<Bill> allBills = file.getAll();
            Bill selectedBill = allBills.stream()
                    .filter(bill -> selectedId.equals(bill.getBillID()))
                    .findFirst()
                    .orElse(null);

            if (selectedBill != null) {
                DetailsBills_ByID billView = new DetailsBills_ByID(selectedBill);
                billView.getStage().show();
            }
        } else {
            System.out.println("No bill selected");
        }
    }

    public Bill_IdView getView() {
        return view;
    }
}
