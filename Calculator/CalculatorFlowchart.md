flowchart TD
    %% 設定樣式
    classDef process fill:#e3f2fd,stroke:#1565c0,stroke-width:2px;
    classDef decision fill:#fff9c4,stroke:#fbc02d,stroke-width:2px;
    classDef io fill:#f3e5f5,stroke:#7b1fa2,stroke-width:2px;
    classDef terminator fill:#ffebee,stroke:#c62828,stroke-width:4px;
    classDef subproc fill:#e0f2f1,stroke:#00695c,stroke-width:2px,stroke-dasharray: 5 5;

    Start((程式開始)):::terminator --> Init[初始化變數]:::process
    
    %% 改用 <br/> 來換行
    Init --> MainLoop{"Main Loop<br/>(contiLoop)"}:::decision

    %% --- 第一關：輸入數字 1 ---
    MainLoop -- True --> Input1[/輸入 Num1/]:::io
    Input1 --> CheckNum1{"hasNextDouble?"}:::decision
    CheckNum1 -- No --> Err1["顯示錯誤 & <br/>scanner.next 清除緩衝"]:::process --> Input1
    CheckNum1 -- Yes --> SaveNum1[讀取 Num1]:::process

    %% --- 第二關：輸入符號 ---
    SaveNum1 --> InputOp[/輸入運算符號/]:::io
    InputOp --> CheckOp{"符號是否為<br/>+ - * / % ?"}:::decision
    CheckOp -- No --> ErrOp[顯示錯誤]:::process --> InputOp
    CheckOp -- Yes --> SaveOp[讀取 Op]:::process

    %% --- 第三關：輸入數字 2 (含分母為0檢查) ---
    SaveOp --> Input2[/輸入 Num2/]:::io
    Input2 --> CheckNum2{"hasNextDouble?"}:::decision
    CheckNum2 -- No --> Err2["顯示錯誤 & <br/>scanner.next 清除緩衝"]:::process --> Input2
    
    CheckNum2 -- Yes --> CheckZero{"Op 是 / 或 %<br/>且 Num2 == 0 ?"}:::decision
    CheckZero -- Yes --> ErrZero["顯示錯誤:<br/>分母不能為 0"]:::process --> Input2
    CheckZero -- No --> SaveNum2[讀取 Num2]:::process

    %% --- 計算與結果 ---
    SaveNum2 --> CallCalc[[呼叫 calC 方法]]:::subproc
    CallCalc --> ShowResult[/顯示運算結果/]:::io

    %% --- 第四關：是否繼續 (y/n) ---
    ShowResult --> AskCont[/"詢問: Continue y/n ?"/]:::io
    AskCont --> ValidCont{"輸入是否為<br/>y 或 n ?"}:::decision
    
    ValidCont -- No --> ErrCont[顯示錯誤]:::process --> AskCont
    ValidCont -- Yes --> IsYes{"輸入是 y 嗎?"}:::decision

    IsYes -- Yes --> MainLoop
    IsYes -- No --> End((程式結束)):::terminator