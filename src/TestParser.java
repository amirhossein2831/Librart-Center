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
            case "add-category":
                addCategory(args[0], args[1]);
                break;
            case "add-book":
                addBook(args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]), args[6], args[7]);
                break;
        }
    }
    public void addLibrary(String id, String name, String year, int numSeat, String address) {
        Library library = new Library(id, name, year, numSeat, address);
        System.out.println(center.addLibrary(library));
    }

    public void addCategory(String id, String name) {
        Category category = new Category((id), name);
        System.out.println(center.addCategory(category));
    }

    public void addBook(String id, String name, String authorName, String publisher, String year, int numBook, String categoryId, String libraryId) {
        Book book = new Book(id, name, authorName, publisher, year, numBook, categoryId, libraryId);
        System.out.println(center.addBook(book));

    }
}
