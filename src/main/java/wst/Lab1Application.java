package wst;

import org.apache.commons.cli.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wst.generated.Field;
import wst.generated.ObjectFactory;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {
    private final FindPrinter findPrinter;

    public Lab1Application(FindPrinter findPrinter) {
        this.findPrinter = findPrinter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Override
    public void run(String... args) throws ParseException {
        Field field = new Field();
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        CommandLine parse;

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

        if (parse.hasOption("n"))
            field.setName(parse.getOptionValue("n"));
        if (parse.hasOption("s"))
            field.setSurname(parse.getOptionValue("s"));
        if (parse.hasOption("p"))
            field.setPatronymic(parse.getOptionValue("p"));
        if (parse.hasOption("w"))
            field.setWeight(new ObjectFactory().createFieldWeight(Integer.parseInt(parse.getOptionValue("w"))));
        if (parse.hasOption("a"))
            field.setWeight(new ObjectFactory().createFieldAge(Integer.parseInt(parse.getOptionValue("a"))));

        findPrinter.print(field);
    }

}
