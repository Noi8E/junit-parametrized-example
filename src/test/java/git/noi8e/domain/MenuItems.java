package git.noi8e.domain;

public enum MenuItems {

    EXPRESS("Экспресс"),
    ELECTRONICS("Электроника"),
    APPLIANCES("Бытовая техника"),
    COMPUTERS("Компьютеры"),
    FORKIDS("Детям"),
    REPAIR("Ремонт"),
    HOUSE("Дом"),
    FOODS("Продукты"),
    PHARMACY("Аптека");

    private String description;
    MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
