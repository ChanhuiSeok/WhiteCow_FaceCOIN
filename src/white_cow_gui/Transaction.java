package white_cow_gui;
import java.io.Serializable;

import java.security.*;
import java.util.ArrayList;

public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String transactionId; // 트랜잭션의 hash값
	public PublicKey sender; // 송신자의 공개키(주소)
	public PublicKey reciepient; // 수신자의 공개키(주소)
	public float value; // 전달 할 금액
	public byte[] signature; // 암호화된 서명
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0; // 생성된 트랜잭션의 수.
	
	public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	// 트랜잭션 id를 구하기 위해 Hashing하는 메서드
	private String calulateHash() {
		sequence++; // 같은 hash값을 피하기 위해 

		return StringUtil.applySha256(
				StringUtil.getStringFromKey(sender) +
				StringUtil.getStringFromKey(reciepient) +
				Float.toString(value) + sequence
				);
		}
	
	public boolean processTransaction() {
			
			if(verifiySignature() == false) {
				System.out.println("#Transaction Signature failed to verify");
				return false;
			}
					
			//gather transaction inputs (Make sure they are unspent):
			for(TransactionInput i : inputs) {
				i.UTXO = NoobChain.UTXOs.get(i.transactionOutputId);
			}
			// 최소 거래 금액을 만족했는지 판단
			if(getInputsValue() < NoobChain.minimumTransaction) {
				System.out.println("#Transaction Inputs to small: " + getInputsValue());
				return false;
			}
			
			// output 생성
			float leftOver = getInputsValue() - value; // 거스름돈 
			transactionId = calulateHash();
			outputs.add(new TransactionOutput( this.reciepient, value,transactionId)); // 수취인에게 전달
			outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); // 잔돈은 송금인에게 반납		
					
			// 새로 생성된 output을 UTXO collection에 추가한다.
			for(TransactionOutput o : outputs) {
				NoobChain.UTXOs.put(o.id , o);
			}
			
			// 쓰인 UTXO는 collection 에서 삭제한다.
			for(TransactionInput i : inputs) {
				if(i.UTXO == null) continue; 
				NoobChain.UTXOs.remove(i.UTXO.id);
			}
			
			return true;
		}
		
	// 현재 트랜잭션의 input 총량
		public float getInputsValue() {
			float total = 0;
			for(TransactionInput i : inputs) {
				if(i.UTXO == null) continue; 
				total += i.UTXO.value;
			}
			return total;
		}
	// 현재 트랜잭션의 ouput 총량
		public float getOutputsValue() {
			float total = 0;
			for(TransactionOutput o : outputs) {
				total += o.value;
			}
			return total;
		}
		

		public void generateSignature(PrivateKey privateKey) {
			String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;
			signature = StringUtil.applyECDSASig(privateKey,data);		
		}
		public boolean verifiySignature() {
			String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;
			return StringUtil.verifyECDSASig(sender, data, signature);
		}
	
}
