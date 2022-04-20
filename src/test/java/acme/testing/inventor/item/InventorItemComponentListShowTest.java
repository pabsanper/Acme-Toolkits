package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemComponentListShowTest extends TestHarness {

	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/componentList.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String type, final String code, final String description, final String link, final String name, final String retailPrice, final String technology ) {
		super.signIn("inventor1", "inventor1");

		//List----------------------------------------------
		super.clickOnMenu("Inventor", "My Components List");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, technology);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, retailPrice);
		super.checkColumnHasValue(recordIndex, 6, link);
		
		//Show--------------------------------------------------------------
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("itemType", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("link", link);
		
	}

}