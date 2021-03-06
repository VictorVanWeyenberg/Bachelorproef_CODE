JASS Manual

Contents:

0) Legal ramblings:
1) Installation:
2) TUTORIAL:
3) A moment of silence
4) Compiling a new release of jass:
5) Platform specific things: low latency IO
6) Misc. issues
7) Credits
8) bUG
S

Contact:

Kees van den Doel (kvdoel@cs.ubc.ca)
Department of Computer Science
University of British Columbia
2366 Main Mall
Vancouver, B.C. V6T 1Z4
CANADA
Web: http://www.cs.ubc.ca/~kvdoel

-----------------------------------------------------------------------

0) Legal ramblings:

Definition: Everything contained in jass.zip  will be referred to as the
"JASS SDK"; that's everything you downloaded. (Translation into legalese
available on request.)

The JASS SDK (except stuff specified below) is owned by:

University of British Columbia
Dept. of Computer Science
2366 Main Mall
Vancouver, B.C. V6T 1Z4
CANADA
Phone: (604) 913-0935
FAX: (604) 822-5485

Copyright is held by:

(C) Kees van den Doel, kvdoel@cs.ubc.ca, http://www.cs.ubc.ca/~kvdoel

This software can  be used freely for non-profit  purposes.  If you want
to make money  off it, contact us, we want some  too.  It is distributed
as-is and is not guaranteed to  work as advertized.  Bug reports will be
appreciated but we  make no guarantee that we will  fix anything or even
answer your email. In practice we probably will, though.

The  code in  the  platform  directory contains  native  code to  bypass
JavaSound  in  order to  get  better latency.  

Feel free to modify  the JASS SDK as you see fit  for your own purposes,
but you  are not  allowed to distribute  such modifications  and pretend
they are not yours. Not that we can imagine anyone wanting to do that...
If you do  improve the JASS SDK and want to  distribute your changes you
have to give it away for free.

If you make something cool we'd like to hear about it.

Enough of this.

1) Installation:

System requirements: Java 1.5 Cygwin UNIX utils on MS Windows, or UNIX.

Unzip  what you  downloaded, which  will create  a directory  "jass". In
there you find:

doc/             javadoc generated doumentation
examples/        sample code using jass
jass/            compiled source of jass packages
platform/        stuff that is platform specific (native implementations)
info.txt         version info
makefile         makefile
jass.pdf         overview of jass
readme.txt       this


2) TUTORIAL:

The example  directory contains subdirs  with examples.  There  are Java
stand-alone  applications and  Java Applets  which can  be run  with the
appletviewer.exe or in a Java  2 enabled browser. Directory names of the
form *_noApplet do not contain an Applet version of the demo, but just a
Java stand-alone program.

A a tutorial, let's run the examples/bell demo...

Open a shell, and cd to examples/bell, then enter:

    javac -classpath ".:../../" *.java

to compile and run it with

    java -classpath ".:../../" Bell ../data/bell4.sy

(On Windows  you may need  to substitued ';'  for ':', and  flip slashes
around.)  This should  open a window with sliders and  you should hear a
bell. If not, something is wrong with your Java setup.

Now let's run the Applet version of this:
   
    appletviewer bell.html

Note that  the html  loads jass.jar from  a directory ../jar/ and a data file
from ../data/bell4.sy.   If this
does not work  (I get a security violation  on Linux), try changing
the line

ARCHIVE = ../jar/jass.jar

from bell_av.html, to 

ARCHIVE = jass.jar

and make a copy of ../jar/jass.jar in the current (bell) directory. Also
copy ../data/bell4.sy  into the  current directory and  change bell.html
accordingly.

3)

4) Compiling a new release of jass:

The jass packages are in jass-sdk/jass/. The makefile in jass-sdk
provides ways to:

a) make all
Will compile everything including all examples
b) make jar
Will make the examples/jar/jass.jar file with the jass packages.
c) make rel
Makes a  release just like  the one you  just downloaded, but  better of
course!  This also  creates a  website with  demos and  download  of the
release. The generated  website is jass_www, which contains everything 
including jass.zip, a downloadable release.
d) make backup
Zip up everything.
e) make docs
Generate the doc/ directory
f) make clean
g) make native 
makes native header files in platform/include

The webpage generated  by "make rel" (in jass_www)  contains a frontpage
which  is  copied  from  examples/jass.html,  which you  can  change  if
desired.  Note that  this is  not  a complete  html, but  a header  with
version information will be added during "make".  The version of JASS is
defined at the top of the makefile.


5) Platform specific things:

NB: With Java  5 the javasound implementations finally  made most of the
following obsolete. One day I will do a spring cleaning and remove it...

There  are a  few classes  which  have (optional)  native methods.  Most
important is nativeaudio IO which allows synthesis with low latency.

Because of the terrible latency  of JavaSound some platforms on you have
the  option to  bypass JavaSound  and use  native interfaces.  There are
written using  RtAudio, a C++  audio interface written by  Gary Scavone,
and binaries  exists for Windows (ASIO  and DirectX) and  LINUX (OSS and
ALSA) machine.  See the platform/ directory. To use native audio IO call
the  appropriate constructor  in  AudioIn, and/or  call the  appropriate
method in SourcePlayer.  It will  then search for shared libraries (.dll
on windows, .so on LINUX). You have to make sure the java code finds the
one you want (e.g.  OSS or ALSA  on LINUX or ASIO based or DirectX based
on windows). They are in:

platform/linux/lib/oss/
platform/linux/lib/alsa/
platform/windows/lib/asio/
platform/windows/lib/directsound/

In addition there is a native  implementation based on ASIO which uses a
callback mechanism. To use this you will have to make a special API call
on SourcePlayer and/or AudioIn.


EXAMPLES:

example/mike/MikeIn.java  is a  full duplex  demo (exciting  a resonance
model with audio-in) which you can try with JavaSound, callback ASIO, or
RtAudio (ASio or DX based).

example/latencyOuTest_noApplet
allows you to test synthesis latency using native or pure Java output
by clicking a button to trigger sound.

Additional native methods:

jass/render/MicroTime implements an accurate timer. Libraries in

platform/linux/lib/
platform/windows/lib/

6) Misc. issues:

a) On Linux  using the Sun JavaSound implementation  you can't get audio
input and output (full duplex).  (Sun's decision, may change in the near
future.) You  can get the Tritonus Esd  Mixer and use that  and get full
duplex.

b) Some of the examples have makefiles. Some work on Linux, some work on
MSWindows.   Usually  all  you have  to  do  to  make  them work  is  to
interchange ;  and :. Some of  them make use of  an environment variable
CPSEP which I set to ; or : as appropriate.

c) 

d) The makefile assumes you have the Cygwin UNIX utils (or other similar
stuff) installed  on your  Windows machine, with  all the UNIX  tools, a
real    shell,   etc.     If   you    don't,   get    it    from   here:
http://sources.redhat.com/cygwin

e) Bizarre  BUG in Netscape: When  you include source code  on a webpage
with an applet and you have something like

<pre>
        for(int i=0;i<nsamples;i++) {
            cosForce[i] = (float)(.5*(1.-Math.cos(2*Math.PI*(i+1)/(1+nsamples))));
        }
</pre>

you may  get a nasty  surprize in  Netscape 6: It  locks and goes  in an
infinite  loop grabbing  all CPU  cycles.  The  culprit is  the 
"for(int i=0;i<nsamples;i++)"   
string:    replace   it   by    
"for(inti=0;i<nsamples;i++)" 
and you're OK.

f)  Only one  HRTF set  is  included with  JASS. More  are available  on
request. Note that the HRTF code is not very well tested.

7) Credits:

Thanks to:

Richard Corbett (rcorbett@cs.ubc.ca) for implementing ASIO rendering.

Reynald    Hoskinson   (reynald@cs.ubc.ca)    for    implementing   HRTF
spatialization.

Gary Scavone  for his  RtAudio class (  Copyright (c) 2001-2002  Gary P.
Scavone  http://ccrma-www.stanford.edu/~gary/rtaudio) which  is included
with the JASS distribution.

Jef Poskanzer for his FFT code {

/* libfft.c - fast Fourier transform library
**
** Copyright (C) 1989 by Jef Poskanzer.
**
** Permission to use, copy, modify, and distribute this software and its
** documentation for any purpose and without fee is hereby granted, provided
** that the above copyright notice appear in all copies and that both that
** copyright notice and this permission notice appear in supporting
** documentation.  This software is provided "as is" without express or
** implied warranty.
*/

}

8) BUGS

The java.utils.Color  class crashes javadocs. 

When  using native  IO here  are  problems with  shutdown, which  appear
harmless except for the  generation of logfiles and/or coredumps. Except
under windows the "operating system"  may also become even more unstable
than it already is.

If you  try to  set the  buffers too small  using ASIO  the OS  (or what
passes for one) crashes and dies.

Under Netscape 7.1/Windows the Applets loading .sy files don't
work. In jass/generators/ModalModel.java, method readModes() a string
contains some sputious Netscape7.1  generated JavaScript code instead
of the numbers it should have.

-----------------------------------------------------------------------


