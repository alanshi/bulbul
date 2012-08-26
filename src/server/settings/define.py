#! /usr/bin/env python
#coding=utf-8
import sys
import win32gui

#句柄和程序内部名称映射字典
innerNameList ={
        u'千千静听':'ttplayer',
        u'酷狗':'kugou',
        u'酷我音乐盒':'kuwo',
        u'QQ音乐':'qqmusic',
        u'Foobar':'foobar',
        u'Winamp':'winamp',
        u'搜狗音乐盒':'sougou',
        u'Free Ape Player':'freeapeplay',
        u'Windows Media Player':'wmp',
        u'暴风影音':'baofeng',
        u'快播(QvodPlayer)':'qvod',
        u'RealPlayer':'realplay',
        u'PPTV':'PPTV',
        u'KMPlayer':'KMPlayer',
        u'超级解霸':'jieba',
        u'QQ影音':'qqmoive',
        u'风雷影音播放器':'fenglei',
        u'射手影音播放器':'splayer',
        u'风行':'fengxing',
}
#热键列表
hotKeySimpleList = {
                'ttplayer':
                 {
                           'FastForward':'^%{F8}',
                           'FallBack':'^%{F7}',
                           'NEXT':'^%{RIGHT}',
                           'Previous':'^%{LEFT}',
                           'PaudePlay':'^%{F5}',
                           'HideShow':'^%{W}',
                           'StandardScreen':'^%{F}',   
                 },
                'kugou':
                 {
                           'FastForward':'',
                           'FallBack':'',
                           'NEXT':'^%{LEFT}',
                           'Previous':'^%{RIGHT}',
                           'PaudePlay':'^%{F5}',
                           'HideShow':'',
                           'StandardScreen':'',   
                 },

                'kuwo':
                {
                          'FastForward':'',
                          'FallBack':'',
                          'NEXT':'^%{LEFT}',
                          'Previous':'^%{RIGHT}',
                          'PaudePlay':'^{F5}',
                          'HideShow':'^%{H}',
                          'StandardScreen':'',
                },

               'foobar':
                {
                          'FastForward':'^{1}',
                          'FallBack':'^{2}',
                          'NEXT':'^{.}',
                          'Previous':'^{,}',
                          'PaudePlay':'',
                          'HideShow':'',
                          'StandardScreen':'',
                },
                 'winamp':
                {
                          'FastForward':'^%{RIGHT}',
                          'FallBack':'^%{LEFT}',
                          'NEXT':'^%{PGUP}',
                          'Previous':'^%{PGDN}',
                          'PaudePlay':'^%{HOME}',
                          'HideShow':'',
                          'StandardScreen':'',   
                },
                 'sougou':
                {
                          'FastForward':'',
                          'FallBack':'',
                          'NEXT':'^%{RIGHT}',
                          'Previous':'^%{LEFT}',
                          'PaudePlay':'^%{P}',
                          'HideShow':'^%{H}',
                          'StandardScreen':'',   
                },
               'freeapeplay':
               {
                         'FastForward':'',
                         'FallBack':'',
                         'NEXT':'',
                         'Previous':'',
                         'PaudePlay':'^{P}',
                         'HideShow':'',
                         'StandardScreen':'',   
               },
                'wmp':
               {
                         'FastForward':'^+{F}',
                         'FallBack':'^+{B}',
                         'NEXT':'^{F}',
                         'Previous':'^{B}',
                         'PaudePlay':'^{P}',
                         'HideShow':'',
                         'StandardScreen':'%{ENTER}',   
               },
                'qvod':
             {
                       'FastForward':'+{RIGHT}',
                       'FallBack':'+{LEFT}',
                       'NEXT':'{PGDN}',
                       'Previous':'{PGUP}',
                       'PaudePlay':'{SPACE}',
                       'HideShow':'%{Q}',
                       'StandardScreen':'{F8}',
             },
              'realplay':
             {
                       'FastForward':'^%{F4}',
                       'FallBack':'^%{F3}',
                       'NEXT':'^{RIGHT}',
                       'Previous':'^{LEFT}',
                       'PaudePlay':'^{P}',
                       'HideShow':'',
                       'StandardScreen':'',
             },
                
                'qqmusic':
                {
                        'FastForward':'%{RIGHT}',
                        'FallBack':'%{LEFT}',
                        'Next':'^%{RIGHT}',
                        'Previous':'^%{LEFT}',
                        'PausePlay':'^%{F5}',
                        'HideShow':'^%(q)',
                        'StandardScreen':'',
                },

                'splayer':
                {
                    'FastForward':'%{RIGHT}',
                    'FallBack':'%{LEFT}',
                    'Next':'^{PGDN}',
                    'Previous':'^{PGUP}',
                    'PausePlay':'{SPACE}',
                    'HideShow':'',
                    'StandardScreen':'%{ENTER}',
                },
                'PPTV':
                {
                    'FastForward':'{RIGHT}',
                    'FallBack':'{LEFT}',
                    'Next':'{PGDN}',
                    'Previous':'{PGUP}',
                    'PausePlay':'^{p}',
                    'HideShow':'',
                    'StandardScreen':'%{ENTER}',
                },
                'fengxing':
                {
                    'FastForward':'{RIGHT}',
                    'FallBack':'{LEFT}',
                    'Next':'^{PGDN}',
                    'Previous':'^{PGUP}',
                    'PausePlay':'{SPACE}',
                    'HideShow':'',
                    'StandardScreen':'^{ENTER}',
                },
                'qqmoive':
                {
                    'FastForward':'^{RIGHT}',
                    'FallBack':'^{LEFT}',
                    'Next':'{PGDN}',
                    'Previous':'{PGUP}',
                    'PausePlay':'{SPACE}',
                    'HideShow':'',
                    'StandardScreen':'{ENTER}',
                },
                
                
                
}

#检查软件是否存在
def IsHaveSoft(windowsTitle):

    windowsTitle = unicode(windowsTitle,"gbk")
    try:
        return windowsTitle in list
    except Exception:
        return False
    return False

if __name__ == "__main__":
    pass