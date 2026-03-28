@echo off
set PROJ=c:\Users\juand\Documents\JUAN DIEGO\PROYECTOS\Just Music\Proyecto-Just-Music
set JFX=C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\jfxrt.jar
set CP=%PROJ%\build\classes;%PROJ%\dist\Proyecto Just Music.jar;%PROJ%\dist\lib\mysql-connector-j-8.3.0.jar;%JFX%
set SRC=%PROJ%\src\controller

javac -encoding UTF-8 -cp "%CP%" -d "%PROJ%\build\classes" ^
  "%SRC%\viewExampleController.java" ^
  "%SRC%\viewExampleController_1.java" ^
  "%SRC%\Blurryface_Controller.java" ^
  "%SRC%\Californication_Controller.java" ^
  "%SRC%\Damn_Controller.java" ^
  "%SRC%\Days_Controller.java" ^
  "%SRC%\Deftones_Koi_No_Yokan_Controller.java" ^
  "%SRC%\Deftones_White_Pony_Controller.java" ^
  "%SRC%\L_L_A_Controller.java" ^
  "%SRC%\Lateralus_Controller.java" ^
  "%SRC%\Lisa_Page.java" ^
  "%SRC%\Mr_Morale_Controller.java" ^
  "%SRC%\Testing_Controller.java" ^
  "%SRC%\The_Getaway_Controller.java" ^
  "%SRC%\Thriller_Controller.java" ^
  "%SRC%\Trench_Controller.java" ^
  "%SRC%\WDTY_Controller_1.java" ^
  "%SRC%\WDTY_Controller_2.java"

if %ERRORLEVEL% == 0 (echo COMPILACION EXITOSA) else (echo ERRORES - codigo: %ERRORLEVEL%)
