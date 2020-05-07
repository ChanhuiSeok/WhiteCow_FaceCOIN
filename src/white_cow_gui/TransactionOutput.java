package white_cow_gui;
import java.io.Serializable;
import java.security.PublicKey;

public class TransactionOutput implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public PublicKey reciepient; // �������� ����Ű
	public float value; // �����ο��� ���ư� ������ ��
	public String parentTransactionId; // �ش� output�� ���Ե� transaction�� id
	
	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
	}
	
	// �۱��� �� �Ǿ����� Ȯ���Ѵ�. 
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
	}
	
}