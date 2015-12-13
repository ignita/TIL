# 트래픽 제어  
- 트래픽: 특정 전송로 상 일정 시간 동안 흐르는 Data의 양  
- 특정 호스트가 누구와 통신을 많이 하는지에 대한 정보도 네트워크 보안에 포함  
- 예) 전쟁 중 특정 부대와의 교신량이 평소보다 증가하면 그 지역에서 모종의 군사 작전이 있을 가능성 높음.  
  일반 회사에서도 특정 회사끼리 접촉이 잦으면 모종의 상업적인 협력이 있을 수 있음.  
  - 외부 침입자의 통신량 분석을 방해하는 간단한 방법은 무의미한 가공 데이터를 여러 호스트에서 주기적으로 발생시킴으로써 통계 자료에 혼선을 주는 것  
  
# 방화벽  
- 인터넷이 확산되면서 허가 받지 않은 사용자의 불법적인 사설망 접근을 방지하는 문제가 중요시됨.  
- 방화벽(Firewall): 개방적인 공중 인터넷망과 제한된 사용자 그룹에게 허가된 사설 망 사이에 보안 기능  
- 사설 망을 외부로부터 보호하는 가장 간단한 방법은 외부 망을 완전히 끊어 버리는 것.  
- 네트워크에서 트래픽을 제어하는 프로그램 또는 장치.  
- 해커/바이러스 등의 공격을 차단하기 위함이 가장 큰 목적  
- 불필요한 트래픽의 유입으로 성능이 저하되는 것을 방지하는 역할도함.  
- 백신은 행동을 감시, 방화벽은 침입을 차단.  
  - 예) 어떤 회사의 컴퓨터가 있는데 중요한 정보가 외부로 유출되지 않게 하기 위해 다양한 방법으로 보안을 유지한다.  
  건물 내부에는 보안 요원(백신의 실시간 감시)이 회사 안 모든 사람을 감시하고  
  회사 건물 입구에는 경비원(방화벽)이 있다. 건물에 들어오거나 나가는 사람의 이름과 신상명세를 보안 부서에 알리고 보안부서가 허용을 해야 비로소 그 사람은 건물안으로 들어오거나 나갈 수 있다.   
  
## 요약  
1. 데이터 전송 과정에서 외부 침입자로부터 데이터를 보호하려면 암호화하여 전송해야 한다. 그리고 수신자는 암호화된 데이터를 해독할 수 있어야 한다.

2. 임의의 문자를 다른 문자로 대체하는 대체 암호화 방식에는 시저 암호화, 키워드 암호화, 복수 개의 문자표 등이 있다.

3. 문자의 위치를 변경하는 위치 암호화 방식에는 컬럼 암호화, 키워드 암호화 등이 있다.

4. DES 알고리즘:　비공개키를 이용한 암호화 방식으로 송수신자가 동일한 비밀키를 사용한다.

5. RSA 알고리즘: 공개키를 이용해 암호문을 작성하고 비공개키를 이용해 암호문을 해독한다.

6. 전자 서명은 비공개키를 이용해 암호문을 작성하고 공개키를 이용해 암호문을 해독한다.

7. 전송 선로의 감청으로부터 데이터를 보호하려면 응용 계층 암호화를 사용한다.
8. 전송 경로에 있는 호스트 내부에서 데이터를 보호하려면 응용 계층 암호화를 사용한다.

9. 방화벽 기능을 이용해 패킷 정보를 해석하여 내부 네트워크를 외부 네트워크의 불법 침입으로부터 보호할 수 있다.

10. 프록시 기능을 이용해 응용 계층의 내용을 해석하여 내부 네트워크를 외부 네트워크의 불법 침입으로부터 보호할 수 있다.
  