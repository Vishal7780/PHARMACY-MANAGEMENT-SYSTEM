package Admin;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import application.Controller;
import application.FxmlLoader;

public class AdminController extends Controller {
	protected Stage stage;
	@FXML
	protected BorderPane borderpane; 
	@FXML
	protected BorderPane borderpane1; 
	
	protected Pane view;
	Pane view1;
	@FXML
	private void ShowManageP(ActionEvent e) throws IOException {
		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManagePharmacist.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManagePharmacist");
		borderpane.setCenter(view);
		
		view1 = object1.getPage("MP-Add");
		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	private void ShowDoctorP(ActionEvent e) throws IOException {
//		Parent borderpane1 ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin/ManageDoctor.fxml"));
		borderpane1 = loader.load();

		FxmlLoader1 object = new FxmlLoader1();
//		FxmlLoader1 object1 = new FxmlLoader1();
		view = object.getPage("ManageDoctor");
		borderpane.setCenter(view);
		
//		view1 = object1.getPage("MP-Add1");
//		((BorderPane) borderpane1).setCenter(view1);
	}
	@FXML
	private void ShowDash(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("Dashboard");
		borderpane.setCenter(view);
	}
	@FXML
	private void ShowAdd(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MP-Add");
		borderpane1.setCenter(view);
	}
	@FXML
	private void ShowSearch(ActionEvent e) {
		
		FxmlLoader1 object = new FxmlLoader1();
		view = object.getPage("MP-Search");
		borderpane1.setCenter(view);
		addButtonToTable();
	}
	
	@FXML
	private void Addtolist(ActionEvent e) {

		super.Apply(e);
	}
	@FXML
	private void Re(ActionEvent e) {

		super.Reset2(e);
	}
	
	@FXML
    public void ShowHome(ActionEvent e) throws IOException {
		
    	Parent borderpane ;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Pharmacy.fxml"));
		borderpane = loader.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(borderpane);
//		scene.getStylesheets().add(getClass().getResource("/appliaction/application.css").toExternalForm());
		Image icon = new Image("\\Images\\logo.png");
		
		
		FxmlLoader object = new FxmlLoader();
		view = object.getPage("Home");
		((BorderPane) borderpane).setCenter(view);
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	@FXML
    public void Exit (ActionEvent e) {
		stage.close();
	}
	@FXML
	private TableView<Data> PharmacistTable = new TableView <>();
	@FXML
	private void addButtonToTable() {
        TableColumn<Data, Void> edit = new TableColumn<Data, Void>("EDIT");

        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
            @Override
            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

                    private final Button btn = new Button("EDIT");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Data data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        edit.setCellFactory(cellFactory);

        PharmacistTable.getColumns().add(edit);

    }
}