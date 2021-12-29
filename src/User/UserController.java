package User;

import java.io.IOException;

import Admin.AdminController;
import Doctor.FxmlLoader4;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserController extends AdminController {
	@FXML
    public void Logout(ActionEvent e) throws IOException {
		super.ShowHome(e);   	
	}
	@FXML
	public void MyOrders(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("MyOrders");
		borderpane.setCenter(view);
	}
	@FXML

    public void Exit() {
		super.ExitApplication();   	
	}

	public void MyCart(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("MyCart");
		borderpane.setCenter(view);
	}
	@FXML
	public void PreviousOrders(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("PreviousOrders");
		borderpane.setCenter(view);
	}
	@FXML
	public void Medicines(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Medicines");
		borderpane.setCenter(view);
	}
	@FXML
	public void Dashboard(ActionEvent e) {
		
		FxmlLoader4 object = new FxmlLoader4();
		view = object.getPage("Dashboard");
		borderpane.setCenter(view);
	}
	@FXML
    public void dashboardUser() throws IOException {
    	super.Dashboard();
    }

}
