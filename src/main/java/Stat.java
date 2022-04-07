public class Stat {

    private String dataType;
    private String operation;
    private int numberElements;
    private long nanos;

    public Stat(String dataType, String operation, int numberElements, long nanos) {
        this.dataType = dataType;
        this.operation = operation;
        this.numberElements = numberElements;
        this.nanos = nanos;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getNumberElements() {
        return numberElements;
    }

    public void setNumberElements(int numberElements) {
        this.numberElements = numberElements;
    }

    public long getNanos() {
        return nanos;
    }

    public void setNanos(long nanos) {
        this.nanos = nanos;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "dataType='" + dataType + '\'' +
                ", operation='" + operation + '\'' +
                ", numberElements=" + numberElements +
                ", nanos=" + nanos +
                '}';
    }
}
