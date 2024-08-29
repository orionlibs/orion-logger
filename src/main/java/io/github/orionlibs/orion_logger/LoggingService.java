package io.github.orionlibs.orion_logger;

import io.github.orionlibs.orion_assert.ExceptionService;

public class LoggingService
{
    public static void logToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.log(message, parameters);
    }


    public static void logWarningToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.logWarning(message, parameters);
    }


    public static void logErrorToConsole(String message, Object... parameters)
    {
        ConsoleLoggerService.logError(message, parameters);
    }


    public static void logErrorToConsole(Throwable exception, String message, Object... parameters)
    {
        ConsoleLoggerService.logError(exception, message, parameters);
    }


    public static void logException(String errorMessage, Throwable exception, Object... parameters)
    {
        String errorMessageTemp = "";
        if(parameters != null && parameters.length > 0)
        {
            errorMessageTemp += String.format(errorMessage, parameters);
        }
        else
        {
            errorMessageTemp += errorMessage;
        }
        if(exception != null)
        {
            errorMessageTemp += ExceptionService.getAllErrorMessagesFromTheHierarchy(exception);
        }
        logErrorToConsole(errorMessageTemp);
    }
}