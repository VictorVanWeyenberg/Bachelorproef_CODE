package measure;

public class Tuple {

    private Number[] data;

    public Tuple(Number... data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder tupleWriter = new StringBuilder(data[0].toString());
        for (int i = 1; i < data.length; i++) {
            tupleWriter.append(", ").append(data[i]);
        }
        return tupleWriter.toString();
    }

}
