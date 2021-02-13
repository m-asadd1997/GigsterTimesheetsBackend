package com.example.excelProj.util;

import com.example.excelProj.Model.Timesheets;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.excelProj.Commons.Constants;


public final class TimesheetPdfUtil {


    public static File timesheetPdfFile(Timesheets timesheet, List<Timesheets> timesheetsList) {

        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(Constants.PROD_PDF_PATH+"Timesheet.pdf"));
//            PdfWriter.getInstance(document, new FileOutputStream("Timesheet.pdf"));
            Paragraph totalHours,employeeNameP,dateSubmittedP,timesheetId;
            String employeeName = "", dateSubmitted = "";
            Font font = FontFactory.getFont(FontFactory.HELVETICA,10, Font.BOLD, BaseColor.BLACK);
            Font cellData = FontFactory.getFont(FontFactory.HELVETICA,10);
            String imageFile ="/home_ssd/workboar/serverFiles/TimesheetLogoForPdf.jpeg";
//            String imageFile ="D:\\TimesheetProject\\TimesheetBackend\\src\\main\\resources\\TimesheetLogoForPdf.jpeg";
            Image image = Image.getInstance(imageFile);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleToFit(410f,200f);

            PdfPTable table = new PdfPTable(6);
            table.setWidths(new float[]{5f, 5f, 5f, 5f, 5f, 5f});


            table.addCell(setPdfCellStylesForHeaderRow("Day",25f,font));


            table.addCell(setPdfCellStylesForHeaderRow("Start Time",25f,font));


            table.addCell(setPdfCellStylesForHeaderRow("End Time",25f,font));


            table.addCell(setPdfCellStylesForHeaderRow("Overtime",25f,font));


            table.addCell(setPdfCellStylesForHeaderRow("Hours",25f,font));


            table.addCell(setPdfCellStylesForHeaderRow("Break Hours",25f,font));


            document.open();

            if (!timesheetsList.isEmpty()) {
                for (Timesheets timesheets : timesheetsList) {

                    employeeName = timesheets.getUser().getName();
                    dateSubmitted = timesheets.getDateSubmitted();
                    employeeNameP = new Paragraph("        Employee Name : " + employeeName,cellData);
                    dateSubmittedP= new Paragraph("        Date Submitted : " + dateSubmitted,cellData);
                    timesheetId   = new Paragraph("        Timesheet ID : " + timesheet.getId(),cellData);

                    employeeNameP.setAlignment(Element.ALIGN_TOP);
                    dateSubmittedP.setAlignment(Element.ALIGN_TOP);
                    timesheetId.setAlignment(Element.ALIGN_TOP);


                    document.add(dateSubmittedP);
                    document.add(employeeNameP);
                    document.add(timesheetId);
                    document.add(Chunk.NEWLINE);
                    document.add(Chunk.NEWLINE);
                    document.add(image);
                    document.add(Chunk.NEWLINE);


                    for (Map.Entry<String, TimesheetPdfData> dataEntry : populateData(timesheets).entrySet()) {
                        table.addCell(setPdfCellStyles(dataEntry.getKey().toUpperCase(), 25f,cellData));
                        table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getStartTime()),25f,cellData));
                        table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getEndTime()),25f,cellData));
                        table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getOvertime()),25f,cellData));
                        table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getHours()),25f,cellData));
                        table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getBreakTime()),25f,cellData));
                    }

                    totalHours = new Paragraph("\n" + "Total Hours : " + timesheets.getTotalHrs());
                    totalHours.setAlignment(Element.ALIGN_RIGHT);
                    document.add(table);
                    document.add(totalHours);
                    document.newPage();
                    table.flushContent();
                }
            } else {
                employeeName = timesheet.getUser().getName();
                dateSubmitted = timesheet.getDateSubmitted();
                employeeNameP = new Paragraph("        Employee Name : " + employeeName,cellData);
                dateSubmittedP= new Paragraph("        Date Submitted : " + dateSubmitted,cellData);
                timesheetId   = new Paragraph("        Timesheet ID : " + timesheet.getId(),cellData);

                employeeNameP.setAlignment(Element.ALIGN_TOP);
                dateSubmittedP.setAlignment(Element.ALIGN_TOP);
                timesheetId.setAlignment(Element.ALIGN_TOP);


                document.add(dateSubmittedP);
                document.add(employeeNameP);
                document.add(timesheetId);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(image);
                document.add(Chunk.NEWLINE);


                for (Map.Entry<String, TimesheetPdfData> dataEntry : populateData(timesheet).entrySet()) {
                    table.addCell(setPdfCellStyles(dataEntry.getKey().toUpperCase(), 25f,cellData));
                    table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getStartTime()),25f,cellData));
                    table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getEndTime()),25f,cellData));
                    table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getOvertime()),25f,cellData));
                    table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getHours()),25f,cellData));
                    table.addCell(setPdfCellStyles(checkTime(dataEntry.getValue().getBreakTime()),25f,cellData));
                }
                totalHours = new Paragraph("\n" + "Total Hours : " + timesheet.getTotalHrs(),cellData);
                totalHours.setAlignment(Element.ALIGN_RIGHT);
                document.add(table);
                document.add(totalHours);

            }

            document.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        File file = new File(Constants.PROD_PDF_PATH+"Timesheet.pdf");
//        File file = new File("Timesheet.pdf");
        file.setWritable(true);
        return file;
    }

    public static String checkZeros(String time) {
        String[] splittedTime = time.split(":", 2);
        for (int i = 0; i < splittedTime.length; i++) {
            if (splittedTime[i].length() == 1)
                splittedTime[i] = "0" + splittedTime[i];
        }

        return splittedTime[0] + ":" + splittedTime[1];

    }


    public static String checkTime(String time) {

        return time.equals("00:00") ? "-" : checkZeros(time);
    }

    public static PdfPCell setPdfCellStyles(String cellText,Float cellHeight,Font font){

        PdfPCell tableCell = new PdfPCell();
        Paragraph text = new Paragraph(cellText,font);
        text.setAlignment(Element.ALIGN_CENTER);
        tableCell.addElement(text);
        tableCell.setMinimumHeight(cellHeight);
        tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableCell.setVerticalAlignment(Element.ALIGN_CENTER);
        tableCell.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
        tableCell.setBorderColor(new BaseColor(191, 192, 193));
        tableCell.setBorderWidth(0.5f);
        return tableCell;
    }

    public static PdfPCell setPdfCellStylesForHeaderRow(String cellText,Float cellHeight,Font font){
        PdfPCell tableCell = new PdfPCell();
        Paragraph text = new Paragraph(cellText,font);
        text.setAlignment(Element.ALIGN_CENTER);
        tableCell.addElement(text);
        tableCell.setMinimumHeight(cellHeight);
        tableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableCell.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
        tableCell.setVerticalAlignment(Element.ALIGN_CENTER);
        tableCell.setBorderColor(new BaseColor(191, 192, 193));
        tableCell.setBorderWidthTop(1);
        tableCell.setBorderWidthBottom(2);
        return tableCell;
    }


    public static Map<String, TimesheetPdfData> populateData(Timesheets timesheets) {

        Map<String, TimesheetPdfData> daysData = new LinkedHashMap<>();


        daysData.put("Monday", new TimesheetPdfData("Monday", timesheets.getMondayStartTime(),
                timesheets.getMondayEndTime(), timesheets.getMonExtraHrs(), timesheets.getMonTotalHrs(), timesheets.getMonBreakTime()));

        daysData.put("Tuesday", new TimesheetPdfData("Tuesday", timesheets.getTuesdayStartTime(),
                timesheets.getTuesdayEndTime(), timesheets.getTueExtraHrs(), timesheets.getTueTotalHrs(), timesheets.getTueBreakTime()));

        daysData.put("Wednesday", new TimesheetPdfData("Wednesday", timesheets.getWednesdayStartTime(),
                timesheets.getWednesdayEndTime(), timesheets.getWedExtraHrs(), timesheets.getWedTotalHrs(), timesheets.getWedBreakTime()));

        daysData.put("Thursday", new TimesheetPdfData("Thursday", timesheets.getThursdayStartTime(),
                timesheets.getThursdayEndTime(), timesheets.getThursExtraHrs(), timesheets.getThursTotalHrs(), timesheets.getThursBreakTime()));

        daysData.put("Friday", new TimesheetPdfData("Friday", timesheets.getFridayStartTime(),
                timesheets.getFridayEndTime(), timesheets.getFriExtraHrs(), timesheets.getFriTotalHrs(), timesheets.getFriBreakTime()));

        daysData.put("Saturday", new TimesheetPdfData("Saturday", timesheets.getSaturdayStartTime(),
                timesheets.getSaturdayEndTime(), timesheets.getSaturdayEndTime(), timesheets.getSatTotalHrs(), timesheets.getSatBreakTime()));

        daysData.put("Sunday", new TimesheetPdfData("Sunday", timesheets.getSundayStartTime(),
                timesheets.getSundayEndTime(), timesheets.getSunExtraHrs(), timesheets.getSunTotalHrs(), timesheets.getSunBreakTime()));


        return daysData;

    }


}
