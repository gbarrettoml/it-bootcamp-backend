package main.Documents;

public interface Print<T> {

    static void printing(Document obj) {
        System.out.println(obj.toString());
    };
}
