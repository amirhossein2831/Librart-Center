import java.util.HashSet;

public class Category {
    private String id;
    private String name;

    private HashSet<String> stuffId;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
        stuffId = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getStuffId() {
        return stuffId;
    }
}
