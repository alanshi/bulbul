#! /usr/bin/env python
#coding=utf-8
import socket
import sys

def client(ip, port, message):


    HOST, PORT = ip, port
    data = " ".join(sys.argv[1:])

    # SOCK_DGRAM is the socket type to use for UDP sockets
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    # As you can see, there is no connect() call; UDP has no connections.
    # Instead, data is directly sent to the recipient via sendto().
    sock.sendto(message + "\n", (HOST, PORT))
    received = sock.recv(1024)

    print "Sent:     %s" % data
    print "Received: %s" % received
    sock.close()
if __name__ == "__main__":

    client("192.168.100.101",2588,"hello")