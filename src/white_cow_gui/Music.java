package white_cow_gui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // javazoom 에서 얻은 라이브러리의 클래스
	private boolean isLoop; // 곡의 무한반복 or 한번만 재생
	private File file;
	private FileInputStream fileInput;
	private BufferedInputStream bufferInput;
	// 메모리 버퍼 접근 bufferInput 객체 생성 (작동 효율을 높이기 위해)
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fileInput = new FileInputStream(file);
			bufferInput = new BufferedInputStream(fileInput);
			// 버퍼 작동 시 fileInputStream 에서 담았던 file을 부른다.
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
		// javazoom 라이브러리에 있는 메소드를 사용하기 위한 응용 메소드 getTime
		// getPosition() : 재생 중인 음악이 현재 몇 초까지 재생중인지에 대한 정보를 반환한다.
		// 예를 들어, 음악이 재생 시작 후 1분 30초 를 지나가고 있다면 90000 이라는 숫자 반환
	}
	
	public void close() { // 음악을 종료할 때 사용할 메소드
		isLoop = false;
		player.close();
		this.interrupt(); // 스레드 중지상태로 만듬
	}
	@Override
	public void run() { // thread 상속받을 시 무조건 재정의해야하는 메소드
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
