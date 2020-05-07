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
	
	public HashMap<String,TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>(); // UTXO 저장
	
	public Wallet(){
		generateKeyPair();	
	}
		
	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// 키 생성자를 초기화하고 KeyPair를 생성한다.
			keyGen.initialize(ecSpec, random);   // 256바이트
	        		KeyPair keyPair = keyGen.generateKeyPair();
	        		// 개인키, 공개키 설정
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
           if(UTXO.isMine(publicKey)) { //해당 UTXO가 내 것인지
           	UTXOs.put(UTXO.id,UTXO); //맞으면 내 지갑의 UTXOs에 추가
           	total += UTXO.value ;
           }
       } 
		return total;
	}
	// 트랜잭션을 발생시키고 반환한다.
	public Transaction sendFunds(PublicKey _recipient,float value ) {
		if(getBalance() < value) { // 송금 할 수 있는 만큼의 돈(코인)이 없다.
			System.out.println("#Not Enough funds to send transaction. Transaction Discarded.");
			return null;
		}
   // 트랜잭션 안의 input list
		ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
  
		float total = 0;
		for (Map.Entry<String, TransactionOutput> item: UTXOs.entrySet()){
			TransactionOutput UTXO = item.getValue();
			total += UTXO.value;
			inputs.add(new TransactionInput(UTXO.id));
			if(total > value) break;
		}
		// 트랜잭션 생성
		Transaction newTransaction = new Transaction(publicKey, _recipient , value, inputs);
		// 서명
		newTransaction.generateSignature(privateKey);
		
		// 사용한 UTXO는 삭제
		for(TransactionInput input: inputs){
			UTXOs.remove(input.transactionOutputId);
		}
		return newTransaction;
	}
}