package example2;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("전송할 메세지 입력:");
		String msg=scan.nextLine();
		
		//필요한 객체를 담을 변수 만들기
		Socket socket=null;
		BufferedWriter bw=null;
		try {
			//new Socket(서버의 ip, port 번호)
			socket= new Socket("192.168.0.73",5000);//접속 요청
//			socket= new Socket("127.0.0.1",5000);//내 아이피 전송
			System.out.println("Socket 연결 성공!");
//			OutputStream os=socket.getOutputStream();
//			OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
			bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);//문자열 출력
			bw.newLine();//개행기호 출력
			bw.flush();//방출(전송)
			System.out.println("서버에 문자열 전송 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null)bw.close();
				if(socket!=null)socket.close();
			} catch (Exception e2) {
			
			}
		}
	}
}
