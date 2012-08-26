#! /usr/bin/env python
#coding=utf-8

import os
import sys


import util
#添加当前文件的父目录(项目根目录)到系统搜索路径
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from settings import define

#媒体控制基类
class BaseControl:


    #初始化
    def __init__(self):
        pass

    def __del__(self):
        pass

if __name__ == "__main__":
    bc = BaseControl()
