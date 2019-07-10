package interview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreditCardProcessorTest {

	private CreditCardProcessor cardProcessor;

	@BeforeMethod
	public void Setup() {
		cardProcessor = new CreditCardProcessor();
	}

	@Test
	public void GetCardType() {
		Assert.assertEquals(cardProcessor.getCardType("4111111111111111"), "VISA");
		Assert.assertEquals(cardProcessor.getCardType("41111111111111111"), "Unknown");
		Assert.assertEquals(cardProcessor.getCardType("341111111111111"), "Amex");
		Assert.assertEquals(cardProcessor.getCardType("3711111111111111"), "Unknown");
		Assert.assertEquals(cardProcessor.getCardType("6011111111111111"), "Discovery");
		Assert.assertEquals(cardProcessor.getCardType("6511111111111"), "Unknown");
		Assert.assertEquals(cardProcessor.getCardType("3511111111111111"), "JCB");
		Assert.assertEquals(cardProcessor.getCardType("3511111111111111111"), "JCB");
	}
}
