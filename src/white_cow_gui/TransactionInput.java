package white_cow_gui;
import java.io.Serializable;

public class TransactionInput implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String transactionOutputId; // TransactionOutputs 의 transactionId를 참조하게 된다.
	public TransactionOutput UTXO; // 참조한 output의 UTXO를 갖는다.
	
	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}