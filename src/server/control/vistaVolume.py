#! /usr/bin/env python
#coding=utf-8
import os,ctypes

"""
    SetVistaVolume 本模块只能用于改变vista,windows7或windows2003系统的 音量设置
"""

#调用VistaVolume.dll
pluginDir = os.path.abspath(os.path.split(__file__)[0])
dllPath = os.path.join(pluginDir, "VistaVolume.dll")
vistaVolumeDll = ctypes.cdll.LoadLibrary("VistaVolume.dll")
vistaVolumeDll.SetMasterVolume.argtypes = [ctypes.c_float]
vistaVolumeDll.GetMasterVolume.restype = ctypes.c_float

#创建VistaVolume类
#class VistaVolume:

def MuteOn(deviceId=0):
    vistaVolumeDll.SetMute(1)
    return True

def MuteOff(deviceId=0):
    vistaVolumeDll.SetMute(0)
    return False

def ToggleMute(deviceId=0):
    newValue = not vistaVolumeDll.GetMute()
    vistaVolumeDll.SetMute(newValue)
    return newValue

def GetMute(deviceId=0):
    return vistaVolumeDll.GetMute()

#兼容模式
def ChangeMasterVolumeBy(value, deviceId=0):
    old = vistaVolumeDll.GetMasterVolume()
    vistaVolumeDll.SetMasterVolume((old * 100.0 + value) / 100.0)
    return vistaVolumeDll.GetMasterVolume() * 100.0


#设置当前主音量
def SetMasterVolume(value, deviceId=0):
    vistaVolumeDll.SetMasterVolume(value / 100.0)
    return vistaVolumeDll.GetMasterVolume() * 100.0
#获取当前音量
def GetMasterVolume():
    return vistaVolumeDll.GetMasterVolume() * 100.0

if __name__ == '__main__':


    print SetMasterVolume(100)
    #print v.GetMasterVolume()
