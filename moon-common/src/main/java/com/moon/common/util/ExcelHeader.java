package com.moon.common.util;
/**
 * Created by lesline on 15/9/22.
 */
public class ExcelHeader {

    private String dataIndex;
    private String text;
    private String format = "time";
    private String hidden;

    public ExcelHeader() {
    }

    public ExcelHeader(String dataIndex, String text) {
        this.dataIndex = dataIndex;
        this.text = text;
    }

    public ExcelHeader(String dataIndex, String text, String format) {
        this.dataIndex = dataIndex;
        this.text = text;
        this.format = format;
    }

    public ExcelHeader(String dataIndex, String text, String format, String hidden) {
        this.dataIndex = dataIndex;
        this.text = text;
        this.format = format;
        this.hidden = hidden;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
                "dataIndex='" + dataIndex + '\'' +
                ", text='" + text + '\'' +
                ", format='" + format + '\'' +
                ", hidden='" + hidden + '\'' +
                '}';
    }
}
