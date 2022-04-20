package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{
	
	//Internal state-----------------------------------------------------------------------------
	
	 @Autowired InventorItemToolListService inventorItemListService;
	 
//	 @Autowired InventorItemShowService inventorItemShowService;
	 
	 //Constructor-------------------------------------------------------------------------------
	 
	 @PostConstruct
	 protected void inialise() {
		 super.addCommand("list", this.inventorItemListService);
//		 super.addCommand("showTools", this.inventorItemShowService);
//		 super.addCommand("listComponents", this.inventorItemShowService);
//		 super.addCommand("showComponents", this.inventorItemShowService);
	 }
}
