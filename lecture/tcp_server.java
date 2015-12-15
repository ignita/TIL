import java.net.*;
public class MessageSender {
  public static void main(String[] args) throws Exception{
    int port = Integer.parseInt(args[0]);
    ServerSocket ss = new ServerSocket(port);
    while(true){
      System.out.println("서버 준비완료... 클라이언트의 접속을 기다립니다.");
      Socket s = ss.accept();
      // 클라이언트가 접속할때까지 대기 상태
      OutputStream os = s.getOutputStream();
      // 클라이언트에게 데이터 전송을 위한 스트림
      DataOutputStream dos = new DataOutputStream(os);
      // 클라이언트에게 전송할 데이터형을 변형하기 위한 스트림
      dos.writeChars("서버에 연결되었습니다.");
      // 클라이언트에게 데이터를 전송
      System.out.println("전송이 완료 되었습니다.");
      // 소켓을 닫음
      s.close();
    }
  }
}
