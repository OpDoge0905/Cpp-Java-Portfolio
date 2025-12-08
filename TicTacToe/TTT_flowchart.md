flowchart TD
    Start((開始)) --> Init[初始化變數與棋盤]
    Init --> Loop{遊戲迴圈}
    
    Loop --> CallPrint[[呼叫 printBoard]]
    CallPrint --> Input[/玩家輸入座標/]
    Input --> Valid{輸入合法?}
    
    Valid -- No --> Input
    Valid -- Yes --> Update[更新棋盤]
    
    Update --> CheckWin{有人贏了嗎?}
    
    CheckWin -- Yes --> EndGame((結束遊戲/宣佈贏家))
    CheckWin -- No --> Switch[切換玩家]
    Switch --> Loop