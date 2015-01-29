1. Create user in jboss with login(vgerton) and password(sdf12DF&!hgj). Or change this data in Subscriber and SendMessageServlet.
2. mvn clean install.
3. copy war in jboss.
4. start jboss (./standalone.sh -c standalone-full.xml)
5. start client
6. go to http://localhost:8080/jms-server/InputMessageServlet.do.