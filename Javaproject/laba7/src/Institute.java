import java.util.List;

public class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}
