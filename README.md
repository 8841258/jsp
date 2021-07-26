# jsp


MVC 패턴

*.do 요청이 들어오면

FrontController로 요청을 전달하고,

알맞는 Command 객체를 호출,

Command 객체는 ServiceImpl에서 데이터를 들여온다

FrontController는 Servlet
init()과 service()가 존재한다

init()에는 HashMap 객체에 Command를 등록한다
