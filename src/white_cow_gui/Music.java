package white_cow_gui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // javazoom ���� ���� ���̺귯���� Ŭ����
	private boolean isLoop; // ���� ���ѹݺ� or �ѹ��� ���
	private File file;
	private FileInputStream fileInput;
	private BufferedInputStream bufferInput;
	// �޸� ���� ���� bufferInput ��ü ���� (�۵� ȿ���� ���̱� ����)
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fileInput = new FileInputStream(file);
			bufferInput = new BufferedInputStream(fileInput);
			// ���� �۵� �� fileInputStream ���� ��Ҵ� file�� �θ���.
			player = new Player(bufferInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//
		}
	}
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
		// javazoom ���̺귯���� �ִ� �޼ҵ带 ����ϱ� ���� ���� �޼ҵ� getTime
		// getPosition() : ��� ���� ������ ���� �� �ʱ��� ����������� ���� ������ ��ȯ�Ѵ�.
		// ���� ���, ������ ��� ���� �� 1�� 30�� �� �������� �ִٸ� 90000 �̶�� ���� ��ȯ
	}
	
	public void close() { // ������ ������ �� ����� �޼ҵ�
		isLoop = false;
		player.close();
		this.interrupt(); // ������ �������·� ����
	}
	@Override
	public void run() { // thread ��ӹ��� �� ������ �������ؾ��ϴ� �޼ҵ�
		try {
			do {
				player.play();
				fileInput = new FileInputStream(file);
				bufferInput = new BufferedInputStream(fileInput);
				player = new Player(bufferInput);
			}while (isLoop);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
