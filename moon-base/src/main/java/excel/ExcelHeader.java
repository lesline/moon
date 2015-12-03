package excel;

/**
 * Created by lesline on 15/9/22.
 */
public class ExcelHeader {

    String text;
    String dataIndex;
    String hidden;
    String format;

    public ExcelHeader() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ExcelHeader{" +
                "text='" + text + '\'' +
                ", dataIndex='" + dataIndex + '\'' +
                ", hidden='" + hidden + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
