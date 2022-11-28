package main.financial;

public class CreditCard {
	private String cardNumber;
	private String expirationDate;
	private String cvcCode;
	
	
	public CreditCard(String cardNumber, String expirationDate, String cvcCode) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvcCode = cvcCode;
	}


	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCvcCode() {
		return cvcCode;
	}
	public void setCvcCode(String cvcCode) {
		this.cvcCode = cvcCode;
	}


	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cvcCode=" + cvcCode + "]";
	}
	
	
	
	

}
