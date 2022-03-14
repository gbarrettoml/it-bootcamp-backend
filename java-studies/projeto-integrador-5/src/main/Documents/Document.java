package main.Documents;

public abstract class Document implements Print {

    @Override
    public void printing() {
        System.out.println(this);
    }
}
