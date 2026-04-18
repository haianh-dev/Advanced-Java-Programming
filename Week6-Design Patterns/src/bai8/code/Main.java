package bai8.code;

class Report {
    String title;
    String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

interface ReportFormatter {
    String format(Report data);
}

class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "{\n  \"title\": \"" + data.getTitle() + "\",\n  \"content\": \"" + data.getContent() + "\"\n}";
    }
}

class XmlFormatter  implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "<report>\n  <title>" + data.getTitle() + "</title>\n  <content>" + data.getContent() + "</content>\n</report>";
    }
}

class ReportService {
    ReportFormatter formatter;
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        if (formatter == null) {
            return "Error: No formatter provided!";
        }
        return formatter.format(data);
    }
}

public class Main {
    public static void main(String[] args) {
        Report report = new Report("Bao cao thang 4", "Doanh thu dat 1 ty VND");

        ReportService service1 = new ReportService(new JsonFormatter());
        String jsonOutput = service1.export(report);
        System.out.println("Dinh dang JSON: ");
        System.out.println(jsonOutput);

        ReportService service2 = new ReportService(new XmlFormatter());
        String xmlOutput = service2.export(report);
        System.out.println("Dinh dang XML: ");
        System.out.println(xmlOutput);
    }
}
