flowchart TD
    %% 設定節點樣式，讓圖表更漂亮
    classDef process fill:#e1f5fe,stroke:#01579b,stroke-width:2px;
    classDef decision fill:#fff9c4,stroke:#fbc02d,stroke-width:2px;
    classDef subproc fill:#e0f2f1,stroke:#00695c,stroke-width:2px,stroke-dasharray: 5 5;
    classDef io fill:#f3e5f5,stroke:#7b1fa2,stroke-width:2px;
    classDef terminator fill:#ffebee,stroke:#c62828,stroke-width:4px;

    Start((程式開始)):::terminator --> Init[初始化設定 boardSize, gameBoard, roundInd]:::process
    Init --> LoopStart((遊戲迴圈)):::decision

    LoopStart --> Print[[呼叫 printBoard]]:::subproc
    Print --> Input[/玩家輸入 Row, Col/]:::io

    Input --> CheckRange{座標是否在範圍內?}:::decision
    CheckRange -- No --> ErrorRange[顯示錯誤: Out of Range]:::io --> Input
    CheckRange -- Yes --> CheckEmpty{該格子是否為空?}:::decision

    CheckEmpty -- No --> ErrorOccupied[顯示錯誤: Already a piece]:::io --> Input
    CheckEmpty -- Yes --> Update[更新棋盤gameBoard/row/col = currPlayer]:::process

    Update --> CheckWin[[呼叫 checkWinner]]:::subproc
    
    %% checkWinner 內部的邏輯簡化呈現
    CheckWin --> WinDecision{是否連線成功?}:::decision
    WinDecision -- Yes --> AnnounceWin[顯示贏家]:::io --> EndGame((結束程式)):::terminator
    WinDecision -- No --> IncRound[回合數 roundInd + 1]:::process

    IncRound --> CheckTie{檢查平手 roundInd == Size*Size?}:::decision

    CheckTie -- Yes --> AnnounceTie[顯示平手 TIE]:::io --> EndGame
    CheckTie -- No --> Switch[切換玩家 Switch Player]:::process
    Switch --> LoopStart