#! /usr/bin/env python
#coding=utf-8
import win32api, win32con,math
#获取当前鼠标位置
def GetCurrentPos():
    return win32api.GetCursorPos()

#获取屏幕分辨率
def GetScreenResolution(device=1):
    screeninfo = win32api.GetMonitorInfo(device)
    return screeninfo['Work'][2], screeninfo['Work'][3]

#左键点击
def LeftClick():
    x = GetCurrentPos()[0]
    y = GetCurrentPos()[1]
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)
    #win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP,0,0)

#右键点击
def RightClick():
    x = GetCurrentPos()[0]
    y = GetCurrentPos()[1]
    win32api.SetCursorPos((x,y))
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTDOWN, 0, 0)
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTUP,0,0)
    #win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTDOWN,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTUP,0,0)

#中键点击
def MiddleClick():
#    if button == 4:
#        win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL,0,0,win32con.WHEEL_DELTA)
#    elif button == 5:
    win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL,0,0,-win32con.WHEEL_DELTA)

#移动鼠标
def Move(x,y):


    res = GetScreenResolution()
    x = x*65535/res[0]
    y = y*65535/res[1]
    win32api.mouse_event(win32con.MOUSEEVENTF_MOVE|win32con.MOUSEEVENTF_ABSOLUTE, x,y)



#左移或者上移鼠标
def MoveLeftUp(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx-x,cy-y)

#左移或者下移鼠标
def MoveLeftDown(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx-x,cy+y)

#右移或者下移鼠标
def MoveRightDown(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx+x,cy+y)

#右移或者上移鼠标
def MoveRightUp(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx+x,cy-y)

#上
def MoveUp(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx,cy-y)

#下
def MoveDown(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx,cy+y)

#左
def MoveLeft(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx-x,cy)



#右
def MoveRight(x,y):
    #获取当前鼠标位置
    cx = GetCurrentPos()[0]
    cy = GetCurrentPos()[1]
    Move(cx+x,cy)

#移动鼠标
def MoveMouse(arrow,x,y):

    if arrow == 'LeftUp':
        MoveLeftUp(x,y)
    if arrow == 'LeftDown':
        MoveLeftDown(x,y)
    if arrow == 'RightUp':
        MoveRightUp(x,y)
    if arrow == 'RightDown':
        MoveRightDown(x,y)

    if arrow == 'Up':
        MoveUp(x,y)
    if arrow == 'Down':
        MoveDown(x,y)
    if arrow == 'Left':
        MoveLeft(x,y)
    if arrow == 'Right':
        MoveRight(x,y)
        
#点击鼠标
def ClickMouse(keyStr):
    if keyStr == 'Left':
        LeftClick()
    if keyStr == 'Middle':
        MiddleClick()
    if keyStr == 'Right':
        RightClick()
