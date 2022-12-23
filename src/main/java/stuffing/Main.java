package stuffing;

import jcli.annotations.CliCommand;
import jcli.annotations.CliOption;
import jcli.errors.InvalidCommandLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static jcli.CliParserBuilder.newCliParser;

public enum Main {;

    @CliCommand(name = "credentials", description = "A tool for testing credentials against multiple services")
    private static class CliArguments {
        @CliOption(name = 'c', longName = "config", defaultValue = "config.json", description = "The configuration file")
        public File config;

        @CliOption(name = 'l', longName = "list", defaultValue = "list.txt", description = "The credential list file")
        public File list;
    }

    public static void main(final String... args) throws InvalidCommandLine {
        final CliArguments arguments = newCliParser(CliArguments::new)
            .onErrorPrintHelpAndExit()
            .onHelpPrintHelpAndExit()
            .parse(args);

        execute(arguments);
    }

    private static void execute(final CliArguments arguments) throws IOException {
        if (arguments.list == null || !arguments.list.exists())
            throw new IOException("Missing credentials list. Please create ")
        Files.readString(arguments.list.toPath());
    }

}
