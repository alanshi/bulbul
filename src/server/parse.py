#! /usr/bin/env python
#coding=utf-8

import sys
import os
import json

#添加当前文件的父目录(项目根目录)到系统搜索路径
#sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from control import xpVolume
from control import vistaVolume
from control import media
from control import mouse
from control import system

#currentProName = None

#执行命令
def ExecCommand(commandKey,commandValue):
    #global currentProName
    print 'ExecCommand',commandKey,commandValue
    #如果是连接命令
    if commandKey == 'conn':
        try:
            return 'conn success!!!!'
        except Exception:
            return 'conn Fail !!!!'
        return 'conn Fail !!!!'

    #如果是音量调节
    elif commandKey == 'setVolume':

        try:
            #获取要设置的音量值
            volume = int(commandValue)
            print 'volume:',volume,type(volume)
            #如果是vista或者win7的系统
            if system.GetOSVersion()[0] >5:
                #vv = VistaVolume()
                print 'SetMasterVolume'
                vistaVolume.SetMasterVolume(volume)
            #其他操作系统
            else:
                #sv = SystemVolume()
                print 'SetVolume'
                xpVolume.SetVolume(volume)
            return json.dumps('SetVolume %s Success !!!' %(str(volume)))
        except Exception:
            return json.dumps('SetVolume %s Fail !!!' %(str(volume)))
        return json.dumps('SetVolume %s Fail !!!' %(str(volume)))

    #如果是媒体控制
    elif commandKey == 'mediaControl':
        print 'mediaControl'
        try:
            #创建媒体控制类的实例
            mc = media.MediaControl()
            #执行媒体控制
            mc.ExecControl(commandValue)

            return json.dumps('Media Control %s success !!!' %(commandValue))
        except Exception:
            return json.dumps('Media Control %s Fail !!!' %(commandValue))
        return json.dumps('Media Control %s Fail !!!' %(commandValue))

    #如果是系统控制
    elif commandKey == 'systemControl':

        #如果是关机命令
        if commandValue == 'shutdown':
            
            system.Shutdown()
            return 'shutdown!!!'
        #如果是注销
        if commandValue == 'reboot':
            
            system.Reboot()
            return 'reboot!!!'
        #如果是注销命令
        if commandValue == 'logoff':
            
            system.Logout()
            return 'logoff'



    #如果是移动鼠标
    elif commandKey == 'mouseMove':
        #解析变量
        commandValueList = commandValue.split("/")
        #获取x,y
        x = int(float(commandValueList[1]))
        y = int(float(commandValueList[2]))
        #移动鼠标
        mouseControl.MoveMouse(commandValueList[0],x,y)
        #mouseControl.Move(x,y)
        return u'mouseMove success!!!'

    #如果是点击鼠标
    elif commandKey == 'mouseClick':
        mouseControl.ClickMouse(commandValue)
        return u'mouseClick success!!!'

    else:
        return u'prarmeters error!!!!'


#解析参数
def ParsePrarmeters(data):
    #print 'data:',data
    """
        参数格式 命令类型:具体指令
        mediaControl:next
        systemControl:reboot
        setVolume:50
    """

    #get请求
    if data.find("/") == 0:
        commandStr = str(data[1:])
    #post请求
    else:
        commandStr = str(data)
    #拆分命令格式
    commandList = commandStr.split(':')
    #print 'commandList:',commandList
    #return commandList
    #返回命令结果
    return commandList[0],commandList[1]

a,b = ParsePrarmeters('mediaControl:next')
ExecCommand(a,b)

