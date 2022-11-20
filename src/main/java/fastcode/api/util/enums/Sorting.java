package fastcode.api.util.enums;

public enum Sorting {
    
    ASC("ASC"),
    DESC("DESC");
    
    
    private String sorter;
    
    private Sorting(String sorter)
    {
        this.sorter=sorter;
    }

    public String getSorter() {
        return sorter;
    }

    public void setSorter(String sorter) {
        this.sorter = sorter;
    }
    
    
}
// https://github.com/doktoric/spring-security-example/blob/master/src/main/java/com/acme/doktorics/domain/Sorting.java