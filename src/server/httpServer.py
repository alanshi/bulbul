#! /usr/bin/env python
#coding=utf-8
from BaseHTTPServer import HTTPServer,BaseHTTPRequestHandler
import socket
import parse


class MyHttpHandler(BaseHTTPRequestHandler):

    #任务处理
    def TaskProcessor(self,data):
        #解析命令参数
        commandKey,commandValue =  parse.ParsePrarmeters(data)

        #执行命令参数并返回
        return parse.ExecCommand(commandKey,commandValue)

    #响应GET请求
    def do_GET(self):
        self.data = self.path
        strs = self.TaskProcessor(self.data)
        self.send_response(200, 'OK')
        self.send_header('Content-type', 'text/html;charset=utf-8')
        self.end_headers()
        self.wfile.write(strs)

    #响应POST请求
    def do_POST(self):
        #import cgi, cgitb
        try:
            pass
        except :
            pass



if __name__ == '__main__':

    localIP = socket.gethostbyname(socket.gethostname())
    port = 2588
    httpd = HTTPServer((localIP,port),MyHttpHandler)
    print('Server Started %s:%s' %(localIP, port))
    httpd.serve_forever()  #启动http服务器
