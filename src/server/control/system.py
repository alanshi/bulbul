#! /usr/bin/env python
#coding=utf-8
import sys
import time
import win32security
import win32api
import win32con

logoff = win32con.EWX_LOGOFF
reboot = win32con.EWX_REBOOT
shutdown = win32con.EWX_SHUTDOWN


#注销系统
def Logout():
    win32api.ExitWindowsEx(logoff)
#重启系统
def Reboot():
    win32api.ExitWindowsEx(reboot)
#关机
def Shutdown():
    win32api.ExitWindowsEx(shutdown)


#获取系统版本号
def GetOSVersion():

    majorVersion, minorVersion = sys.getwindowsversion()[0:2]
    return majorVersion, minorVersion
    
