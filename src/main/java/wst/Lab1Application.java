package wst;

import org.apache.commons.cli.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wst.CRUDExecutors.DeleteExecutor;
import wst.CRUDExecutors.FindExecutor;
import wst.CRUDExecutors.InsertExecutor;
import wst.CRUDExecutors.UpdateExecutor;
import wst.generated.ObjectFactory;
import wst.generated.Person;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {
    private final FindExecutor findExecutor;
    private final InsertExecutor insertExecutor;
    private final UpdateExecutor updateExecutor;
    private final DeleteExecutor deleteExecutor;


    public Lab1Application(FindExecutor findExecutor,
                           InsertExecutor insertExecutor,
                           UpdateExecutor updateExecutor,
                           DeleteExecutor deleteExecutor) {
        this.findExecutor = findExecutor;
        this.insertExecutor = insertExecutor;
        this.updateExecutor = updateExecutor;
        this.deleteExecutor = deleteExecutor;
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

        switch (parse.getOptionValue("o")) {
            case "find":
                find(person, parse);
                break;
            case "insert":
                insert(person, parse);
                break;
            case "update":
                update(person, parse);
                break;
            case "delete":
                delete(person, parse);
                break;
            default:
                System.out.println("No such operation");
        }
        System.exit(0);
    }

    private void find(Person person, CommandLine parse) {
        if (parse.hasOption("i"))
            person.setId(Integer.parseInt(parse.getOptionValue("i")));
        if (parse.hasOption("n"))
            person.setName(parse.getOptionValue("n"));
        if (parse.hasOption("s"))
            person.setSurname(parse.getOptionValue("s"));
        if (parse.hasOption("p"))
            person.setPatronymic(parse.getOptionValue("p"));
        if (parse.hasOption("w"))
            person.setWeight(new ObjectFactory().createPersonWeight(Integer.parseInt(parse.getOptionValue("w"))));
        if (parse.hasOption("a"))
            person.setAge(new ObjectFactory().createPersonAge(Integer.parseInt(parse.getOptionValue("a"))));

        findExecutor.execute(person);
    }

    private void insert(Person person, CommandLine parse) {
        if (parse.hasOption("n"))
            person.setName(parse.getOptionValue("n"));
        if (parse.hasOption("s"))
            person.setSurname(parse.getOptionValue("s"));
        if (parse.hasOption("p"))
            person.setPatronymic(parse.getOptionValue("p"));
        if (parse.hasOption("w"))
            person.setWeight(new ObjectFactory().createPersonWeight(Integer.parseInt(parse.getOptionValue("w"))));
        if (parse.hasOption("a"))
            person.setAge(new ObjectFactory().createPersonAge(Integer.parseInt(parse.getOptionValue("a"))));

        insertExecutor.execute(person);
    }

    private void update(Person person, CommandLine parse) {
        if (parse.hasOption("i"))
            person.setId(Integer.parseInt(parse.getOptionValue("i")));
        if (parse.hasOption("n"))
            person.setName(parse.getOptionValue("n"));
        if (parse.hasOption("s"))
            person.setSurname(parse.getOptionValue("s"));
        if (parse.hasOption("p"))
            person.setPatronymic(parse.getOptionValue("p"));
        if (parse.hasOption("w"))
            person.setWeight(new ObjectFactory().createPersonWeight(Integer.parseInt(parse.getOptionValue("w"))));
        if (parse.hasOption("a"))
            person.setAge(new ObjectFactory().createPersonAge(Integer.parseInt(parse.getOptionValue("a"))));

        updateExecutor.execute(person);
    }

    private void delete(Person person, CommandLine parse) {
        if (parse.hasOption("i"))
            person.setId(Integer.parseInt(parse.getOptionValue("i")));

        deleteExecutor.execute(person);
    }

    private CommandLine parseCommand(Options options, CommandLineParser parser, String[] args) throws ParseException {
        CommandLine parse;
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
