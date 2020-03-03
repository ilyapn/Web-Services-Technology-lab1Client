package wst;

import org.apache.commons.cli.CommandLine;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.generated.ObjectFactory;
import wst.generated.Person;

public class DBProvider {
    private final CRUDPersonExecutor findExecutor;
    private final CRUDPersonExecutor insertExecutor;
    private final CRUDPersonExecutor updateExecutor;
    private final CRUDPersonExecutor deleteExecutor;

    public DBProvider(CRUDPersonExecutor findExecutor,
                      CRUDPersonExecutor insertExecutor,
                      CRUDPersonExecutor updateExecutor,
                      CRUDPersonExecutor deleteExecutor) {
        this.findExecutor = findExecutor;
        this.insertExecutor = insertExecutor;
        this.updateExecutor = updateExecutor;
        this.deleteExecutor = deleteExecutor;
    }

    void handl(Person person, CommandLine parse) {
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
    }

    void find(Person person, CommandLine parse) {
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

    void insert(Person person, CommandLine parse) {
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

    void update(Person person, CommandLine parse) {
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

    void delete(Person person, CommandLine parse) {
        if (parse.hasOption("i"))
            person.setId(Integer.parseInt(parse.getOptionValue("i")));

        deleteExecutor.execute(person);
    }
}