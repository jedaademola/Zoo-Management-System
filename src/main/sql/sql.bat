echo off
set VERSION=1_0_0
set NL=^& echo.
if not exist "src\main\sql\schema_migrations" mkdir src\main\sql\schema_migrations
set MIGRATION=src\main\sql\schema_migrations
type src\main\sql\%VERSION%\*.sql > %MIGRATION%\%VERSION%.sql%NL%%NL%
