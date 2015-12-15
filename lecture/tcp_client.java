import java.io.*;
import java.net.*;

public class MessageReceiver {
  public static void main(String[] args) throws Exception {
    String server = args[0];
    int port = Integer.parseInt(args[1]);
    
    Socket c = new Socket(server, port);
    // 서버와 연결하기 위한 소켓
    System.out.println("서버접속준비완료");
    
    InputStream is = c.getInputStream();
    // 데이터를 보내기 위한 스트림 객체
    
    DataInputStream dis = new DataInputStream(is);
    // 전송 데이터형을 변경해주기 위한 스트림
    
    StringBuffer j = new StringBuffer();
    // 서버로부터 수신한 데이터를 저장하기 위한 스트링버퍼객체
    
    System.out.println("서버로부터 받은 데이터\n>>");
        char ch = 0;
        for(int i=0; i < 11; i++)
        {
            ch = dis.readChar();
            // 서버로부터 데이터 수신
            j.append(ch);
            // 데이터를 저장
        }
        System.out.println(j);
        // 데이터를 출력
        c.close();
        // 소켓을 닫음
        
    }
  }
    
