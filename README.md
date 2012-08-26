bulbul
======

a mobile phone telecontrol pc solutions

python-library

 * Python for Windows extensions: http://sourceforge.net/projects/pywin32/
 * SendKeys http://www.rutherfurd.net/python/sendkeys/
 
 
 
run example:

 server:
 
  * src/server/udpServer.py Line 33 localIP = '192.168.0.101' modified to your Ip
  * exec python src/server/udpServer.py
  
  
 client:
 
  * install mmptp.apk in android2.2 or higher system
  * run app and input server ip,press connect button