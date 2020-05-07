package white_cow_gui;
import java.io.Serializable;

import java.security.*;
import java.util.ArrayList;

public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String transactionId; // Ʈ������� hash��
	public PublicKey sender; // �۽����� ����Ű(�ּ�)
	public PublicKey reciepient; // �������� ����Ű(�ּ�)
	public float value; // ���� �� �ݾ�
	public byte[] signature; // ��ȣȭ�� ����
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0; // ������ Ʈ������� ��.
	
	public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	// Ʈ����� id�� ���ϱ� ���� Hashing�ϴ� �޼���
	private String calulateHash() {
		sequence++; // ���� hash���� ���ϱ� ���� 

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
			// �ּ� �ŷ� �ݾ��� �����ߴ��� �Ǵ�
			if(getInputsValue() < NoobChain.minimumTransaction) {
				System.out.println("#Transaction Inputs to small: " + getInputsValue());
				return false;
			}
			
			// output ����
			float leftOver = getInputsValue() - value; // �Ž����� 
			transactionId = calulateHash();
			outputs.add(new TransactionOutput( this.reciepient, value,transactionId)); // �����ο��� ����
			outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); // �ܵ��� �۱��ο��� �ݳ�		
					
			// ���� ������ output�� UTXO collection�� �߰��Ѵ�.
			for(TransactionOutput o : outputs) {
				NoobChain.UTXOs.put(o.id , o);
			}
			
			// ���� UTXO�� collection ���� �����Ѵ�.
			for(TransactionInput i : inputs) {
				if(i.UTXO == null) continue; 
				NoobChain.UTXOs.remove(i.UTXO.id);
			}
			
			return true;
		}
		
	// ���� Ʈ������� input �ѷ�
		public float getInputsValue() {
			float total = 0;
			for(TransactionInput i : inputs) {
				if(i.UTXO == null) continue; 
				total += i.UTXO.value;
			}
			return total;
		}
	// ���� Ʈ������� ouput �ѷ�
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
