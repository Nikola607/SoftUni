package ExamPreparation.bakery.io;


import ExamPreparation.bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
