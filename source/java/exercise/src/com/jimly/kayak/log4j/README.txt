#定义输出级别和输出平台
log4j.rootLogger=INFO,stdout,fileout

#设定stdout输出平台(stdout名称是自定义的)
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%-5p][%d{yyyy-MM-dd HH:mm:ss}][%l]:%m%n

#每天一个日志文件(fileout名称是自定义的)
log4j.appender.fileout=org.apache.log4j.DailyRollingFileAppender
log4j.appender.fileout.File=test.log
log4j.appender.fileout.layout=org.apache.log4j.PatternLayout
log4j.appender.fileout.layout.ConversionPattern=[%-5p][%d{yyyy-MM-dd HH:mm:ss}][%l]:%m%n

#对不同的package定义不同的输出级别
log4j.logger.com.daniel.test=DEBUG

分析：log4j.properies定义一般分3部分：
log4j.rootLogger（必须）、log4j.appender（必须）、log4j.logger(不必须)

1、log4j.rootLogger

这个配置是必须的,它的定义格式：

log4j.rootLogger = level  , appenderName, appenderName, …

lelve是定义的输出级别，低于该级别的将不会输出
主要级别有OFF、ALL、FATAL、ERROR、WARN、INFO、DEBUG或自定义级别
其中OFF设定的话将不输出任何信息
ALL设定的话将输出所有信息
另外5个的级别FATAL>ERROR>WARN>INFO>DEBUG
如果你的lenel设定为INFO,那么不能输出DEBUG信息

appenderName是指定日志信息输出到哪个地方,控制台,文件等等,可同时指定多个输出目的地.

2、log4j.appender

这个也是必须配置的，它是负责控制日志记录操作的输出。它的定义格式如下：

log4j.appender.appenderName=someAppender(选择一种输出平台)
[log4j.appender.appenderName.File=文件名](文件输出定义路径)
log4j.appender.appenderName.layout=输出布局
log4j.appender.appenderName.layout.ConversionPattern=输出格式




log4j.appender.appenderName指定输出appender，Log4J提供了一下几种appender：

a):org.apache.log4j.ConsoleAppender（控制台）
b):org.apache.log4j.FileAppender（文件）
c):org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
d):org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件,
	可通过log4j.appender.R.MaxFileSize=100KB设置文件大小,还可通过log4j.appender.R.MaxBackupIndex=1设置为保存一个备份文件）。
e):org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

log4j.appender.appenderName.layout指定日志信息的格式（布局）Layout,它负责格式化Appender的输出.Log4j提供的layout有以下几种：

org.apache.log4j.HTMLLayout（以HTML表格形式布局）
org.apache.log4j.PatternLayout（可以灵活地指定布局模式）
org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）。





log4j.appender.appenderName.layout.ConversionPattern格式化日志信息，Log4J采用类似C语言中的printf函数的打印格式格式化日志信息,打印参数如下：

%m 输出代码中指定的消息
%p 输出优先级,即DEBUG，INFO，WARN，ERROR，FATAL
%r 输出自应用启动到输出该log信息耗费的毫秒数
%c 输出所属的类目，通常就是所在类的全名
%t 输出产生该日志事件的线程名
%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，
	比如：%d{yyyy MMM dd HH:mm:ss,SSS}，输出类似：2012年06月24日 23：55：28，92
%l 输出日志事件的发生位置,包括类目名、发生的线程,以及在代码中的行数.



##############################################################################################################
##############################################################################################################
##############################################################################################################
一、log4j.properties 的使用详解

    1.输出级别的种类

        ERROR、WARN、INFO、DEBUG
        ERROR 为严重错误 主要是程序的错误
        WARN 为一般警告，比如session丢失
        INFO 为一般要显示的信息，比如登录登出
        DEBUG 为程序的调试信息

     

    2.配置日志信息输出目的地

        log4j.appender.appenderName = fully.qualified.name.of.appender.class
        1.org.apache.log4j.ConsoleAppender（控制台）
        2.org.apache.log4j.FileAppender（文件）
        3.org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
        4.org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）
        5.org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

     

    3.配置日志信息的格式

        log4j.appender.appenderName.layout = fully.qualified.name.of.layout.class
        1.org.apache.log4j.HTMLLayout（以HTML表格形式布局），
        2.org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
        3.org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），
        4.org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

     

    4.控制台选项

        Threshold=DEBUG:指定日志消息的输出最低层次。
        ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。
        Target=System.err：默认情况下是：System.out,指定输出控制台
        FileAppender 选项
        Threshold=DEBUF:指定日志消息的输出最低层次。
        ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。
        File=mylog.txt:指定消息输出到mylog.txt文件。
        Append=false:默认值是true,即将消息增加到指定文件中，false指将消息覆盖指定的文件内容。
        RollingFileAppender 选项
        Threshold=DEBUG:指定日志消息的输出最低层次。
        ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。
        File=mylog.txt:指定消息输出到mylog.txt文件。
        Append=false:默认值是true,即将消息增加到指定文件中，false指将消息覆盖指定的文件内容。
        MaxFileSize=100KB: 后缀可以是KB, MB 或者是 GB. 在日志文件到达该大小时，将会自动滚动，即将原来的内容移到mylog.log.1文件。
        MaxBackupIndex=2:指定可以产生的滚动文件的最大数。
        log4j.appender.A1.layout.ConversionPattern=%-4r %-5p %d{yyyy-MM-dd HH:mm:ssS} %c %m%n

     

    5.日志信息格式中几个符号所代表的含义：

         -X号: X信息输出时左对齐；
         %p: 输出日志信息优先级，即DEBUG，INFO，WARN，ERROR，FATAL,
         %d: 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921
         %r: 输出自应用启动到输出该log信息耗费的毫秒数
         %c: 输出日志信息所属的类目，通常就是所在类的全名
         %t: 输出产生该日志事件的线程名
         %l: 输出日志事件的发生位置，相当于%C.%M(%F:%L)的组合,包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main (TestLog4.java:10)
         %x: 输出和当前线程相关联的NDC(嵌套诊断环境),尤其用到像java servlets这样的多客户多线程的应用中。
         %%: 输出一个"%"字符
         %F: 输出日志消息产生时所在的文件名称
         %L: 输出代码中的行号
         %m: 输出代码中指定的消息,产生的日志具体信息
         %n: 输出一个回车换行符，Windows平台为"/r/n"，Unix平台为"/n"输出日志信息换行     

        可以在%与模式字符之间加上修饰符来控制其最小宽度、最大宽度、和文本的对齐方式。

        如：
	1)   %20c：指定输出category的名称，最小的宽度是20，如果category的名称小于20的话，默认的情况下右对齐。
	2)   %-20c:指定输出category的名称，最小的宽度是20，如果category的名称小于20的话，"-"号指定左对齐。
	3)   %.30c:指定输出category的名称，最大的宽度是30，如果category的名称大于30的话，就会将左边多出的字符截掉，但小于30的话也不会有空格。
	4)   %20.30c:如果category的名称小于20就补空格，并且右对齐，如果其名称长于30字符，就从左边较远输出的字符截掉。

