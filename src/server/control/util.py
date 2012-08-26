#! /usr/bin/env python
#coding=utf-8
import sys
import os
import win32gui

#添加当前文件的父目录(项目根目录)到系统搜索路径
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from settings import define

class Tools:
    
    def __init__(self):
        self.LoggedInnerName = ''
        self.currentRunInternalName = None

    #获取当前活动窗口
    def GetForegroundWindow(self):
        hwnd = win32gui.GetForegroundWindow()
        self.windowTitle = win32gui.GetWindowText(hwnd)
        print 'self.windowTitle',self.windowTitle
        return self.windowTitle

        #返回内部程序名映射列表
    def GetInnerNameList(self):
        return define.innerNameList

    #返回热键列表
    def GetHotKeyList(self):
        return define.hotKeySimpleList


    #获取程序内部名称
    def GetProInternalName(self,windowTitle):
        #遍历程序列表
        for i in define.innerNameList:
            #转换编码
            x = unicode(windowTitle,"gbk")
            #如果key存在
            if i in x:
                #返回内部名称
                return define.innerNameList[i]
            else:
                continue
            return None
    
    #获取当前运行的程序名称 (根据窗口标题获取)
    def GetCurrentRunInnerName(self):
        try:
            windowTitle = self.GetForegroundWindow()
            self.currentRunInternalName = self.GetProInternalName(windowTitle)
            if self.currentRunInternalName != None:
                fileHandle = open('control/save.txt','w')
                fileHandle.write(self.currentRunInternalName)
                fileHandle.close()   

        except Exception:
            self.currentRunInternalName = None
        
        return self.currentRunInternalName

    #获取当前运行的程序名 --记忆
    def GetLoggedInnerName(self):
        try:
            fileHandle = open('control/save.txt','r')
            self.LoggedInnerName = fileHandle.readline()
            fileHandle.close()
            return self.LoggedInnerName  
        except:
            return None
        return LoggedInnerName

# #获取当前活动窗口
# def GetForegroundWindow():
#     print 'GetForegroundWindow:',GetForegroundWindow
#     hwnd = win32gui.GetForegroundWindow()
#     windowTitle = win32gui.GetWindowText(hwnd)
#     print 'windowTitle:',windowTitle
#     return windowTitle
