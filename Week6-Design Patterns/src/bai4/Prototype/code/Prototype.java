package bai4.Prototype.code;

import java.util.Arrays;
import java.util.List;

class ReportTemplate {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    public ReportTemplate (ReportTemplate other) {
        this.title = other.title;
        this.footer = other.footer;
        this.sections = other.sections;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<String> getSections() {
        return sections;
    }
    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    public void printInfo() {
        System.out.println("Report [Title: " + title + ", Footer: " + footer + ", Sections: " + sections + "]");
    }

}

public class Prototype {
    public void main(String[] args) {
        ReportTemplate reportTemplate1 = new ReportTemplate("Getting Started with Flutter", "© 2026 Developer Portal",
                Arrays.asList(
                "Environment Setup",
                "Building your first UI",
                "State Management",
                "Deployment"
        ));
        ReportTemplate reportTemplate2 = new ReportTemplate(reportTemplate1);
        ReportTemplate reportTemplate3 = new ReportTemplate(reportTemplate1);

        reportTemplate2.setTitle("Java Programming for Beginners");
        reportTemplate3.setTitle("Backend Roadmap 2026");

        reportTemplate1.printInfo();
        reportTemplate2.printInfo();
        reportTemplate3.printInfo();
    }
}
