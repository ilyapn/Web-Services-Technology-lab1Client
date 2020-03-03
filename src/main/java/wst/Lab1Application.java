package wst;

import org.apache.commons.cli.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wst.generated.Person;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {
    private final DBProviderSoap DBProviderSoap;
    private final DBProviderRest DBProviderRest;

    public Lab1Application(DBProviderSoap dbProviderSoap, DBProviderRest dbProviderRest) {
        DBProviderSoap = dbProviderSoap;
        DBProviderRest = dbProviderRest;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Override
    public void run(String... args) throws ParseException {
        Person person = new Person();
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        CommandLine parse;

        parse = parseCommand(options, parser, args);
        if (parse.hasOption("rest")) {
            DBProviderRest.handl(person, parse);
        } else {
            DBProviderSoap.handl(person, parse);
        }

        System.exit(0);
    }

    private CommandLine parseCommand(Options options, CommandLineParser parser, String[] args) throws ParseException {
        CommandLine parse;

        Option rest = new Option("rest", "rest");
        options.addOption(rest);

        Option operation = new Option("o", true, "operation");
        operation.setArgs(1);
        options.addOption(operation);

        Option id = new Option("i", true, "id");
        id.setArgs(1);
        options.addOption(id);

        Option name = new Option("n", true, "name");
        name.setArgs(1);
        options.addOption(name);

        Option surname = new Option("s", true, "surname");
        surname.setArgs(1);
        options.addOption(surname);

        Option patronymic = new Option("p", true, "patronymic");
        patronymic.setArgs(1);
        options.addOption(patronymic);

        Option weight = new Option("w", true, "weight");
        weight.setArgs(1);
        options.addOption(weight);

        Option age = new Option("a", true, "age");
        age.setArgs(1);
        options.addOption(age);

        parse = parser.parse(options, args);
        return parse;
    }

}
