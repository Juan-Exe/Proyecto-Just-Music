@echo off
set PROJ=c:\Users\juand\Documents\JUAN DIEGO\PROYECTOS\Just Music\Proyecto-Just-Music
set JFX=C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\jfxrt.jar
set CP=%PROJ%\build\classes;%PROJ%\dist\Proyecto Just Music.jar;%PROJ%\dist\lib\mysql-connector-j-8.3.0.jar;%JFX%
javac -encoding UTF-8 -cp "%CP%" -d "%PROJ%\build\classes" ^
  "%PROJ%\src\controller\viewExampleController.java" ^
  "%PROJ%\src\controller\viewExampleController_1.java" ^
  "%PROJ%\src\controller\Blurryface_Controller.java" ^
  "%PROJ%\src\controller\Californication_Controller.java" ^
  "%PROJ%\src\controller\Damn_Controller.java" ^
  "%PROJ%\src\controller\Days_Controller.java" ^
  "%PROJ%\src\controller\Deftones_Koi_No_Yokan_Controller.java" ^
  "%PROJ%\src\controller\Deftones_White_Pony_Controller.java" ^
  "%PROJ%\src\controller\L_L_A_Controller.java" ^
  "%PROJ%\src\controller\Lateralus_Controller.java" ^
  "%PROJ%\src\controller\Lisa_Page.java" ^
  "%PROJ%\src\controller\Mr_Morale_Controller.java" ^
  "%PROJ%\src\controller\Testing_Controller.java" ^
  "%PROJ%\src\controller\The_Getaway_Controller.java" ^
  "%PROJ%\src\controller\Thriller_Controller.java" ^
  "%PROJ%\src\controller\Trench_Controller.java" ^
  "%PROJ%\src\controller\WDTY_Controller_1.java" ^
  "%PROJ%\src\controller\WDTY_Controller_2.java"
echo Exit code: %ERRORLEVEL%
