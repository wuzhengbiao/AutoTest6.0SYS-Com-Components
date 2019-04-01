@echo off
REM 将引号内部分改成你要查找的服务名称
tasklist|find /i "node.exe" >nul 2>nul
REM 如果服务存在，跳转至exist标签
if not errorlevel 1 (goto exist) else goto notexist

:exist
REM 这里写服务存在时用的代码
echo exist node.exe
goto :end2

:notexist
REM 这里写服务不存在时用的代码
echo macaca server already stop
goto :end1

:end1
exit
:end2
taskkill /f /im node.exe


