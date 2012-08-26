#! /usr/bin/env python
#coding=utf-8

#import os
#import sys


#添加当前文件的父目录(项目根目录)到系统搜索路径
#sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
import util
import base
import time
import hotKey

class MediaControl():

    def __init__(self):
        self.CurrentRunInnerName = None
        

    #执行媒体控制
    def ExecControl(self,commandValue):
        hotKeyControl = hotKey.HotKey()
        keyStr = ''

        #获取当前运行的程序内部名称
        tools = util.Tools()
        self.CurrentRunInnerName = tools.GetCurrentRunInnerName()
        print 'CurrentRunInnerName:',self.CurrentRunInnerName
        #如果能找到当前运行的程序内部名称
        if self.CurrentRunInnerName != None:

            #loggedInnerName = self.CurrentRunInnerName
            keyStr = tools.GetHotKeyList()[self.CurrentRunInnerName][commandValue]

        #不能找到当前运行的程序内部名称
        else:
            print 'loggedInnerName:',loggedInnerName
            loggedInnerName = tools.GetLoggedInnerName()
            keyStr = tools.GetHotKeyList()[loggedInnerName][commandValue]

        #执行热键
        hotKeyControl.ExecCommendKeys(keyStr)

if __name__ == "__main__":

    mc = MediaControl()
    time.sleep(3)
    mc.ExecControl('PausePlay')
    time.sleep(3)
    mc.ExecControl('PausePlay')
