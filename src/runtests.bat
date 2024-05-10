@echo off
setlocal

set JAVA_PROGRAM=Model.Main
set TEST_DIR=tests

set /a success_count=0
set /a total_count=0

for /d %%f in (%TEST_DIR%\Teszt*) do (
    set test_case=%%~nf
    set init_file=%%f\map.txt
    set input_file=%%f\input.txt
    set output_file=%%f\output.txt
    set expected_file=%%f\expected.txt

    echo Running test case %test_case%
    java %JAVA_PROGRAM% %init_file% %input_file% %output_file%

    fc /B %output_file% %expected_file% > nul
    if %ERRORLEVEL% == 0 (
        echo Test case %test_case% passed
        set /a success_count+=1
    ) else (
        echo Test case %test_case% failed
    )
    set /a total_count+=1
)

echo %success_count% out of %total_count% tests passed