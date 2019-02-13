package com.transerainc.adaws.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.FileAppender;

/**
 * Contains utility methods to interact with the logback during runtime.
 * Ref: http://hillert.blogspot.com/2008/11/configure-logback-from-your-web.html
 * http://logback.qos.ch/apidocs/
 *
 * @author Gunnar Hillert
 * @version $Id: LoggingUtil.java,v 1.1.2.1 2017/11/15 21:40:53 tri Exp $
 */
public class LoggingUtil {

    /**
     * Retrieve all configured logback loggers.
     *
     * @param showAll
     *            If set return ALL loggers, not only the configured ones.
     * @return List of Loggers
     */
    public static List<Logger> getLoggers(final boolean showAll) {

        final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        final List<Logger> loggers = new ArrayList<>();

        for (final Logger log : lc.getLoggerList()) {
            if (showAll == false) {
                if (log.getLevel() != null || LoggingUtil.hasAppenders(log)) {
                    loggers.add(log);
                }
            } else {
                loggers.add(log);
            }
        }

        return loggers;
    }

    /**
     * Get a single logger.
     *
     * @return Logger
     */
    public static Logger getLogger(final String loggerName) {
        final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        return lc.getLogger(loggerName);
    }

    /**
     * Test whether the provided logger has appenders.
     *
     * @param logger
     *            The logger to test
     * @return true if the logger has appenders.
     */
    public static boolean hasAppenders(final Logger logger) {
        final Iterator<Appender<ILoggingEvent>> it = logger.iteratorForAppenders();
        return it.hasNext();
    }

    /**
     * Get the logfile information for the root logger.
     *
     * @return List of LogFileInfo obejcts
     */
    public static List<LogFileInfo> getLogFiles() {
        final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        final List<LogFileInfo> logFileInfos = new ArrayList<>();
        final Logger logger = lc.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        final Iterator<Appender<ILoggingEvent>> it = logger.iteratorForAppenders();
        while (it.hasNext()) {
            final Appender<ILoggingEvent> appender = it.next();
            if (appender instanceof FileAppender) {
                final FileAppender<ILoggingEvent> fileAppender = (FileAppender<ILoggingEvent>) appender;
                final File logFile = new File(fileAppender.getFile());
                final LogFileInfo logFileInfo = new LogFileInfo();
                logFileInfo.setFileName(logFile.getName());
                logFileInfo.setFileLastChanged(new Date(logFile.lastModified()));
                logFileInfo.setFileSize(logFile.length());
                logFileInfos.add(logFileInfo);
            }
        }
        return logFileInfos;
    }

    /**
     * Get the log file.
     *
     * @param logFileName
     *            The name of the log file
     * @return The actual file
     */
    public static File getLogFile(final String logFileName) {
        if (logFileName == null) { throw new IllegalArgumentException("logFileName cannot be null."); }
        final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        final Logger logger = lc.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        final Iterator<Appender<ILoggingEvent>> it = logger.iteratorForAppenders();
        while (it.hasNext()) {
            final Appender<ILoggingEvent> appender = it.next();
            if (appender instanceof FileAppender) {
                final FileAppender<ILoggingEvent> fileAppender = (FileAppender<ILoggingEvent>) appender;
                final File logFile = new File(fileAppender.getFile());
                if (logFile.getName().equalsIgnoreCase(logFileName)) { return logFile; }
            }
        }
        return null;
    }

}
