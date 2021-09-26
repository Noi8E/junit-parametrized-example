package git.noi8e.domain;

public enum ItemsForSearch {

    MONITOR("Монитор"),
    CELLPHONE("Телефон"),
    PASTA("Макароны"),
    LAPTOP("Ноутбук");

    private final String description;

    ItemsForSearch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
