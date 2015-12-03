package com.moon.common.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * @param <T> 应用泛型，代表任意一个符合javabean风格的类
 * @author slzhang
 * @version v1.0
 */
public class ExportExcel<T> {

    private final static short fontHeightInPoints = 12;//字体大小
    private final static int columnWidth = 20;//列长
    private final static int totalSheetSize = 60000;//每个sheet页最大行数
    private final static int totalSheetNum = 5;//sheet页数量

    private final static String timePattern = "yyyy-MM-dd HH:mm:ss";
    private final static String datePattern = "yyyy-MM-dd";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
    private final static SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);

    public ExportExcel() {
    }

    /**
     * 标题头样式
     *
     * @param workbook
     * @return
     */
    public CellStyle createHeadStyle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints(fontHeightInPoints);//字体大小
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);// 加粗
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_LEFT);//居左
        style.setBorderBottom(CellStyle.BORDER_THIN);//边框
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);

        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//单元格颜色
        return style;
    }

    /**
     * 内容行格式
     *
     * @param workbook
     * @return
     */
    public CellStyle createCellStyle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints(fontHeightInPoints);//字体大小
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        return style;
    }

    private CellStyle createMoneyCellStyle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints(fontHeightInPoints);//字体大小
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        return style;
    }


    /**
     * 根据最长sheet页长转转换List
     *
     * @param bodyList
     * @return
     */
    private List<List<T>> changeMutiSheetList(List<T> bodyList) throws Exception {
        List<List<T>> mutiSheetList = new ArrayList<List<T>>();
        int totelRowNum = bodyList.size();//总行数
        int sheetNum;//sheet页数
        if (totelRowNum > totalSheetSize) {
            sheetNum = (int) Math.ceil(new Double(totelRowNum) / totalSheetSize);
            if (sheetNum > totalSheetNum) throw new Exception("the number of rows of excel is too much!");
            for (int i = 0; i < sheetNum; i++) {
                int fromIndex = i * totalSheetSize;
                int toIndex;
                if (i == sheetNum - 1) {
                    toIndex = totelRowNum;
                } else {
                    toIndex = (i + 1) * totalSheetSize;
                }
                List<T> sheetList = bodyList.subList(fromIndex, toIndex);
                mutiSheetList.add(sheetList);
            }
        } else {
            mutiSheetList.add(bodyList);
        }
        return mutiSheetList;
    }

    /**
     * 生成2003版excel
     *
     * @param fileName
     * @param headerList
     * @param bodyList
     * @return
     * @throws Exception
     */
    public HSSFWorkbook exportExcel(String fileName, List<ExcelHeader> headerList, List<T> bodyList) throws Exception {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();

        List<List<T>> mutiSheetList = changeMutiSheetList(bodyList);
        //生成sheet页
        for (int i = 0; i < mutiSheetList.size(); i++) {
            List<T> sheetList = mutiSheetList.get(i);
            String sheetName = "";
            if (mutiSheetList.size() == 1) {
                sheetName = fileName;
            } else {
                sheetName = fileName + (i + 1);
            }
            addSheet(sheetName, headerList, workbook, sheetList);
        }
        return workbook;
    }

    /**
     * 生成2003版excel-增加sheet页
     *
     * @param sheetName
     * @param headerList
     * @param workbook
     * @param bodyList
     * @throws Exception
     */
    private void addSheet(String sheetName, List<ExcelHeader> headerList, HSSFWorkbook workbook, List<T> bodyList) {

        CellStyle headStyle = createHeadStyle(workbook);
        CellStyle style = createCellStyle(workbook);
        CellStyle MoneyStyle = createMoneyCellStyle(workbook);

        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度
        sheet.setDefaultColumnWidth(columnWidth);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headerList.size(); i++) {

            ExcelHeader header = headerList.get(i);
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(header.getText());
            cell.setCellValue(text);
            cell.setCellStyle(headStyle);
            cell.setCellType(Cell.CELL_TYPE_STRING);

        }
        // 遍历集合数据，产生数据行
        int index = 0;
        for (T t : bodyList) {

            index++;
            row = sheet.createRow(index);
            Field[] fields = t.getClass().getDeclaredFields();

            //对每一行赋值
            for (int columId = 0; columId < headerList.size(); columId++) {
                ExcelHeader header = headerList.get(columId);

                String dataIndex = header.getDataIndex();
                Field field = null;
                try {
                    field = t.getClass().getDeclaredField(dataIndex);
                } catch (NoSuchFieldException e) {
                    //e.printStackTrace();
                    System.out.println(dataIndex + ":该字段不存在");
                    continue;
                }

                HSSFCell cell = row.createCell(columId);

                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);

                Class tCls = t.getClass();
                Method getMethod = null;
                Object value = null;
                try {
                    getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    value = getMethod.invoke(t, new Object[]{});

                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 判断值的类型后进行强制类型转换
                String textValue = "";
                if (value == null) {
                    textValue = "";

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);

                } else if (value instanceof Boolean) {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(Boolean.valueOf(textValue));
                    cell.setCellStyle(style);

                } else if (value instanceof Date) {
                    Date date = (Date) value;
                    SimpleDateFormat sdf = null;
                    if (("date").equals(header.getFormat())) {
                        sdf = dateFormat;
                    } else {
                        sdf = timeFormat;
                    }
                    textValue = sdf.format(date);

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);

                } else if (value instanceof BigDecimal) {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(Double.valueOf(textValue));
                    cell.setCellStyle(MoneyStyle);
                } else {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);
                }

            }
        }
    }

    /**
     * 生成2007版excel
     *
     * @param fileName
     * @param headerList
     * @param bodyList
     * @return
     * @throws Exception
     */
    public XSSFWorkbook exportExcel2007(String fileName, List<ExcelHeader> headerList, List<T> bodyList) throws Exception {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();

        List<List<T>> mutiSheetList = changeMutiSheetList(bodyList);
        //生成sheet页
        for (int i = 0; i < mutiSheetList.size(); i++) {
            List<T> sheetList = mutiSheetList.get(i);
            String sheetName = "";
            if (mutiSheetList.size() == 1) {
                sheetName = fileName;
            } else {
                sheetName = fileName + (i + 1);
            }
            addSheet2007(sheetName, headerList, workbook, sheetList);
        }
        return workbook;
    }

    /**
     * 生成2007版excel-增加sheet页
     *
     * @param sheetName
     * @param headerList
     * @param workbook
     * @param bodyList
     * @throws Exception
     */
    private void addSheet2007(String sheetName, List<ExcelHeader> headerList, XSSFWorkbook workbook, List<T> bodyList) {

        // 声明一个工作薄
        CellStyle headStyle = createHeadStyle(workbook);
        CellStyle style = createCellStyle(workbook);
        CellStyle MoneyStyle = createMoneyCellStyle(workbook);

        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度
        sheet.setDefaultColumnWidth(columnWidth);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headerList.size(); i++) {

            ExcelHeader header = headerList.get(i);
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(header.getText());
            cell.setCellValue(text);
            cell.setCellStyle(headStyle);
            cell.setCellType(Cell.CELL_TYPE_STRING);

        }
        // 遍历集合数据，产生数据行
        int index = 0;
        for (T t : bodyList) {

            index++;
            row = sheet.createRow(index);
            Field[] fields = t.getClass().getDeclaredFields();

            //对每一行赋值
            for (int columId = 0; columId < headerList.size(); columId++) {
                ExcelHeader header = headerList.get(columId);

                String dataIndex = header.getDataIndex();
                XSSFCell cell = row.createCell(columId);

                Field field = null;
                try {
                    field = t.getClass().getDeclaredField(dataIndex);
                } catch (NoSuchFieldException e) {
                    //e.printStackTrace();
                    System.out.println(dataIndex + ":该字段不存在");
                    continue;
                }
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);

                Class tCls = t.getClass();
                Method getMethod = null;
                Object value = null;
                try {
                    getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    value = getMethod.invoke(t, new Object[]{});

                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 判断值的类型后进行强制类型转换
                String textValue = "";
                if (value == null) {
                    textValue = "";

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);

                } else if (value instanceof Boolean) {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(Boolean.valueOf(textValue));
                    cell.setCellStyle(style);

                } else if (value instanceof Date) {
                    Date date = (Date) value;
                    SimpleDateFormat sdf = null;
                    if (("date").equals(header.getFormat())) {
                        sdf = dateFormat;
                    } else {
                        sdf = timeFormat;
                    }
                    textValue = sdf.format(date);

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);

                } else if (value instanceof BigDecimal) {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(Double.valueOf(textValue));
                    cell.setCellStyle(MoneyStyle);
                } else {
                    textValue = value.toString();

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(textValue);
                    cell.setCellStyle(style);
                }

            }
        }
    }


    public static void write(Workbook workbook, String fileName, HttpServletResponse response) throws IOException {

        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = formater.format(new Date());
        fileName = fileName + time + ".xlsx";
        fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

        response.setContentType("application/vnd.ms-excel");
        //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + fileName);

        workbook.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();

    }

    public static void main(String[] args) throws Exception {


        List<ExcelHeader> headerList = getExcelHeaders();
        List<User> bodyList = getUsers();
        ExportExcel excel = new ExportExcel();

        //HSSFWorkbook workbook = excel.exportExcel("aaaaa", headerList, bodyList);
        //OutputStream out = new FileOutputStream("/Users/lesline/work/a.xls");

        XSSFWorkbook workbook = excel.exportExcel2007("aaaaa", headerList, bodyList);
        OutputStream out = new FileOutputStream("/Users/lesline/work/a.xlsx");
        workbook.write(out);

    }

    private static List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name" + i);
            user.setEmail(i + "00000000@qq.com");
            list.add(user);
        }
        return list;
    }

    private static List<ExcelHeader> getExcelHeaders() {
        //申请日期，账户号、账户名、账户余额，当天申请提现次数，当天申请提现总额

        List<ExcelHeader> headerList = new ArrayList<ExcelHeader>();
        headerList.add(new ExcelHeader("name", "名字"));
        headerList.add(new ExcelHeader("email", "email"));

        return headerList;
    }
}  