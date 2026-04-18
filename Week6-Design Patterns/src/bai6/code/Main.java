package bai6.code;

import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void print(String indent);
    String getPath();
    void setFolder (Folder folder);
}

class FileItem implements FileSystemItem {
    private String name;
    private int size;
    private Folder folder;

    public FileItem(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }

    @Override
    public String getPath() {
        if (folder == null) {
            return "/" + name;
        }
        return folder.getPath() + "/" + name;
    }

    @Override
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}

class Shortcut implements FileSystemItem {
    String name;
    FileSystemItem target;
    Folder folder;

    public Shortcut(String name, FileSystemItem target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }

    @Override
    public String getPath() {
        if (folder == null) {
            return "/" + name;
        }
        return folder.getPath() + "/" + name;
    }

    @Override
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> items;
    private Folder folder;

    public Folder(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        items.add(item);
        item.setFolder(this);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : items) {
            item.print(indent + "   ");
        }
    }

    @Override
    public String getPath() {
        if (folder == null) {
            return "/" + name;
        }
        return folder.getPath() + "/" + name;
    }

    @Override
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}

public class Main {
    public static void main(String[] args) {
        Folder folder = new Folder("root");

        Folder subfolder = new Folder("docs");
        FileItem file1 = new FileItem("readme.md", 4);
        folder.add(subfolder);
        folder.add(file1);

        FileItem file2 = new FileItem("a.txt", 12);
        FileItem file3 = new FileItem("b.txt", 8);
        Shortcut shortcut = new Shortcut("a-shortcut", file2);
        subfolder.add(file2);
        subfolder.add(file3);
        subfolder.add(shortcut);

        folder.print("");
    }
}
