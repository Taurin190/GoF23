public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("増補改訂版Java言語で学ぶデザインパターン入門"));
        bookShelf.appendBook(new Book("数学ガールの秘密ノート/ビットとバイナリー (数学ガールの秘密ノートシリーズ)"));
        bookShelf.appendBook(new Book("新版C言語プログラミングレッスン 入門編"));
        bookShelf.appendBook(new Book("増補改訂版 Java言語で学ぶデザインパターン入門 マルチスレッド編"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}