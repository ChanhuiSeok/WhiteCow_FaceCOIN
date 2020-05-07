package white_cow_gui;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	public HashMap<String,TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>(); // UTXO ����
	
	public Wallet(){
		generateKeyPair();	
	}
		
	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// Ű �����ڸ� �ʱ�ȭ�ϰ� KeyPair�� �����Ѵ�.
			keyGen.initialize(ecSpec, random);   // 256����Ʈ
	        		KeyPair keyPair = keyGen.generateKeyPair();
	        		// ����Ű, ����Ű ����
	        		privateKey = keyPair.getPrivate();
	        		publicKey = keyPair.getPublic();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public float getBalance() {
		float total = 0;	
       for (Map.Entry<String, TransactionOutput> item: NoobChain.UTXOs.entrySet()){
       	TransactionOutput UTXO = item.getValue();
           if(UTXO.isMine(publicKey)) { //�ش� UTXO�� �� ������
           	UTXOs.put(UTXO.id,UTXO); //������ �� ������ UTXOs�� �߰�
           	total += UTXO.value ;
           }
       } 
		return total;
	}
	// Ʈ������� �߻���Ű�� ��ȯ�Ѵ�.
	public Transaction sendFunds(PublicKey _recipient,float value ) {
		if(getBalance() < value) { // �۱� �� �� �ִ� ��ŭ�� ��(����)�� ����.
			System.out.println("#Not Enough funds to send transaction. Transaction Discarded.");
			return null;
		}
   // Ʈ����� ���� input list
		ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
  
		float total = 0;
		for (Map.Entry<String, TransactionOutput> item: UTXOs.entrySet()){
			TransactionOutput UTXO = item.getValue();
			total += UTXO.value;
			inputs.add(new TransactionInput(UTXO.id));
			if(total > value) break;
		}
		// Ʈ����� ����
		Transaction newTransaction = new Transaction(publicKey, _recipient , value, inputs);
		// ����
		newTransaction.generateSignature(privateKey);
		
		// ����� UTXO�� ����
		for(TransactionInput input: inputs){
			UTXOs.remove(input.transactionOutputId);
		}
		return newTransaction;
	}
}