# Microsoft Developer Studio Project File - Name="rtaudiodll" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Dynamic-Link Library" 0x0102

CFG=rtaudiodll - Win32 Debug
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "rtaudiodll.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "rtaudiodll.mak" CFG="rtaudiodll - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "rtaudiodll - Win32 Release" (based on "Win32 (x86) Dynamic-Link Library")
!MESSAGE "rtaudiodll - Win32 Debug" (based on "Win32 (x86) Dynamic-Link Library")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
CPP=cl.exe
MTL=midl.exe
RSC=rc.exe

!IF  "$(CFG)" == "rtaudiodll - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "Release"
# PROP BASE Intermediate_Dir "Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir "Release"
# PROP Intermediate_Dir "Release"
# PROP Ignore_Export_Lib 0
# PROP Target_Dir ""
# ADD BASE CPP /nologo /MT /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /D "_MBCS" /D "_USRDLL" /D "RTAUDIODLL_EXPORTS" /YX /FD /c
# ADD CPP /nologo /MT /W3 /GX /O2 /I "C:\j2sdk1.4.1_01\include" /I "C:\j2sdk1.4.1_01\include\win32" /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /D "_MBCS" /D "_USRDLL" /D "RTAUDIODL" /D "__WINDOWS_ASIO__" /D "L_EXPORTS" /YX /FD /c
# ADD BASE MTL /nologo /D "NDEBUG" /mktyplib203 /win32
# ADD MTL /nologo /D "NDEBUG" /mktyplib203 /win32
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /dll /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib dsound.lib /nologo /dll /machine:I386 /out:"Release/rtaudio.dll"
# Begin Special Build Tool
SOURCE="$(InputPath)"
PostBuild_Cmds=copy Release\rtaudio.dll ..\..\..\lib\asio
# End Special Build Tool

!ELSEIF  "$(CFG)" == "rtaudiodll - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "Debug"
# PROP BASE Intermediate_Dir "Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir "Debug"
# PROP Intermediate_Dir "Debug"
# PROP Target_Dir ""
# ADD BASE CPP /nologo /MTd /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /D "_MBCS" /D "_USRDLL" /D "RTAUDIODLL_EXPORTS" /YX /FD /GZ /c
# ADD CPP /nologo /MTd /W3 /Gm /GX /ZI /Od /I "C:\j2sdk1.4.1_01\include" /I "C:\j2sdk1.4.1_01\include\win32" /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /D "_MBCS" /D "_USRDLL" /D "RTAUDIODLL_EXPORTS _DEBUG" /D "_CONSOLE" /D "__WINDOWS_DS__" /D "__RTAUDIO_DEBUG__" /YX /FD /GZ /c
# ADD BASE MTL /nologo /D "_DEBUG" /mktyplib203 /win32
# ADD MTL /nologo /D "_DEBUG" /mktyplib203 /win32
# ADD BASE RSC /l 0x409 /d "_DEBUG"
# ADD RSC /l 0x409 /d "_DEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /dll /debug /machine:I386 /pdbtype:sept
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /dll /debug /machine:I386 /pdbtype:sept

!ENDIF 

# Begin Target

# Name "rtaudiodll - Win32 Release"
# Name "rtaudiodll - Win32 Debug"
# Begin Group "Source Files"

# PROP Default_Filter "cpp;c;cxx;rc;def;r;odl;idl;hpj;bat"
# Begin Source File

SOURCE=..\asio\asio.cpp
# End Source File
# Begin Source File

SOURCE=..\asio\asiodrivers.cpp
# End Source File
# Begin Source File

SOURCE=..\asio\asiolist.cpp
# End Source File
# Begin Source File

SOURCE=..\..\..\..\jass_render_RTAudioFullDuplexRtAudio.cpp
# End Source File
# Begin Source File

SOURCE=..\..\..\..\jass_render_RTAudioIn.cpp
# End Source File
# Begin Source File

SOURCE=..\..\..\..\jass_render_RTPlay.cpp
# End Source File
# Begin Source File

SOURCE="..\..\..\..\rtaudio-2.1.1\RtAudio.cpp"
# End Source File
# End Group
# Begin Group "Header Files"

# PROP Default_Filter "h;hpp;hxx;hm;inl"
# Begin Source File

SOURCE=..\asio\asio.h
# End Source File
# Begin Source File

SOURCE=..\asio\asiodrivers.h
# End Source File
# Begin Source File

SOURCE=..\asio\asiodrvr.h
# End Source File
# Begin Source File

SOURCE=..\asio\asiolist.h
# End Source File
# Begin Source File

SOURCE=..\asio\asiosys.h
# End Source File
# Begin Source File

SOURCE=..\asio\ginclude.h
# End Source File
# Begin Source File

SOURCE=..\asio\iasiodrv.h
# End Source File
# Begin Source File

SOURCE=..\..\..\..\include\jass_render_RTAudioFullDuplexRtAudio.h
# End Source File
# Begin Source File

SOURCE=..\..\..\..\include\jass_render_RTAudioIn.h
# End Source File
# Begin Source File

SOURCE=..\..\..\..\include\jass_render_RTPlay.h
# End Source File
# Begin Source File

SOURCE="..\..\..\..\rtaudio-2.1.1\RtAudio.h"
# End Source File
# End Group
# Begin Group "Resource Files"

# PROP Default_Filter "ico;cur;bmp;dlg;rc2;rct;bin;rgs;gif;jpg;jpeg;jpe"
# End Group
# End Target
# End Project