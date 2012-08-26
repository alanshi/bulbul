#! /usr/bin/env python
#coding=utf-8

import ctypes
import struct

"""
    SetVolume 本模块只能用于改变windowsxp系统的 音量设置
"""


#利用winmm设置/获取系统音量
waveOutGetVolume = (ctypes.windll.winmm.waveOutGetVolume)

waveOutSetVolume = (ctypes.windll.winmm.waveOutSetVolume)

# 最小/最大音量的常量设定
MINIMUM_VOLUME = 0     # fader control (MSDN Library)
MAXIMUM_VOLUME = 4294967295 # fader control (MSDN Library)

#调节音量 volue范围 0-100
def SetVolume(volume):
    """Set the speaker volume on the 'Volume Control' mixer"""
    if not (MINIMUM_VOLUME <= volume <= MAXIMUM_VOLUME):
        raise ValueError, "Volume out of range"
    #按公式处理音量数值
    volume = volume * MAXIMUM_VOLUME/100;
    #设置音量
    ret = waveOutSetVolume(0, volume)
    if ret != 0:
        print WindowsError, "Error %d while setting volume" % ret
    #print 'Volume set to ' + str(volume)
    return

#获取当前音量
def GetVolume():
    vol=ctypes.c_uint()
    res = waveOutGetVolume(0, ctypes.byref(vol))
    return  vol.value/(MAXIMUM_VOLUME/100)+1

if __name__ == '__main__':
    #sv = SystemVolume()
    #最大音量
#    setVolume(100)
#    #中等音量
    SetVolume(100)
#    #静音
#    setVolume(0)
    print GetVolume()
