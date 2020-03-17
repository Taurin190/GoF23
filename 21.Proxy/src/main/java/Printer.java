public class Printer implements Printable {
    private String name;
    public Printer(String name) {
        this.name = name;
        heavyJob("インスタンス生成中");
    }
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String text) {
        System.out.println("=== " + name + " ===");
        System.out.println(text);
    }
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("完了。");
    }
}
