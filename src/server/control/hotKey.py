#! /usr/bin/env python
#coding=utf-8

import SendKeys

class HotKey():

    def __init__(self):
        pass
        
    def ExecCommendKeys(self,keyStr):
        """
            ^%{F5} ctrl+alt+f5 QQ音乐暂停/播放
            ^%{LEFT} ctrl+alt+Left QQ音乐 上一曲
            ^%{RIGHT} ctrl+alt+Right QQ音乐 下一曲
        """
        try:
            SendKeys.SendKeys(keyStr)
            return True
        except TypeError:
            return False
        return False
