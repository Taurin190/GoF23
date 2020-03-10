public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        rootDir.accept(new ListVisitor());

        System.out.println("");
        System.out.println("Making user entries...");
        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tom = new Directory("tom");
        usrDir.add(yuki);
        usrDir.add(hanako);
        usrDir.add(tom);
        yuki.add(new File("diary.html", 100));
        yuki.add((new File("Composite.java", 200)));
        hanako.add(new File("memo.txt", 300));
        tom.add(new File("game.doc", 400));
        tom.add((new File("junk.mail", 500)));
        rootDir.accept(new ListVisitor());
    }
}
