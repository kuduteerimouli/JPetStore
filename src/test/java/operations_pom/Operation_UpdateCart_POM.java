package operations_pom;

import java.io.IOException;
import org.testng.annotations.Test;
import base_Works.ChooseBrowser;
import pom.UpdateCart_POM;

public class Operation_UpdateCart_POM extends ChooseBrowser{


	UpdateCart_POM update;
	@Test
	public void Update_Quantity() throws InterruptedException, IOException
	{
		web.navigate().to("https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-18");
		update=new UpdateCart_POM(web);
		
		update.getQuantity_dog().clear();
		
		update.getQuantity_dog().sendKeys("5");
		
		
		//Removing parrot due to out off stock
		update.getUpdateCart().click();
		update.getRemove_parrot().click();
		//write wait statement
		update.getUpdateCart().click();
		screenShot("Update Cart");
		update.getCheckout().click();
		
		closeBrowser();
	}

}