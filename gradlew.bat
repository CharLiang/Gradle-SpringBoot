@if "%DEBUG" == "" @echo off
@rem ##########################################
@rem 
@rem    Gradle start up script for windows
@rem 
@rem ######################################

@rem set local scope for the variables with windows NT shell
if "%OS%" == "Windows_NT" setlocal


set DIRNAME =%~dp0
if "%DIRNAME" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem add default JVM options here. 
@rem You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script

set DEFAULT_JVM_OPTS =
set DEFAULT_JVM_OPTS=%DEFAULT_JVM_OPTS% - Djavax.net.ssl.trustStore = %APP_HOME%gradle\wf-bundle.jks
set DEFAULT_JVM_OPTS=%DEFAULT_JVM_OPTS% - Djavax.net.ssl.trustStorePassword=nopass


@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE = java.exe
%JAVA_EXE% - version >NUL 2&>1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in you PATH.
echo.
echo Please set the JAVA_HOME variable in your environmnet to match the location of your java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo. Please set the JAVA_HOME variable in your environment to match location of your java installation

goto fail


:init
@rem Get command-line arguments, handling windows variants
if not "%OS%" =="Windows_NT" goto win9xME_args

:win9xME_args
@rem slurp the command line arguments

set CMD_LINE_ARGS =
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem setup the command line

set CLASSPATH=%APP_HOME%\gradle/wrapper/gradle-wrapper.jar


@rem Execute Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle-appname=%APP_BASE_NAME%" -classpath "%ClassPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

:end
@rem End local scope for the variable with windows NT shell
if "ERRORLEVEL" =="0" goto mainEnd

:fail
rem Set variable GRADLE_EXIT_CONSOLE if you need the _script_ return code instead of _cmd.exe /c_ return code!
if not "" == "%GRADLE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%" == "Windows_NT" endlocal














