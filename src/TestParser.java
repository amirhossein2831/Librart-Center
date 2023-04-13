public class TestParser {
    private Center center;

    public TestParser() {
        center = new Center();
    }

    public void parseCommand(String input) {
        String[] command = input.split("#");
        String[] args = new String[]{};
        if (command.length > 1) {
            args = command[1].split("\\|");
        }
        switch (command[0]) {
            case "add-library":
                addLibrary(args[0],args[1],args[2],Integer.parseInt(args[3]),args[4]);
                break;
        }
    }
    public void addLibrary(String id, String name, String year, int numSeat, String address) {
        Library library = new Library(id, name, year, numSeat, address);
        System.out.println(center.addLibrary(library));
    }
}
