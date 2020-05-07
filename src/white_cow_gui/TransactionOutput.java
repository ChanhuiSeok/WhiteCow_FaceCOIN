package white_cow_gui;
import java.io.Serializable;
import java.security.PublicKey;

public class TransactionOutput implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public PublicKey reciepient; // 수취인의 공개키
	public float value; // 수취인에게 돌아갈 코인의 양
	public String parentTransactionId; // 해당 output이 포함된 transaction의 id
	
	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
	}
	
	// 송금이 잘 되었는지 확인한다. 
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
	}
	
}