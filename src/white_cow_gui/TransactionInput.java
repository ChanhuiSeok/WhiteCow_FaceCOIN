package white_cow_gui;
import java.io.Serializable;

public class TransactionInput implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String transactionOutputId; // TransactionOutputs �� transactionId�� �����ϰ� �ȴ�.
	public TransactionOutput UTXO; // ������ output�� UTXO�� ���´�.
	
	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}