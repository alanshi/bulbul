#! /usr/bin/env python
#coding=utf-8

import SocketServer
import socket
import parse
class ThreadedTCPRequestHandler(SocketServer.BaseRequestHandler):
    """
    This class works similar to the TCP handler class, except that
    self.request consists of a pair of data and client socket, and since
    there is no connection the client address must be given explicitly
    when sending data back via sendto().
    """

    def handle(self):
        data = self.request[0].strip()
        socket = self.request[1]
        strs = self.TaskProcessor(data)
        print "%s wrote:" % self.client_address[0]
        print strs
        socket.sendto(strs, self.client_address)

    #任务处理
    def TaskProcessor(self,data):
        #解析命令参数
        commandKey,commandValue =  parse.ParsePrarmeters(data)

        #执行命令参数并返回
        return parse.ExecCommand(commandKey,commandValue)


if __name__ == "__main__":
    localIP = '192.168.0.101'
    #localIP = socket.gethostbyname(socket.gethostname())
    print 'local-IP:',localIP
    HOST, PORT = localIP, 2588
    server = SocketServer.UDPServer((HOST, PORT), ThreadedTCPRequestHandler)
    server.serve_forever()
