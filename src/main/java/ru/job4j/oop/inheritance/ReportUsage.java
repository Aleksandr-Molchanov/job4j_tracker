package ru.job4j.oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        JSONReport report1 = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        String text1 = report1.generate("name", "body");
        System.out.println(text1);
    }
}